package com.xworkz.productapp.service;

import com.xworkz.productapp.dao.ProductDAO;
import com.xworkz.productapp.dao.ProductDAOImpl;
import com.xworkz.productapp.dto.ProductDTO;
import com.xworkz.productapp.entity.ProductEntity;
import org.springframework.beans.BeanUtils;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO = new ProductDAOImpl();

    @Override
    public boolean save(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(dto, entity);
        return productDAO.save(entity);
    }

    @Override
    public boolean update(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(dto, entity);
        return productDAO.update(entity);
    }

    @Override
    public boolean delete(ProductDTO dto) {
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(dto, entity);
        return productDAO.delete(entity);
    }

    @Override
    public ProductDTO findById(int id) {
        ProductEntity entity = productDAO.read(id);
        if (entity != null) {
            ProductDTO dto = new ProductDTO();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }
        return null;
    }
}
