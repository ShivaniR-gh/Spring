package com.xworkz.coreapp.airport;

import com.xworkz.coreapp.airport.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cloud {

    @Autowired
    private Instance instance;

    @Override
    public String toString() {
        return "Cloud{instance=" + instance + "}";
    }
}
