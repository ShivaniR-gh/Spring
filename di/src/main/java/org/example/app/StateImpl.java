package org.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StateImpl implements State{

    private int id;
    private  String stateName;
    @Autowired
    City city;
    @Override
    public void getState() {
        city.getCity();
        System.out.println("State is invoked.....");
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getId() {
        return id;
    }

    public String getStateName() {
        return stateName;
    }

    public City getCity() {
        return city;
    }
}
