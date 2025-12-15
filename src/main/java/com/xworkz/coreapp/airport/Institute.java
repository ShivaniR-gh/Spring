package com.xworkz.coreapp.airport;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
    @Scope("prototype")
    public class Institute {

        @Autowired
        private Trainee trainee;

        public Institute() {
            System.out.println("Institute bean created");
        }

        @Override
        public String toString() {
            return "Institute{" +
                    "trainee=" + trainee +
                    '}';
        }
    }

