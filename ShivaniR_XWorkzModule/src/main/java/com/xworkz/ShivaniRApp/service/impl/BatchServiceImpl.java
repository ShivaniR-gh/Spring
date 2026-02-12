package com.xworkz.ShivaniRApp.service.impl;

import com.xworkz.ShivaniRApp.entity.BatchEntity;
import com.xworkz.ShivaniRApp.repo.BatchRepository;
import com.xworkz.ShivaniRApp.service.BatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

    @Service
    public class BatchServiceImpl implements BatchService {

        @Autowired
        private BatchRepository batchRepository;

        @Override
        public void saveBatch(String batchName, String startDate, String endDate,
                              MultipartFile photo) throws Exception {

            BatchEntity batch = new BatchEntity();
            batch.setBatchName(batchName);
            batch.setStartDate(LocalDate.parse(startDate));
            batch.setEndDate(LocalDate.parse(endDate));

            // Folder for batch photos
            String baseDir = "E:/SpringPrograms/ShivaniR_XWorkzModule/pics/batches/";

            File folder = new File(baseDir);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String fileName = System.currentTimeMillis() + "_" + photo.getOriginalFilename();

            // Save file to system
            photo.transferTo(new File(baseDir + fileName));

            // Save ONLY relative path in DB
            batch.setPhotoPath("pics/batches/" + fileName);

            batchRepository.save(batch);
        }


        @Override
        public List<BatchEntity> getAllBatches() {
            return batchRepository.findAll();
        }

        @Override
        public BatchEntity getBatchById(int id) {

            System.out.println("Selected Batch ID: " + id);
            return batchRepository.findById(id);
        }

        @Override
        public byte[] getBatchPhoto(int batchId) {

            BatchEntity batch = batchRepository.findById(batchId);

            if (batch == null || batch.getPhotoPath() == null) {
                return null;
            }

            try {
                Path path = Paths.get(
                        "E:/SpringPrograms/ShivaniR_XWorkzModule/" + batch.getPhotoPath()
                );
                return Files.readAllBytes(path);
            } catch (Exception e) {
                e.printStackTrace();   //  IMPORTANT FOR DEBUG
                return null;
            }
        }


    }

