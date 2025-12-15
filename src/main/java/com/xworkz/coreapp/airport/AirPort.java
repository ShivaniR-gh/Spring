package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class AirPort {

    @Autowired
    private Terminal terminal;

    private int num;
    private String name;

    public AirPort() {
        System.out.println("AirPort default constructor invoked");
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AirPort{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", terminal=" + terminal +
                '}';
    }
}
