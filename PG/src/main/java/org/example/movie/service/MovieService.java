package org.example.movie.service;

import org.example.movie.dto.MovieDTO;

import java.sql.SQLException;

public interface MovieService {

    boolean validateAndSave(MovieDTO movieDTO)
            throws SQLException, ClassNotFoundException;
}
