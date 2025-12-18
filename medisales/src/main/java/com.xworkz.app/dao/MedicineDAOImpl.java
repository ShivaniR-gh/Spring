package com.xworkz.app.dao;

import com.xworkz.app.config.DBConstant;
import com.xworkz.app.dto.MedicineDTO;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class MedicineDAOImpl implements MedicineDAO{
    @Override
    public boolean save(MedicineDTO medicineDTO) throws ClassNotFoundException {
        String SQL =
                    "INSERT INTO medicine(name, price, expiryDate, mg) VALUES (?, ?, ?, ?)";

            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(
                    DBConstant.URL.getValue(),
                    DBConstant.USER.getValue(),
                    DBConstant.PASSWORD.getValue())) {

                PreparedStatement ps = connection.prepareStatement(SQL);

                ps.setString(1, medicineDTO.getMedicineName());
                ps.setDouble(2, medicineDTO.getPrice());
                ps.setString(3, medicineDTO.getExpiryDate());
                ps.setString(4, medicineDTO.getMg());

                int row = ps.executeUpdate();
                System.out.println("Rows updated: " + row);

                return row > 0;

            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }




















