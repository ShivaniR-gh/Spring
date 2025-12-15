package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Doctor {

    public Doctor() {
        System.out.println("Doctor bean created");
    }

    @Override
    public String toString() {
        return "Doctor{}";
    }
}
