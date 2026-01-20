package com.xworkz.ShivaniRApp.controller;

import com.xworkz.ShivaniRApp.dto.AppDTO;
import com.xworkz.ShivaniRApp.exceptions.DataInvalidException;
import com.xworkz.ShivaniRApp.exceptions.UserAlreadyExistsException;
import com.xworkz.ShivaniRApp.exceptions.UserNotFoundException;
import com.xworkz.ShivaniRApp.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class AppController implements WebMvcConfigurer {

    @Autowired
    private AppService appService;

    /* ====== PAGES ====== */

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/signUp")
    public String signUpPage() {
        return "Register";
    }

    @RequestMapping("/signInPage")
    public String signInPage() {
        return "Login";
    }

    @RequestMapping("/signInWithOTP")
    public String forgotPasswordPage() {
        return "OtpPage";
    }

    /* ====== REGISTER ====== */

    @PostMapping("/registerUser")
    public ModelAndView registerUser(
            @Valid AppDTO dto,
            BindingResult bindingResult,
            ModelAndView model) {

        try {
            if (bindingResult.hasErrors()) {
                bindingResult.getFieldErrors()
                        .forEach(error ->
                                model.addObject(
                                        error.getField() + "Error",
                                        error.getDefaultMessage()));
                model.setViewName("Register");
                return model;
            }

            appService.checkUserExistsByEmail(dto.getEmail());
            appService.checkUserExistsByPhone(dto.getPhoneNumber());

            boolean saved = appService.validateAndSave(dto);

            if (saved) {
                model.setViewName("Login");
            }

        } catch (DataInvalidException | UserAlreadyExistsException e) {
            model.addObject("errorMsg", e.getMessage());
            model.setViewName("Register");
        }

        return model;
    }

    /* ====== LOGIN ====== */

    @PostMapping("/signIn")
    public String signIn(
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model) {

        try {
            boolean valid = appService.checkUser(email, password);
            if (valid) {
                appService.setCountToZero(email);
                return "Home";
            }
        } catch (UserNotFoundException e) {

            int count = appService.getCount(email);
            model.addAttribute("email", email);
            model.addAttribute("errorMsg", e.getMessage());

            if (count >= 2) {
                model.addAttribute("disableLogin", true);
                model.addAttribute("showForgot", true);
            } else {
                appService.updateCount(email);
            }
        }
        return "Login";
    }
}
