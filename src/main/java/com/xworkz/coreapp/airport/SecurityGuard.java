package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SecurityGuard {

    @Override
    public String toString() {
        return "SecurityGuard{}";
    }
}
