package com.xworkz.app.config;

import com.xworkz.app.dto.MedicineDTO;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.xworkz.app")
public class MedicineConfigure {
    public MedicineConfigure(){
        System.out.println("The MedicineConfigure object is invoked.....");
    }
}
