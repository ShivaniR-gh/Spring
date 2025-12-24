package com.xworkz.app.service;

import com.xworkz.app.dao.MedicineDAO;
import com.xworkz.app.dto.MedicineDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
  med
import java.sql.SQLException;
import java.util.Optional;

@Component
public class MedicineServiceImpl implements MedicineService {
    @Autowired
    MedicineDAO medicineDAO;
 

@Component
public class MedicineServiceImpl implements MedicineService{
    @Autowired
    MedicineDAO medicineDAO;
 main
    @Override
    public boolean validateAndSave(MedicineDTO medicineDTO) throws Exception {


        boolean isInvalid = false;

  med
        if (medicineDTO.getMedicineName() == null || medicineDTO.getMedicineName().trim().isEmpty()) {
            isInvalid = true;
        }
        else if (medicineDTO.getMedicineName().length() > 50) {
            isInvalid = true;
        }
        else if (medicineDTO.getPrice() <= 0) {
            isInvalid = true;
        }
        else if (medicineDTO.getMg() == null || medicineDTO.getMg().trim().isEmpty()) {
            isInvalid = true;
        }
        else if (medicineDTO.getExpiryDate() == null || medicineDTO.getExpiryDate().trim().isEmpty()) {
            isInvalid = true;
        }

        if (isInvalid) {
 
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
  main
            throw new Exception("The entered data is not valid");
        }
        boolean saved = medicineDAO.save(medicineDTO);

 med
        return saved;

    }

    @Override
    public Optional<MedicineDTO> getMedicineName(String medicineName) throws SQLException, ClassNotFoundException {


        boolean isInvalid = false;

        if ( medicineName == null || medicineName.isEmpty()) {
            System.out.println("The given data is invalid");
            isInvalid = true;
        }
        if (!isInvalid) {
            System.out.println("The given data is valid");
            Optional<MedicineDTO> optionalFishDTO = this.medicineDAO.findByName(medicineName);
            System.out.println("optionalFishDTO :" + optionalFishDTO.isPresent());
            return optionalFishDTO;
        }
        return MedicineService.super.getMedicineName(medicineName);

    }
    @Override
    public Optional<MedicineDTO> getMedicineById(int medicineID) throws SQLException, ClassNotFoundException {


        boolean isInvalid = false;

        if (medicineID == 0) {
            System.out.println("The given data is invalid");
            isInvalid = true;
        }
        if (!isInvalid) {
            System.out.println("The given data is valid");
            Optional<MedicineDTO> optionalFishDTO = this.medicineDAO.findById(medicineID);
            System.out.println("optionalFishDTO :" + optionalFishDTO.isPresent());
            return optionalFishDTO;
        }
        return MedicineService.super.getMedicineById(medicineID);

    }

    @Override
    public boolean updateMedicine(MedicineDTO medicineDTO) throws Exception {
        boolean isInvalid = false;

        if (medicineDTO.getMedicineName() == null || medicineDTO.getMedicineName().trim().isEmpty()) {
            isInvalid = true;
        }
        else if (medicineDTO.getPrice() <= 0) {
            isInvalid = true;
        }
        else if (medicineDTO.getMg() == null || medicineDTO.getMg().trim().isEmpty()) {
            isInvalid = true;
        }
        else if (medicineDTO.getExpiryDate() == null || medicineDTO.getExpiryDate().trim().isEmpty()) {
            isInvalid = true;
        }

        if (isInvalid) {
            throw new Exception("Invalid data");
        }
        return medicineDAO.update(medicineDTO);
 
        return  saved;
  main

    }
}
