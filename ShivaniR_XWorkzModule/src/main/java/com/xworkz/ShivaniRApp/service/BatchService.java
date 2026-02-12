package com.xworkz.ShivaniRApp.service;


import com.xworkz.ShivaniRApp.entity.BatchEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

    public interface BatchService {

        void saveBatch(String batchName, String startDate, String endDate,
                       MultipartFile photo) throws Exception;

        List<BatchEntity> getAllBatches();

        BatchEntity getBatchById(int id);

        public byte[] getBatchPhoto(int batchId);

    }
