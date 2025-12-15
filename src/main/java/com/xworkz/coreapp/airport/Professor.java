package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Professor {
    public Professor() {
        System.out.println("Professor bean created");
    }
    @Override
    public String toString() {
        return "Professor{}";
    }
}

