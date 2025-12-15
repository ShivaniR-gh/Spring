package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Mobile {

    @Autowired
    private SimCard simCard;

    @Override
    public String toString() {
        return "Mobile{simCard=" + simCard + "}";
    }
}
