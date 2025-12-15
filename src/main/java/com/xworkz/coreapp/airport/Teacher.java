package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Teacher {

    public Teacher() {
        System.out.println("Teacher bean created");
    }

    @Override
    public String toString() {
        return "Teacher{}";
    }
}
