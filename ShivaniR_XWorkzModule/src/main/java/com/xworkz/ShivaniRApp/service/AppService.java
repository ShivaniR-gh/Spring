package com.xworkz.ShivaniRApp.service;

import com.xworkz.ShivaniRApp.dto.AppDTO;
import com.xworkz.ShivaniRApp.entity.AppEntity;

import java.time.LocalDateTime;

public interface AppService {

    boolean validateAndSave(AppDTO dto);

    boolean checkUser(String email, String password);

    void updateCount(String email);

    int getCount(String email);

    void setCountToZero(String email);

    boolean checkUserExistsByEmail(String email);

    boolean checkUserExistsByPhone(String phoneNumber);

    void saveOtp(String email, String otp, LocalDateTime expiry);

    AppEntity findByEmail(String email);

    //void updatePassword(String email, String password);

    String encryptPassword(String password);

    void clearOtp(String email);

    void resetPassword(String email, String password);

}
