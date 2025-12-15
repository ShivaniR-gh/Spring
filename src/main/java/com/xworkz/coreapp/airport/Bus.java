package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Bus {

    @Autowired
    private Driver driver;

    @Override
    public String toString() {
        return "Bus{driver=" + driver + "}";
    }
}
