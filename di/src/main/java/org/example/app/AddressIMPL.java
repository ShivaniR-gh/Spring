package org.example.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddressIMPL implements  Address{

    private  int id;
    private String addr;

    @Autowired
    Country country;
    @Override
    public void getAddress() {
        country.getCountry();
        System.out.println("The Address of the patient.....");
    }

    public int getId() {
        return id;
    }

    public String getAddr() {
        return addr;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "AddressIMPL{" +
                "id=" + id +
                ", addr='" + addr + '\'' +
                ", country=" + country +
                '}';
    }
}
