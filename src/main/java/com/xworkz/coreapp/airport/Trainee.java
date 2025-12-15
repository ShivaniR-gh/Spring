package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


    @Component
    @Scope("prototype")
    public class Trainee {

        public Trainee() {
            System.out.println("Trainee bean created");
        }

        @Override
        public String toString() {
            return "Trainee{}";
        }
    }

