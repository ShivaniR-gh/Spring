package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {

    public Student() {
        System.out.println("Student bean created");
    }

    @Override
    public String toString() {
        return "Student{}";
    }
}

