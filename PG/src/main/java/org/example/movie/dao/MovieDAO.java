package org.example.movie.dao;

import org.example.movie.dto.MovieDTO;

import java.sql.SQLException;

public interface MovieDAO {
    boolean save(MovieDTO movieDTO)
            throws SQLException, ClassNotFoundException;
}
