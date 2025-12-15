package com.xworkz.coreapp.airport;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = "com.xworkz.coreapp.airport")
public class CoreConfigure {
    CoreConfigure(){
        System.out.println("CoreConfigure invoked");
    }

    public  String getName(){
        return "Java Developer ";
    }
    @Bean
    public Integer getAge(){
        return 22;
    }
    @Bean("theNameGivenAtBean")
    public Integer getPincode(){
        return 560024;
    }


    @Bean
    public List<String> getPlaces() {
        List<String> list = new ArrayList<>();
        list.add("Jayanagara");
        list.add("HRS");
        list.add("JP nagara");
        list.add("Hebbala");
        return list;
    }
}
