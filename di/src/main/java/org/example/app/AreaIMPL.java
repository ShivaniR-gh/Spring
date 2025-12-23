package org.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AreaIMPL implements Area{
    private int id;
    private String areaName;
    @Autowired
    Street street;
    @Override
    public void getArea() {
        street.getStreet();
        System.out.println("Area is invoked");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getId() {
        return id;
    }

    public String getAreaName() {
        return areaName;
    }

    public Street getStreet() {
        return street;
    }
}
