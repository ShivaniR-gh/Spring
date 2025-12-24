package com.xworkz.app.service;

import com.xworkz.app.dao.ClothesDAO;
import com.xworkz.app.dto.ClothesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClothesServiceImpl implements ClothesService{

    @Autowired
    ClothesDAO clothesDAO;

    @Override
    public boolean validateAndSave(ClothesDTO clothesDTO) throws ClassNotFoundException {

        if (clothesDTO == null) {
            return false;
        }

        if (clothesDTO.getClothesName() == null || clothesDTO.getClothesName().isEmpty()) {
            return false;
        }

        if (clothesDTO.getClothesBrand() == null || clothesDTO.getClothesBrand().isEmpty()) {
            return false;
        }

        if (clothesDTO.getClothesPrice() <= 0) {
            return false;
        }

        if (clothesDTO.getClothesType() == null || clothesDTO.getClothesType().isEmpty()) {
            return false;
        }

        return clothesDAO.save(clothesDTO);
    }

}
