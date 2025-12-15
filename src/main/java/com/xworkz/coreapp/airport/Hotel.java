package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Hotel {

    @Autowired
    private Room room;

    public Hotel() {
        System.out.println("Hotel bean created");
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "room=" + room +
                '}';
    }
}
