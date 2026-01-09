package com.xworkz.productapp.service;

import com.xworkz.productapp.dto.ProductDTO;

public interface ProductService {

    boolean save(ProductDTO dto);

    boolean update(ProductDTO dto);

    boolean delete(ProductDTO dto);

    ProductDTO findById(int id);
}
