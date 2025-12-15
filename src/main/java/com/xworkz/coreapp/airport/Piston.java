package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Piston {
    Piston(){
        System.out.println("Default constructor");
    }
    @Override
    public String toString() {
        return "Piston{}";
    }
}
