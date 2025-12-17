package org.xworkz.theater.service;

import org.xworkz.theaterapp.dto.TheaterDTO;

import java.sql.SQLException;

public interface TheaterService {
    boolean validateAndSave(TheaterDTO theaterDTO)
            throws SQLException, ClassNotFoundException;
}

