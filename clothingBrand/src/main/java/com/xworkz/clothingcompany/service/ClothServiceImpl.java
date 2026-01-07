package com.xworkz.clothingcompany.service;

import com.xworkz.clothingcompany.dao.ClothDAO;
import com.xworkz.clothingcompany.dao.ClothDAOImpl;
import com.xworkz.clothingcompany.dto.ClothDto;
import com.xworkz.clothingcompany.entity.ClothEntity;

import java.util.List;

public class ClothServiceImpl implements ClothService {

    private final ClothDAO dao = new ClothDAOImpl();

    @Override
    public boolean validateAndSave(ClothDto dto) {

        if (dto == null) {
            System.out.println("DTO is null");
            return false;
        }

        if (dto.getClothName() == null || dto.getClothName().length() < 3) {
            System.out.println("Invalid cloth name");
            return false;
        }

        if (dto.getPrice() <= 0) {
            System.out.println("Invalid price");
            return false;
        }

        ClothEntity entity = new ClothEntity();
        entity.setClothName(dto.getClothName());
        entity.setClothType(dto.getClothType());
        entity.setBrand(dto.getBrand());
        entity.setColor(dto.getColor());
        entity.setSize(dto.getSize());
        entity.setPrice(dto.getPrice());
        entity.setMaterial(dto.getMaterial());
        entity.setGender(dto.getGender());

        return dao.save(entity);
    }

    // -------- Delegating 20 operations --------

    public String getClothTypeByClothName(String name) {
        return dao.getClothTypeByClothName(name);
    }

    public double getClothPriceByClothName(String name) {
        return dao.getClothPriceByClothName(name);
    }

    public String getBrandByClothName(String name) {
        return dao.getBrandByClothName(name);
    }

    public String getColorByClothName(String name) {
        return dao.getColorByClothName(name);
    }

    public String getSizeByClothName(String name) {
        return dao.getSizeByClothName(name);
    }

    public String getMaterialByClothName(String name) {
        return dao.getMaterialByClothName(name);
    }

    public String getGenderByClothName(String name) {
        return dao.getGenderByClothName(name);
    }

    public List<String> getAllClothNames() {
        return dao.getAllClothNames();
    }

    public List<String> getAllBrands() {
        return dao.getAllBrands();
    }

    public List<ClothEntity> getClothsByBrand(String brand) {
        return dao.getClothsByBrand(brand);
    }

    public List<ClothEntity> getClothsByColor(String color) {
        return dao.getClothsByColor(color);
    }

    public List<ClothEntity> getClothsByGender(String gender) {
        return dao.getClothsByGender(gender);
    }

    public List<ClothEntity> getClothsByType(String type) {
        return dao.getClothsByType(type);
    }

    public long countByBrand(String brand) {
        return dao.countByBrand(brand);
    }

    public double getMaxPrice() {
        return dao.getMaxPrice();
    }

    public double getMinPrice() {
        return dao.getMinPrice();
    }

    public double getAveragePrice() {
        return dao.getAveragePrice();
    }

    public boolean updatePriceByName(String name, double price) {
        if (price <= 0) {
            System.out.println("Price must be greater than zero");
            return false;
        }
        return dao.updatePriceByName(name, price);
    }

    public boolean deleteByName(String name) {
        return dao.deleteByName(name);
    }
}
