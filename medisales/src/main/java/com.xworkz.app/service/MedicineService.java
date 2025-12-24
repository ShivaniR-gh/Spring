package com.xworkz.app.service;

import com.xworkz.app.dto.MedicineDTO;

import java.sql.SQLException;
import java.util.Optional;

public interface MedicineService {
    boolean validateAndSave(MedicineDTO medicineDTO) throws Exception;

    default Optional<MedicineDTO> getMedicineName(String medicineName) throws SQLException, ClassNotFoundException {
        return Optional.empty();
    }

    default Optional<MedicineDTO> getMedicineById(int medicineId) throws SQLException, ClassNotFoundException {
        return Optional.empty();
    }

    default boolean updateMedicine(MedicineDTO medicineDTO) throws Exception {
        return false;
    }


}
