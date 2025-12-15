package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Warehouse {

    @Autowired
    private Inventory inventory;

    public Warehouse() {
        System.out.println("Warehouse bean created");
    }

    @Override
    public String toString() {
        return "Warehouse{inventory=" + inventory + "}";
    }
}

