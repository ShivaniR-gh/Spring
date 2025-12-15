package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ApplicationServer {

    @Autowired
    private ThreadPool threadPool;

    @Override
    public String toString() {
        return "ApplicationServer{threadPool=" + threadPool + "}";
    }
}
