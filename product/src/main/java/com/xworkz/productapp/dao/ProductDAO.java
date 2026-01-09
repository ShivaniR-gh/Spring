package com.xworkz.productapp.dao;

import com.xworkz.productapp.entity.ProductEntity;

public interface ProductDAO {

    boolean save(ProductEntity entity);

    boolean update(ProductEntity entity);

    boolean delete(ProductEntity entity);

    ProductEntity read(int id);
}
