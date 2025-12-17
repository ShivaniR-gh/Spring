package org.xworkz.theater;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.xworkz.theater.config.TheaterConfig;
import org.xworkz.theater.controller.TheaterController;

public class TheaterRunner {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(TheaterConfig.class);

        TheaterController controller =
                context.getBean(TheaterController.class);

        controller.execute();
    }
}
