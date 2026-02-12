package com.xworkz.ShivaniRApp.service.impl;

import com.xworkz.ShivaniRApp.entity.BatchEntity;
import com.xworkz.ShivaniRApp.entity.StudentEntity;
import com.xworkz.ShivaniRApp.repo.BatchRepository;
import com.xworkz.ShivaniRApp.repo.StudentRepository;
import com.xworkz.ShivaniRApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private BatchRepository batchRepository;

    // ================= ADD STUDENT WITH PHOTO =================

    public void addStudent(String name, String email, String phone,
                           int batchId, MultipartFile photo) throws IOException {

        StudentEntity entity = new StudentEntity();
        entity.setName(name);
        entity.setEmail(email);
        entity.setPhone(phone);
        entity.setBatch(batchRepository.findById(batchId));

        String baseDir = "E:/SpringPrograms/ShivaniR_XWorkzModule/pics/students/";

        File folder = new File(baseDir);
        if (!folder.exists()) {
            folder.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();
        photo.transferTo(new File(baseDir + fileName));

        entity.setPhotoPath("pics/students/" + fileName);

        studentRepository.save(entity);
    }


    // ================= GET STUDENTS BY BATCH =================
    @Override
    public List<StudentEntity> getStudentsByBatch(int batchId) {
        return studentRepository.findByBatch(batchId);
    }

    // ================= GET PHOTO =================
    @Override
    public byte[] getStudentPhoto(int studentId) {

        // 1. Get photo path from DB
        String photoPath = studentRepository.findPhotoPathByStudentId(studentId);

        if (photoPath == null) {
            return null;
        }

        // 2. Read image from file system
        try {
            Path fullPath = Paths.get(
                    "E:/SpringPrograms/ShivaniR_XWorkzModule/" + photoPath
            );
            return Files.readAllBytes(fullPath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteStudent(int studentId) {
        studentRepository.deleteById(studentId);
    }

    @Override
    public StudentEntity getStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }
    @Override
    public void updateStudent(StudentEntity student) {
        studentRepository.update(student);
    }

}
