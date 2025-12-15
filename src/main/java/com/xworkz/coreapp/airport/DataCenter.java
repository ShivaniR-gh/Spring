package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DataCenter {

    @Autowired
    private RackUnit rackUnit;

    @Override
    public String toString() {
        return "DataCenter{rackUnit=" + rackUnit + "}";
    }
}
