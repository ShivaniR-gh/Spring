package org.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityImpl implements City{
    private int id;
    private String cityName;
    @Autowired
    Area area;
    @Override
    public void getCity() {
        area.getArea();
        System.out.println("the city is invoked");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getId() {
        return id;
    }

    public Area getArea() {
        return area;
    }

    public String getCityName() {
        return cityName;
    }
}
