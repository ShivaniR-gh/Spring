package com.xworkz.foodapp.db;

public enum DBConstant {
    URL("jdbc:mysql://localhost:3306/food_db"),
    USER("root"),
    PASSWORD("Shivani@2025");

    private final String value;

    DBConstant(String value){
        this.value=value;
    }

    public String getValue(){
        return value;
    }

}
