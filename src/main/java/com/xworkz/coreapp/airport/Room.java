package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Room {

    public Room() {
        System.out.println("Room bean created");
    }

    @Override
    public String toString() {
        return "Room{}";
    }
}
