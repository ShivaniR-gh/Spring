package org.xworkz.fileapp.dao;

import org.xworkz.fileapp.config.FileConfigure;
import org.xworkz.fileapp.dto.FileDTO;

import java.sql.SQLException;

public interface FileDAO {
    boolean save(FileDTO fileDTO) throws ClassNotFoundException, SQLException;
}
