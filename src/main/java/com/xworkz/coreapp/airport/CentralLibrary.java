package com.xworkz.coreapp.airport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CentralLibrary {

    @Autowired
    private Librarian librarian;

    @Override
    public String toString() {
        return "CentralLibrary{librarian=" + librarian + "}";
    }
}

