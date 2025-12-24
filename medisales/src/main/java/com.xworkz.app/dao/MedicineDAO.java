package com.xworkz.app.dao;

import com.xworkz.app.dto.MedicineDTO;

 med
import java.sql.SQLException;
import java.util.Optional;

public interface MedicineDAO {
    boolean save(MedicineDTO medicineDTO) throws ClassNotFoundException;

    default Optional<MedicineDTO> findByName(String medicineName) throws ClassNotFoundException, SQLException {
        return Optional.empty();
    }

    default Optional<MedicineDTO> findById(int medicineId) throws ClassNotFoundException, SQLException {
        return Optional.empty();
    }

    boolean update(MedicineDTO medicineDTO);


public interface MedicineDAO {
    boolean save(MedicineDTO medicineDTO) throws ClassNotFoundException;
 main
}
