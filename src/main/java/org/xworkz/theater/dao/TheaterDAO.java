package org.xworkz.theater.dao;

import org.xworkz.theater.dto.TheaterDTO;

import java.sql.SQLException;

public interface TheaterDAO {
    boolean save(TheaterDTO theaterDTO)
            throws ClassNotFoundException, SQLException;
}
