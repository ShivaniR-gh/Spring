package com.xworkz.app.config;

public enum DBConstant {
        URL("jdbc:mysql://localhost:3306/medicine_db"),
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
