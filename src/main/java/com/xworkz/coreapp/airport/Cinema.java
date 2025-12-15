package com.xworkz.coreapp.airport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cinema {

    @Autowired
    private Screen screen;

    @Override
    public String toString() {
        return "Cinema{screen=" + screen + "}";
    }
}

