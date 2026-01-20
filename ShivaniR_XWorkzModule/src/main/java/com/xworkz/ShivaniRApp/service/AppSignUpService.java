package com.xworkz.ShivaniRApp.service;

import com.xworkz.ShivaniRApp.dto.AppDTO;
import com.xworkz.ShivaniRApp.entity.AppEntity;

public interface AppSignUpService {
    boolean register(AppDTO appDTO);
    boolean login(AppDTO appDTO);
}
