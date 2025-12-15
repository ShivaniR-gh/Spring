package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Network {

    @Autowired
    private Router router;

    @Override
    public String toString() {
        return "Network{router=" + router + "}";
    }
}
