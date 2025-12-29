package com.xworkz.jobapp.controller;

import com.xworkz.jobapp.dto.JobSeekerDTO;
import com.xworkz.jobapp.service.JobAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class JobAccountController {

    @Autowired
    private JobAccountService service;

    public JobAccountController() {
        System.out.println("JobAccountController created");
    }


    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/searchPage")
    public String openSearchPage() {
        return "search";
    }

    @PostMapping("/addAccount")
    public String addAccount(JobSeekerDTO dto) {

        boolean saved = service.validateAndSave(dto);

        if (saved) {
            return "Response";
        } else {
            return "Error";
        }
    }

    @GetMapping("/search")
    public String searchByEmail(@RequestParam("email") String email,
                                Model model) {

        Optional<JobSeekerDTO> dto = service.findByEmail(email);

        if (dto.isPresent()) {
            model.addAttribute("job", dto.get());
        } else {
            model.addAttribute("error", "No record found");
        }
        return "search";
    }

    @GetMapping("/getAll")
    public String getAll(Model model) {

        List<JobSeekerDTO> list = service.findAll();
        model.addAttribute("list", list);

        return "search";
    }

    @GetMapping("/edit")
    public String editByEmail(@RequestParam("email") String email,
                              Model model) {

        Optional<JobSeekerDTO> dto = service.findByEmail(email);

        if (dto.isPresent()) {
            model.addAttribute("job", dto.get());
            return "update";
        } else {
            model.addAttribute("error", "Record not found");
            return "search";
        }
    }


    @PostMapping("/updateAccount")
    public String updateAccount(JobSeekerDTO dto,
                                Model model) {

        boolean updated = service.update(dto);

        if (updated) {
            model.addAttribute("successMessage", "Updated successfully");
        } else {
            model.addAttribute("errorMessage", "Update failed");
        }
        return "update";
    }

    // ================= DELETE =================
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {

        service.deleteById(id);
        return "redirect:/getAll";
    }
}
