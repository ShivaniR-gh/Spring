package org.xworkz.fileapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xworkz.fileapp.dao.FileDAO;
import org.xworkz.fileapp.dto.FileDTO;
import org.xworkz.fileapp.service.FileService;

import java.io.File;
import java.sql.SQLException;

@Component
public class FileServiceImpl implements FileService {

    @Autowired
    FileDAO fileDAO;

    @Override
    public boolean ValidateAndSave(FileDTO fileDTO) throws SQLException, ClassNotFoundException {

        boolean saved=  fileDAO.save(fileDTO);
        return saved;
    }
}
