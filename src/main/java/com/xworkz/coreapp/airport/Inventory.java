package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Inventory {

    public Inventory() {
        System.out.println("Inventory bean created");
    }

    @Override
    public String toString() {
        return "Inventory{}";
    }
}

