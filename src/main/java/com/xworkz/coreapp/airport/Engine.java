package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Engine {

    @Autowired
    private Piston piston;

    @Override
    public String toString() {
        return "Engine{piston=" + piston + "}";
    }
}
