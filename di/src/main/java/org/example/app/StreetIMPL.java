package org.example.app;

import org.springframework.stereotype.Component;

@Component
public class StreetIMPL implements Street {
       private int id;
    private String streetName;


        @Override
        public void getStreet() {
            System.out.println("The Street is invoked");
        }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getId() {
        return id;
    }

    public String getStreetName() {
        return streetName;
    }

}
