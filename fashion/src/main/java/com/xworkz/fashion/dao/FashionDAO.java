package com.xworkz.fashion.dao;

import com.xworkz.fashion.entity.FashionEntity;

public interface FashionDAO {
     boolean save(FashionEntity entity);
     boolean update(FashionEntity entity);
     boolean read(int id);
     boolean delete(FashionEntity entity);

}
