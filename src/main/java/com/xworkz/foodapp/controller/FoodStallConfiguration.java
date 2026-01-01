package com.xworkz.foodapp.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz.foodapp")
public class FoodStallConfiguration {
    public FoodStallConfiguration(){
        System.out.println("The object has been created for FoodStallConfiguration ");
    }

    public ViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setSuffix(".jsp");
        viewResolver.setPrefix("/");
        return viewResolver;
    }
}
