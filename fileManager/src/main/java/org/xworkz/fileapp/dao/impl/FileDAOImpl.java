package org.xworkz.fileapp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.xworkz.fileapp.dao.FileDAO;
import org.xworkz.fileapp.dto.FileDTO;

import java.sql.*;

import static org.xworkz.fileapp.DB.DBConstant.*;

@Component
public class FileDAOImpl implements FileDAO {

    @Override
    public boolean save(FileDTO fileDTO)
            throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String sql = "insert into file (fileId, fileName, fileSize, fileType) values (?, ?, ?, ?)";

        try (Connection connection =
                     DriverManager.getConnection(
                             URL.getValue(), USERNAME.getValue(),PASSWORD.getValue())) {

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setInt(1, fileDTO.getFileID());
            ps.setString(2, fileDTO.getFileName());
            ps.setString(3, fileDTO.getFileSize());
            ps.setString(4, fileDTO.getFileType());

            int rows = ps.executeUpdate();
            System.out.println(rows);

            return rows > 0;
        }
    }
}
