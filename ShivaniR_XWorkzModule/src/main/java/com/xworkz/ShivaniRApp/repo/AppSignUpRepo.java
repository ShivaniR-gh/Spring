package com.xworkz.ShivaniRApp.repo;

import com.xworkz.ShivaniRApp.dto.AppDTO;
import com.xworkz.ShivaniRApp.entity.AppEntity;

public interface AppSignUpRepo {
    boolean register(AppEntity entity);

    AppEntity findByEmail(String email);
    boolean login(AppDTO appDTO);
}
