package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Company {

    @Autowired
    private Employee employee;

    public Company() {
        System.out.println("Company bean created");
    }

    @Override
    public String toString() {
        return "Company{" +
                "employee=" + employee +
                '}';
    }
}

