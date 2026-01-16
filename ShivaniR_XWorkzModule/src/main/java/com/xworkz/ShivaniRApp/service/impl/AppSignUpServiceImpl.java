package com.xworkz.ShivaniRApp.service.impl;

import com.xworkz.ShivaniRApp.dto.AppDTO;
import com.xworkz.ShivaniRApp.entity.AppEntity;
import com.xworkz.ShivaniRApp.repo.AppSignUpRepo;
import com.xworkz.ShivaniRApp.service.AppSignUpService;
import com.xworkz.ShivaniRApp.util.PasswordCipherUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppSignUpServiceImpl implements AppSignUpService {

    @Autowired
    private AppSignUpRepo repo;

    //  REGISTER
    @Override
    public boolean register(AppDTO appDTO) {

        if (appDTO == null) return false;

        if (appDTO.getName() == null || appDTO.getName().isEmpty()) return false;
        if (appDTO.getEmail() == null || appDTO.getEmail().isEmpty()) return false;
        if (appDTO.getPhoneNumber() == 0) return false;
        if (appDTO.getGender() == null) return false;
        if (appDTO.getAge() == 0) return false;
        if (appDTO.getPassword() == null || appDTO.getPassword().isEmpty()) return false;

        //  DUPLICATE EMAIL CHECK
        AppEntity existing = repo.findByEmail(appDTO.getEmail());
        if (existing != null) {
            System.out.println("Email already exists");
            return false;
        }

        //  ENCRYPT PASSWORD
        String encryptedPassword = PasswordCipherUtil.encrypt(appDTO.getPassword());

        AppEntity entity = new AppEntity();
        BeanUtils.copyProperties(appDTO, entity);
        entity.setPassword(encryptedPassword);

        return repo.register(entity);
    }

    //  LOGIN
    @Override
    public boolean login(AppDTO appDTO) {

        AppEntity entity = repo.findByEmail(appDTO.getEmail());

        if (entity == null) {
            return false; // email not found
        }

        // ENCRYPT INPUT PASSWORD
        String encryptedInput =
                PasswordCipherUtil.encrypt(appDTO.getPassword());

        return entity.getPassword().equals(encryptedInput);
    }
}
