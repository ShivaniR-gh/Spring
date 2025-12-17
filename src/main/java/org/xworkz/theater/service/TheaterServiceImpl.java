package org.xworkz.theater.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xworkz.theater.dao.TheaterDAO;
import org.xworkz.theaterapp.dto.TheaterDTO;

import java.sql.SQLException;

@Component
public class TheaterServiceImpl implements TheaterService {

    @Autowired
    TheaterDAO theaterDAO;
    @Override
    public boolean validateAndSave(TheaterDTO theaterDTO)
            throws SQLException, ClassNotFoundException {

        boolean saved = theaterDAO.save(theaterDTO);
        return saved;
    }
}
