package com.xworkz.ShivaniRApp.controller;

import com.xworkz.ShivaniRApp.dto.AppDTO;
import com.xworkz.ShivaniRApp.service.AppSignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class AppController {
    @Autowired
    AppSignUpService appSignUpService;
    @GetMapping ("/home")
    public String Home(){
        return "index";
    }
    @GetMapping("/signin")
    public String signInPage(){
        return "SignIn";
    }
    @GetMapping("/signup")
    public String signup(){
        return "SignUp";
    }

    @PostMapping("/register")
    public String register(AppDTO appDTO){
        boolean register = appSignUpService.register(appDTO);

        if(register){
            return  "Home";
        }else {
            return "SignUp";
        }
    }
}






