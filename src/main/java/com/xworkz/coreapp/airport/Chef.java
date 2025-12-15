package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Chef {

    public Chef() {
        System.out.println("Chef bean created");
    }

    @Override
    public String toString() {
        return "Chef{}";
    }
}
