package com.xworkz.app.dao;

import com.xworkz.app.dto.MedicineDTO;

public interface MedicineDAO {
    boolean save(MedicineDTO medicineDTO) throws ClassNotFoundException;
}
