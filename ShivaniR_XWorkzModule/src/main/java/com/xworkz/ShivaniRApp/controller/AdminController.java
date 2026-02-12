package com.xworkz.ShivaniRApp.controller;

import com.xworkz.ShivaniRApp.entity.StudentEntity;
import com.xworkz.ShivaniRApp.service.BatchService;
import com.xworkz.ShivaniRApp.service.EmailService;
import com.xworkz.ShivaniRApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private BatchService batchService;
    @Autowired
    private EmailService emailService;

    @Autowired
    private StudentService studentService;

    // ================= ADMIN LOGIN PAGE =================
    @GetMapping("/adminLogin")
    public String adminLoginPage() {
        return "AdminLogin";
    }

    // ================= ADMIN DASHBOARD =================
    @GetMapping
    public String adminDashboard(HttpSession session) {
        if (!"ADMIN".equals(session.getAttribute("role"))) {
            return "Login";
        }
        return "AdminDashboard";
    }

    // ================= ADMIN LOGIN =================
    @PostMapping("/adminLogin")
    public String adminLogin(@RequestParam String email,
                             @RequestParam String password,
                             HttpSession session,
                             Model model) {

        if ("admin@gmail.com".equals(email) && "admin123".equals(password)) {
            session.setAttribute("role", "ADMIN");
            return "redirect:/admin";
        }

        model.addAttribute("errorMsg", "Invalid Admin Credentials");
        return "AdminLogin";
    }

    // ================= ADD BATCH =================
    @GetMapping("/addBatch")
    public String addBatchPage() {
        return "AddBatch";
    }

    @PostMapping("/addBatch")
    public String saveBatch(@RequestParam String batchName,
                            @RequestParam String startDate,
                            @RequestParam String endDate,
                            @RequestParam("photo") MultipartFile photo,
                            Model model) {

        try {
            batchService.saveBatch(batchName, startDate, endDate, photo);
        } catch (Exception e) {
            model.addAttribute("errorMsg", "Batch creation failed");
            return "AddBatch";
        }

        return "redirect:/admin/viewBatches";
    }


    // ================= VIEW BATCHES =================
    @GetMapping("/viewBatches")
    public String viewBatches(Model model) {
        model.addAttribute("batches", batchService.getAllBatches());
        return "ViewBatches";
    }

    // ================= ADD STUDENT =================
    @GetMapping("/addStudent")
    public String addStudentPage(Model model) {
        model.addAttribute("batches", batchService.getAllBatches());
        return "AddStudent";
    }

    // SINGLE, CORRECT ADD STUDENT METHOD
    @PostMapping("/addStudent")
    public String saveStudent(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phone,
            @RequestParam Integer batchId,
            @RequestParam("photo") MultipartFile photo,
            Model model) {


        if (batchId == null) {
            model.addAttribute("errorMsg", "Please select a batch");
            model.addAttribute("batches", batchService.getAllBatches());
            return "AddStudent";
        }

        try {
            studentService.addStudent(name, email, phone, batchId, photo);
        } catch (Exception e) {
            model.addAttribute("errorMsg", "Student registration failed");
            model.addAttribute("batches", batchService.getAllBatches());
            return "AddStudent";
        }

        return "redirect:/admin/viewBatches";
    }

    // ================= VIEW STUDENTS =================
    @GetMapping("/viewStudents")
    public String viewStudents(@RequestParam int batchId, Model model) {
        model.addAttribute("students", studentService.getStudentsByBatch(batchId));
        return "ViewStudents";
    }
    @GetMapping("/deleteStudent")
    public String deleteStudent(@RequestParam int studentId,
                                @RequestParam int batchId) {

        studentService.deleteStudent(studentId);

        // After delete, reload same batch student list
        return "redirect:/admin/viewStudents?batchId=" + batchId;
    }

    @GetMapping("/editStudent")
    public String editStudent(@RequestParam int studentId,
                              Model model) {

        model.addAttribute("student",
                studentService.getStudentById(studentId));

        model.addAttribute("batches",
                batchService.getAllBatches());

        return "EditStudent";  // New JSP page
    }

    @PostMapping("/updateStudent")
    public String updateStudent(@ModelAttribute StudentEntity student) {

        studentService.updateStudent(student);

        return "redirect:/admin/viewStudents?batchId="
                + student.getBatch().getId();
    }
//    @GetMapping("/emailPage")
//    public String openEmailPage(Model model) {
//
//        model.addAttribute("batches", batchService.getAllBatches());
//
//        return "EmailPage";
//    }
    @PostMapping("/sendEmail")
    public String sendEmail(@RequestParam int batchId,
                            @RequestParam String subject,
                            @RequestParam String body,
                            Model model) {

        emailService.sendEmailToBatch(batchId, subject, body);

        model.addAttribute("message", "Email sent successfully!");
        return "AdminDashboard";
    }
    @GetMapping("/emailPage")
    public String emailPage(Model model) {
        model.addAttribute("batches", batchService.getAllBatches());
        return "EmailPage";
    }

}




