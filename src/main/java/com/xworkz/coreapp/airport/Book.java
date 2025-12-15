package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Book {

    public Book() {
        System.out.println("Book bean created");
    }

    @Override
    public String toString() {
        return "Book{}";
    }
}
