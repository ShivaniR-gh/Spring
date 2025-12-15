package com.xworkz.coreapp.airport;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Account {

    public Account() {
        System.out.println("Account bean created");
    }

    @Override
    public String toString() {
        return "Account{}";
    }
}

