package org.example.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {
    public static void main(String[] args) {

        ApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);

        Patient patient  =  ap.getBean(Patient.class);
        patient.getPatientAddress();
        patient.setId(1);
        patient.setName("xyz");
        System.out.println(patient);






    }
}
