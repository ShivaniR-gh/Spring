package com.xworkz.app.service;

import com.xworkz.app.dto.ClothesDTO;

public interface ClothesService {
    boolean validateAndSave(ClothesDTO clothesDTO) throws Exception;

}
