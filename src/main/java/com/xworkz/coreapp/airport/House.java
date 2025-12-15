package com.xworkz.coreapp.airport;

import com.xworkz.coreapp.airport.Kitchen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class House {

    @Autowired
    private Kitchen kitchen;

    @Override
    public String toString() {
        return "House{kitchen=" + kitchen + "}";
    }
}
