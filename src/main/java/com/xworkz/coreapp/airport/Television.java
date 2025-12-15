package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Television {

    @Autowired
    private Remote remote;

    @Override
    public String toString() {
        return "Television{remote=" + remote + "}";
    }
}
