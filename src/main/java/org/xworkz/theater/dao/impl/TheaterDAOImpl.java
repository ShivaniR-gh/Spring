package org.xworkz.theater.dao.impl;


import org.springframework.stereotype.Component;
import org.xworkz.theater.DB.DBConstant;
import org.xworkz.theater.dao.TheaterDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.mysql.cj.conf.PropertyKey.DBNAME;
import static com.mysql.cj.conf.PropertyKey.PASSWORD;
import static org.xworkz.theater.DB.DBConstant.URL;
import static org.xworkz.theater.DB.DBConstant.USERNAME;

@Component
public class TheaterDAOImpl implements TheaterDAO {

    @Override
    public boolean save(TheaterDTO theaterDTO)
            throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql =
                "insert into theater (theaterId, theaterName, location, screens) values (?, ?, ?, ?)";

        try (Connection connection =
                     DriverManager.getConnection(
                             URL.getValue(), USERNAME.getValue(), DBConstant.PASSWORD.getValue())) {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, theaterDTO.getTheaterId());
            ps.setString(2, theaterDTO.getTheaterName());
            ps.setString(3, theaterDTO.getLocation());
            ps.setInt(4, theaterDTO.getScreens());

            int rows = ps.executeUpdate();
            System.out.println(rows);

            return rows > 0;
        }
    }
}
