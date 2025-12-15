package com.xworkz.coreapp.internet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AC {

    @Autowired
    public AC(@Value("1") int id ,@Value("AC") String name) {
        this.id = id;
        this.name = name;
        System.out.println(id);
        System.out.println(name);
    }

    AC(){
        System.out.println("Default constructor");
    }

    private int id;
    private String name;

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }

    public void setName(String name) { this.name = name; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "AC{id=" + id + ", name='" + name + "'}";
    }
}
