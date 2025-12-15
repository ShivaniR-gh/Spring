package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Office {

    @Autowired
    private Manager manager;

    public Office() {
        System.out.println("Office bean created");
    }

    @Override
    public String toString() {
        return "Office{" +
                "manager=" + manager +
                '}';
    }
}

