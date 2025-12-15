package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Bank {

    @Autowired
    private Account account;

    public Bank() {
        System.out.println("Bank bean created");
    }

    @Override
    public String toString() {
        return "Bank{" +
                "account=" + account +
                '}';
    }
}
