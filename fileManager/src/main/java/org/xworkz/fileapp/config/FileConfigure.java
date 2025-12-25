package org.xworkz.fileapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.xworkz.fileapp")
public class FileConfigure {
    FileConfigure(){
        System.out.println("The configuration invoked");
    }

}
