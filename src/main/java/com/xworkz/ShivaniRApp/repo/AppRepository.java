package com.xworkz.ShivaniRApp.repo;

import com.xworkz.ShivaniRApp.entity.AppEntity;
import java.time.LocalDateTime;

public interface AppRepository {

    boolean save(AppEntity entity);

    String checkUser(String email);

    void updateCount(String email);

    int getCount(String email);

    void setCountToZero(String email);

    boolean checkUserExistsByEmail(String email);

    boolean checkUserExistsByPhone(String phoneNumber);

    // LOCK + OTP
    boolean isAccountLocked(String email);

    void lockAccount(String email);

    void saveOtp(String email, String otp, LocalDateTime expiry);

    AppEntity findByEmail(String email);

    void updatePassword(String email, String password);

    void clearOtp(String email);

}
