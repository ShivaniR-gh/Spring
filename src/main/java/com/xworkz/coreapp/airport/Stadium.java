package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Stadium {

    @Autowired
    private Player player;

    @Override
    public String toString() {
        return "Stadium{player=" + player + "}";
    }
}

