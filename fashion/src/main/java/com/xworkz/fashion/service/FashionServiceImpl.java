package com.xworkz.fashion.service;

import com.xworkz.fashion.dao.FashionDAO;
import com.xworkz.fashion.dao.FashionDAOImpl;
import com.xworkz.fashion.dto.FashionDTO;
import com.xworkz.fashion.entity.FashionEntity;
import org.springframework.beans.BeanUtils;

import javax.persistence.EntityManager;

public class FashionServiceImpl implements FashionService {
    private final FashionDAO fashionDAO =new FashionDAOImpl();
    @Override
    public boolean validateAndSave(FashionDTO fashionDTO) {

        if(fashionDTO != null) {
            FashionEntity entity = new FashionEntity();
            BeanUtils.copyProperties(entity, fashionDTO);
            return fashionDAO.save(entity);
        }
        return false;
    }

    @Override
    public boolean update(FashionDTO fashionDTO) {
        if(fashionDTO != null) {
            FashionEntity entity = new FashionEntity();
            BeanUtils.copyProperties(entity, fashionDTO);
            return fashionDAO.update(entity);
        }
        return false;
    }

    @Override
    public boolean read(int id) {
        if(id != 0){
            FashionEntity entity = new FashionEntity();
            BeanUtils.copyProperties(entity , id);
            return fashionDAO.read(id);
        }
        return false;
    }

    @Override
    public boolean delete(FashionDTO fashionDTO) {
        if(fashionDTO != null){
            FashionEntity entity = new FashionEntity();
            BeanUtils.copyProperties(entity ,fashionDTO);
            return  fashionDAO.delete(entity);
        }
        return false;
    }

}






















