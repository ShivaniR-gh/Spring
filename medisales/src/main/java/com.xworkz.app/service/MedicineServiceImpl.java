package com.xworkz.app.service;

import com.xworkz.app.dao.MedicineDAO;
import com.xworkz.app.dto.MedicineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MedicineServiceImpl implements MedicineService{
    @Autowired
    MedicineDAO medicineDAO;
    @Override
    public boolean validateAndSave(MedicineDTO medicineDTO) throws Exception {


        boolean isInvalid = false;

        if(medicineDTO.getMedicineName().length() < 0){
            isInvalid = true;
        } else if (medicineDTO.getPrice() == 0) {
            isInvalid = true;
        } else if (medicineDTO.getExpiryDate() == null) {
            isInvalid = true;
        }else if (medicineDTO.getMg() == null){
            isInvalid = true;
        }
        if (isInvalid){
            throw new Exception("The entered data is not valid");
        }
        boolean saved = medicineDAO.save(medicineDTO);

        return  saved;

    }
}
