package com.xworkz.ShivaniRApp.controller;

import com.xworkz.ShivaniRApp.service.BatchService;
import com.xworkz.ShivaniRApp.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class ImageController {

    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/student/photo/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getPhoto(@PathVariable int id) {

        byte[] photo = studentService.getStudentPhoto(id);

        if (photo == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(photo);
    }
        @Autowired
        private BatchService batchService;   //  MUST be BatchService

        @GetMapping(value = "/batch/photo/{id}", produces = "image/jpeg")
        public ResponseEntity<byte[]> getBatchPhoto(@PathVariable int id) {

            byte[] image = batchService.getBatchPhoto(id);

            if (image == null) {
                return ResponseEntity.notFound().build();
            }

            return ResponseEntity.ok(image);
        }
    }










