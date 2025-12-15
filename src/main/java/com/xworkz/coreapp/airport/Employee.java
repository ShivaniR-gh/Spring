package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee {

    public Employee() {
        System.out.println("Employee bean created");
    }

    @Override
    public String toString() {
        return "Employee{}";
    }
}
