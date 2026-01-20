package com.xworkz.ShivaniRApp.service.impl;

import com.xworkz.ShivaniRApp.dto.AppDTO;
import com.xworkz.ShivaniRApp.entity.AppEntity;
import com.xworkz.ShivaniRApp.exceptions.DataInvalidException;
import com.xworkz.ShivaniRApp.exceptions.UserAlreadyExistsException;
import com.xworkz.ShivaniRApp.exceptions.UserNotFoundException;
import com.xworkz.ShivaniRApp.repo.AppRepository;
import com.xworkz.ShivaniRApp.service.AppService;
import com.xworkz.ShivaniRApp.util.PasswordCipherUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    private AppRepository appRepository;

    @Autowired
    private PasswordCipherUtil passwordCipherUtil;

    private boolean validateUserInfo(AppDTO dto) {
        if (!dto.getPassword().equals(dto.getConfirmPassword())) {
            throw new DataInvalidException("Password does not match");
        }
        return true;
    }

    @Override
    public boolean validateAndSave(AppDTO dto) {

        boolean valid = validateUserInfo(dto);

        if (valid) {
            String encrypted = passwordCipherUtil.encrypt(dto.getPassword());
            dto.setPassword(encrypted);

            AppEntity entity = new AppEntity();
            BeanUtils.copyProperties(dto, entity);

            return appRepository.save(entity);
        }
        return false;
    }

    @Override
    public boolean checkUser(String email, String password) {

        if (email == null || email.isEmpty())
            throw new UserNotFoundException("Invalid email");

        if (password == null || password.isEmpty())
            throw new UserNotFoundException("Invalid password");

        String dbPassword = appRepository.checkUser(email);

        if (dbPassword != null && !dbPassword.isEmpty()) {
            String decrypted = passwordCipherUtil.decrypt(dbPassword);
            if (decrypted.equals(password)) {
                return true;
            } else {
                int count = appRepository.getCount(email);
                throw new UserNotFoundException(
                        "Invalid password, you have " + (3 - (count + 1)) + " attempts!!"
                );
            }
        }
        throw new UserNotFoundException("User Not Found!!");
    }

    @Override
    public void updateCount(String email) {
        appRepository.updateCount(email);
    }

    @Override
    public int getCount(String email) {
        return appRepository.getCount(email);
    }

    @Override
    public void setCountToZero(String email) {
        appRepository.setCountToZero(email);
    }

    @Override
    public boolean checkUserExistsByEmail(String email) {
        boolean exists = appRepository.checkUserExistsByEmail(email);
        if (exists)
            throw new UserAlreadyExistsException("Email Already Exists");
        return true;
    }

    @Override
    public boolean checkUserExistsByPhone(String phoneNumber) {
        boolean exists = appRepository.checkUserExistsByPhone(phoneNumber);
        if (exists)
            throw new UserAlreadyExistsException("Contact Number Already Exists");
        return true;
    }
}
