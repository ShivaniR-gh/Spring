package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class College {

    @Autowired
    private Student student;

    public College() {
        System.out.println("College bean created");
    }

    @Override
    public String toString() {
        return "College{" +
                "student=" + student +
                '}';
    }
}

