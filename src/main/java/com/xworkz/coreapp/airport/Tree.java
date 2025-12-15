package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Tree {

    @Override
    public String toString() {
        return "Tree{}";
    }
}
