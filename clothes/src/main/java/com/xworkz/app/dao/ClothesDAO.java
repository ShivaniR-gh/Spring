package com.xworkz.app.dao;

import com.xworkz.app.dto.ClothesDTO;

public interface ClothesDAO {
    boolean save(ClothesDTO clothesDTO) throws ClassNotFoundException;
}
