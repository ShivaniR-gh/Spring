package com.xworkz.jobapp.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.xworkz.jobapp")
public class JobAccountConfiguration {
    public JobAccountConfiguration(){
        System.out.println("The object is created for the JobAccountConfiguration class");
    }

    @Bean
    public ViewResolver viewResolver (){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
