package org.xworkz.fileapp.service;

import org.xworkz.fileapp.dao.FileDAO;
import org.xworkz.fileapp.dto.FileDTO;

import java.sql.SQLException;

public interface FileService {
    boolean ValidateAndSave(FileDTO fileDTO) throws SQLException, ClassNotFoundException;
}
