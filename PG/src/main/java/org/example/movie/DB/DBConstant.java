package org.example.movie.DB;

public enum DBConstant {

    URL("jdbc:mysql://localhost:3306/movie_db"),
    USERNAME("root"),
    PASSWORD("Shivani@2025");

    private final String value;

    DBConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
