package com.shivani.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String sayHello(){
       return "Hello Shivaniiiiiiiiiiiiiiiiiiiiiiiiiii R , How are you ";
    }

}
