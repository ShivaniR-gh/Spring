package com.xworkz.fashion.service;

import com.xworkz.fashion.dto.FashionDTO;

public interface FashionService {
    boolean validateAndSave(FashionDTO fashionDTO);
    boolean update(FashionDTO fashionDTO);
    boolean read(int id);
    boolean delete(FashionDTO fashionDTO);
}
