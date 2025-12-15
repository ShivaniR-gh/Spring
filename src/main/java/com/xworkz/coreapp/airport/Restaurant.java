package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Restaurant {

    @Autowired
    private Chef chef;

    public Restaurant() {
        System.out.println("Restaurant bean created");
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "chef=" + chef +
                '}';
    }
}

