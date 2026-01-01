package com.xworkz.foodapp.service;

import com.xworkz.foodapp.dto.FoodStallDTO;

public interface FoodStallService {
    boolean validateAndSave(FoodStallDTO foodStallDTO);
}
