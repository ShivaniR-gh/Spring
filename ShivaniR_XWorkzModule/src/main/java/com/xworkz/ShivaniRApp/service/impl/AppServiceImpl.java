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

import java.time.LocalDateTime;

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

        AppEntity entity = appRepository.findByEmail(email);

        if (entity == null) {
            throw new UserNotFoundException("User not found");
        }

        //  Block immediately if already locked
        if (entity.isAccountLocked()) {
            throw new UserNotFoundException("Account is locked. Use Forgot Password");
        }

        String decrypted = passwordCipherUtil.decrypt(entity.getPassword());

        //  SUCCESS LOGIN
        if (decrypted.equals(password)) {
            appRepository.setCountToZero(email); // reset attempts
            return true;
        }

        //  WRONG PASSWORD
        int attempts = entity.getFailedAttempts() + 1;
        appRepository.updateCount(email);

        int remaining = 3 - attempts;

        //  LOCK ON 4TH FAILURE
        if (attempts >= 4) {
            appRepository.lockAccount(email);
            throw new UserNotFoundException("Account locked. Use Forgot Password");
        }

        throw new UserNotFoundException(
                "Invalid password. Attempts left: " + remaining
        );
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
    @Override
    public void saveOtp(String email, String otp, LocalDateTime expiry) {
        appRepository.saveOtp(email, otp, expiry);
    }

    @Override
    public AppEntity findByEmail(String email) {
        return appRepository.findByEmail(email);
    }

    @Override
    public void resetPassword(String email, String rawPassword) {

        AppEntity entity = appRepository.findByEmail(email);

        if (entity == null) {
            throw new UserNotFoundException("User not found");
        }

        // Encrypt NEW password
        String encrypted = passwordCipherUtil.encrypt(rawPassword);

        // Update password + unlock + clear otp + reset attempts
        appRepository.updatePassword(email, encrypted);
    }


    @Override
    public String encryptPassword(String password) {
        return passwordCipherUtil.encrypt(password);
    }

    @Override
    public void clearOtp(String email) {
        appRepository.clearOtp(email);
    }


}






