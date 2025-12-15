package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Manager {

    public Manager() {
        System.out.println("Manager bean created");
    }

    @Override
    public String toString() {
        return "Manager{}";
    }
}
