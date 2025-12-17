package org.xworkz.theater.DB;

public enum DBConstant {

    URL("jdbc:mysql://localhost:3306/theater"),
    USERNAME("root"),
    PASSWORD("Shivani@2025");

    private String value;

    DBConstant(String value) {
        this.value = value;
        System.out.println("Database is running");
    }

    public String getValue() {
        return value;
    }
}
