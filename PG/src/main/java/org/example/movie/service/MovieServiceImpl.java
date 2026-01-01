package org.example.movie.service;

import org.example.movie.dao.MovieDAO;
import org.example.movie.dto.MovieDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieDAO movieDAO;

    @Override
    public boolean validateAndSave(MovieDTO movieDTO)
            throws SQLException, ClassNotFoundException {

        return movieDAO.save(movieDTO);
    }
}
