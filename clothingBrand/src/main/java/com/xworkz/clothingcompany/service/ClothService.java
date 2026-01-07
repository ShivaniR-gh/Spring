package com.xworkz.clothingcompany.service;

import com.xworkz.clothingcompany.dto.ClothDto;
import com.xworkz.clothingcompany.entity.ClothEntity;

import java.util.List;

public interface ClothService {

    boolean validateAndSave(ClothDto dto);

    String getClothTypeByClothName(String name);
    double getClothPriceByClothName(String name);
    String getBrandByClothName(String name);
    String getColorByClothName(String name);
    String getSizeByClothName(String name);
    String getMaterialByClothName(String name);
    String getGenderByClothName(String name);

    List<String> getAllClothNames();
    List<String> getAllBrands();
    List<ClothEntity> getClothsByBrand(String brand);
    List<ClothEntity> getClothsByColor(String color);
    List<ClothEntity> getClothsByGender(String gender);
    List<ClothEntity> getClothsByType(String type);

    long countByBrand(String brand);
    double getMaxPrice();
    double getMinPrice();
    double getAveragePrice();

    boolean updatePriceByName(String name, double price);
    boolean deleteByName(String name);
}
