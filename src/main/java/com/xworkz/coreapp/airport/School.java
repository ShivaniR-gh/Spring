package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class School {

    @Autowired
    private Teacher teacher;

    public School() {
        System.out.println("School bean created");
    }

    @Override
    public String toString() {
        return "School{" +
                "teacher=" + teacher +
                '}';
    }
}
