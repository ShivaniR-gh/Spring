package com.xworkz.ShivaniRApp.repo;

import com.xworkz.ShivaniRApp.entity.AppEntity;

public interface AppRepository {

    boolean save(AppEntity entity);

    String checkUser(String email);

    void updateCount(String email);

    int getCount(String email);

    void setCountToZero(String email);

    boolean checkUserExistsByEmail(String email);

    boolean checkUserExistsByPhone(String phoneNumber);
}
