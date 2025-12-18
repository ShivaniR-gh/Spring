package com.xworkz.app.service;

import com.xworkz.app.dto.MedicineDTO;

public interface MedicineService {
    boolean validateAndSave(MedicineDTO medicineDTO) throws Exception;
}
