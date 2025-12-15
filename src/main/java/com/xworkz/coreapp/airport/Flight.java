package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Flight {

    @Autowired
    private Pilot pilot;

    @Override
    public String toString() {
        return "Flight{pilot=" + pilot + "}";
    }
}
