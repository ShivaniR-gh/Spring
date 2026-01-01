package com.xworkz.foodapp.service;

import com.xworkz.foodapp.dao.FoodDAO;
import com.xworkz.foodapp.dto.FoodStallDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FoodStallServiceImpl implements FoodStallService {
    @Autowired
    FoodDAO foodDAO;
    @Override
    public boolean validateAndSave(FoodStallDTO foodStallDTO) {

        boolean isInValid = false;
        if(foodStallDTO.getStallName() == null){
            isInValid = true;
        } else if (foodStallDTO.getStallName() == null) {
            isInValid=true;
        } else if (foodStallDTO.getFoodType() == null) {
            isInValid = true;
        } else if (foodStallDTO.getLocation() == null) {
            isInValid = true;
        }
        if (isInValid){
            System.out.println("Please enter the valid data");
        }
        boolean saved = foodDAO.save(foodStallDTO);
        return saved;
    }
}
