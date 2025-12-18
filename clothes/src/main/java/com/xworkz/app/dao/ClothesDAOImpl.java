package com.xworkz.app.dao;

import com.xworkz.app.dto.ClothesDTO;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static com.xworkz.app.DB.DBConstant.*;

@Component
public class ClothesDAOImpl implements ClothesDAO{
    @SneakyThrows
    @Override
    public boolean save(ClothesDTO clothesDTO) throws ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "Insert into clothes (clothesName , clothesPrice , clothesBrand , clothesType ) values (?,?,?,?)";
        try(Connection connection = DriverManager.getConnection(URL.getValue(),USER.getValue(), PASSWORD.getValue())){
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1 , clothesDTO.getClothesName());
            ps.setDouble(2 , clothesDTO.getClothesPrice());
            ps.setString(3 , clothesDTO.getClothesBrand());
            ps.setString(4 , clothesDTO.getClothesType());

            int rows = ps.executeUpdate();
            System.out.println("The updated number of rows are " + rows);
            return  rows > 0 ;

        }

    }
}
