package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Capital {

    @Override
    public String toString() {
        return "Capital{}";
    }
}
