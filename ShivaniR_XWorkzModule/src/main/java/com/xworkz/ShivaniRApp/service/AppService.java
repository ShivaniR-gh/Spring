package com.xworkz.ShivaniRApp.service;

import com.xworkz.ShivaniRApp.dto.AppDTO;

public interface AppService {

    boolean validateAndSave(AppDTO dto);

    boolean checkUser(String email, String password);

    void updateCount(String email);

    int getCount(String email);

    void setCountToZero(String email);

    boolean checkUserExistsByEmail(String email);

    boolean checkUserExistsByPhone(String phoneNumber);
}
