package org.xworkz.fileapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.xworkz.fileapp.config.FileConfigure;
import org.xworkz.fileapp.dto.FileDTO;
import org.xworkz.fileapp.service.FileService;

import java.sql.SQLException;

public class FileRunner {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ApplicationContext context = new AnnotationConfigApplicationContext(FileConfigure.class);
        FileDTO fileDTO = new FileDTO();
        fileDTO.setFileID(1);
        fileDTO.setFileName("abc");
        fileDTO.setFileSize("500kb");
        fileDTO.setFileType("PDF");
        System.out.println(fileDTO);

        FileService fileService = context.getBean(FileService.class);
        fileService.ValidateAndSave(fileDTO);
    }
}
