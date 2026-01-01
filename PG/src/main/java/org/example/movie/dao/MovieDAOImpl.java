package org.example.movie.dao;

import org.example.movie.dto.MovieDTO;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.example.movie.DB.DBConstant.*;

@Repository
public class MovieDAOImpl implements MovieDAO {

    @Override
    public boolean save(MovieDTO movieDTO)
            throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "insert into movie (movieID, movieName) values (?, ?)";

        try (Connection connection =
                     DriverManager.getConnection(
                             URL.getValue(),
                             USERNAME.getValue(),
                             PASSWORD.getValue())) {

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, movieDTO.getId());
            ps.setString(2, movieDTO.getName());

            return ps.executeUpdate() > 0;
        }
    }
}
