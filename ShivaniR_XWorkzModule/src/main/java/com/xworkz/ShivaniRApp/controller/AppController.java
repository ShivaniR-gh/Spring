package com.xworkz.ShivaniRApp.controller;

import com.xworkz.ShivaniRApp.dto.AppDTO;
import com.xworkz.ShivaniRApp.entity.AppEntity;
import com.xworkz.ShivaniRApp.exceptions.DataInvalidException;
import com.xworkz.ShivaniRApp.exceptions.UserAlreadyExistsException;
import com.xworkz.ShivaniRApp.exceptions.UserNotFoundException;
import com.xworkz.ShivaniRApp.service.AppService;
import com.xworkz.ShivaniRApp.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Value;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Properties;


@Controller
public class AppController {

    @Value("${mail.username}")
    private String username;

    @Value("${mail.password}")
    private String password;

    @Autowired
    private AppService appService;
    @Autowired
    private BatchService batchService;

    // ===================== BASIC PAGES =====================

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/signUp")
    public String signUpPage() {
        return "Register";
    }

    @GetMapping("/signInPage")
    public String signInPage() {
        return "Login";
    }

    // ===================== REGISTER =====================

    @PostMapping("/registerUser")
    public ModelAndView registerUser(
            @Valid AppDTO dto,
            BindingResult bindingResult,
            ModelAndView model) {

        try {
            if (bindingResult.hasErrors()) {
                bindingResult.getFieldErrors().forEach(error ->
                        model.addObject(error.getField() + "Error", error.getDefaultMessage())
                );
                model.setViewName("Register");
                return model;
            }

            appService.checkUserExistsByEmail(dto.getEmail());
            appService.checkUserExistsByPhone(dto.getPhoneNumber());

            if (appService.validateAndSave(dto)) {
                model.setViewName("Login");
            }

        } catch (DataInvalidException | UserAlreadyExistsException e) {
            model.addObject("errorMsg", e.getMessage());
            model.setViewName("Register");
        }

        return model;
    }

    // ===================== LOGIN =====================

    @PostMapping("/signIn")
    public String signIn(
            @RequestParam String email,
            @RequestParam String password,
            HttpSession session,
            Model model) {

        try {

            if (appService.checkUser(email, password)) {
                session.setAttribute("loggedInEmail", email);
                return "Home";
            }

        } catch (UserNotFoundException e) {

            model.addAttribute("email", email);
            model.addAttribute("errorMsg", e.getMessage());

            //  VERY IMPORTANT PART
            if (e.getMessage().contains("locked")) {
                model.addAttribute("showForgot", true);
                model.addAttribute("disableLogin", true);
            }

        }

        return "Login";
    }


    // ===================== PROFILE =====================

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {

        String email = (String) session.getAttribute("loggedInEmail");

        if (email == null) {
            return "Login";
        }

        AppEntity user = appService.findByEmail(email);
        model.addAttribute("user", user);

        return "Profile";
    }



    // ===================== LOGOUT =====================

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Login";
    }

    // ===================== OTP FLOW =====================

    @GetMapping("/signInWithOTP")
    public String forgotPasswordPage(@RequestParam String email, Model model) {
        model.addAttribute("email", email);
        return "OtpPage";
    }

    @PostMapping("/sendOtp")
    public String sendOtp(@RequestParam String email, Model model) {

        String otp = String.valueOf((int) (Math.random() * 900000) + 100000);
        LocalDateTime expiry = LocalDateTime.now().plusMinutes(5);
        System.out.println("==== DEBUG START ====");
        System.out.println("Injected Username: " + username);
        System.out.println("Injected Password: " + password);
        System.out.println("Email to send: " + email);
        System.out.println("==== DEBUG END ====");


        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.starttls.required", "true");   // ADD THIS
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");    // VERY IMPORTANT
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); // ADD THIS


            Session mailSession = Session.getInstance(props,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(username, password);
                        }
                    });

            Message message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Xworkz OTP Verification");
            message.setText("Your OTP is: " + otp + "\nValid for 5 minutes");
            System.out.println("About to send email...");

            Transport.send(message);

            appService.saveOtp(email, otp, expiry);



        }catch (Exception e) {
            System.out.println("MAIL ERROR OCCURRED");
            e.printStackTrace();  // VERY IMPORTANT
            model.addAttribute("errorMsg", "OTP sending failed");
            return "OtpPage";
        }

        model.addAttribute("email", email);
        model.addAttribute("otpSent", true);
        return "OtpPage";
    }

    @PostMapping("/verifyOtp")
    public String verifyOtp(@RequestParam String email,
                            @RequestParam String otp,
                            Model model) {

        AppEntity entity = appService.findByEmail(email);

        if (entity == null ||
                entity.getOtp() == null ||
                !entity.getOtp().equals(otp) ||
                entity.getOtpExpiry().isBefore(LocalDateTime.now())) {

            model.addAttribute("errorMsg", "Invalid or expired OTP");
            model.addAttribute("email", email);
            return "OtpPage";
        }

        model.addAttribute("email", email);
        return "ResetPassword";
    }

    @PostMapping("/resetPassword")
    public String resetPassword(@RequestParam String email,
                                @RequestParam String password,
                                @RequestParam String confirmPassword,
                                Model model) {

        if (!password.equals(confirmPassword)) {
            model.addAttribute("email", email);
            model.addAttribute("errorMsg", "Passwords do not match");
            return "ResetPassword";
        }

        appService.resetPassword(email, password);
        model.addAttribute("successMsg", "Password reset successful. Please login.");
        return "Login";
    }
}

