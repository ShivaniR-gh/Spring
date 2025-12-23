package org.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountryIMPL implements Country{

    private int code;
    private String countryName;
    @Autowired
    State state;
    @Override
    public void getCountry() {
        state.getState();
        System.out.println("The country is invoked");
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public int getCode() {
        return code;
    }

    public State getState() {
        return state;
    }

    public String getCountryName() {
        return countryName;
    }
}
