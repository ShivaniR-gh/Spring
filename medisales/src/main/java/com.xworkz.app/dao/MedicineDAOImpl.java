package com.xworkz.app.dao;

import com.xworkz.app.config.DBConstant;
import com.xworkz.app.dto.MedicineDTO;
import org.springframework.stereotype.Component;
 med
import java.sql.*;
import java.util.Optional;

@Component
public class MedicineDAOImpl implements MedicineDAO {
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

    @Override
    public Optional<MedicineDTO> findByName(String medicineName)
            throws ClassNotFoundException, SQLException {

        String SQL = "select * from medicine where name = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(
                DBConstant.URL.getValue(),
                DBConstant.USER.getValue(),
                DBConstant.PASSWORD.getValue())) {

            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setString(1, medicineName);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String mg = rs.getString("mg");
                double price = rs.getDouble("price");
                String expiryDate = rs.getString("expiryDate");

                MedicineDTO dto =
                        new MedicineDTO(id, name, mg, price, expiryDate);

                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<MedicineDTO> findById(int medicineId) throws ClassNotFoundException, SQLException {
        String SQL = "select * from medicine where id = ?";

        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = DriverManager.getConnection(
                DBConstant.URL.getValue(),
                DBConstant.USER.getValue(),
                DBConstant.PASSWORD.getValue())) {

            PreparedStatement ps = connection.prepareStatement(SQL);
            ps.setInt(1, medicineId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String mg = rs.getString("mg");
                double price = rs.getDouble("price");
                String expiryDate = rs.getString("expiryDate");

                MedicineDTO dto =
                        new MedicineDTO(id, name, mg, price, expiryDate);

                return Optional.of(dto);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean update(MedicineDTO medicineDTO) {

        String updateSql =  "UPDATE medicine SET name=?, price=?, expiryDate=?, mg=? " +
                        "WHERE id=?";

        try (Connection connection = DriverManager.getConnection(
                DBConstant.URL.getValue(),
                DBConstant.USER.getValue(),
                DBConstant.PASSWORD.getValue())) {

            PreparedStatement ps = connection.prepareStatement(updateSql);


            ps.setString(1,medicineDTO.getMedicineName());
            ps.setDouble(2 , medicineDTO.getPrice());
            ps.setString(3 , medicineDTO.getExpiryDate());
            ps.setString(4 , medicineDTO.getMg());
            ps.setInt(5,medicineDTO.getId());

            System.out.println("Updating DTO: " + medicineDTO);

            int rows = ps.executeUpdate();
            System.out.println("Rows updated: " + rows);

            return  rows > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

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
    } main



















