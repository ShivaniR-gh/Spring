package com.xworkz.ShivaniRApp.repo;

import com.xworkz.ShivaniRApp.entity.BatchEntity;
import java.util.List;

public interface BatchRepository {

    void save(BatchEntity batch);

    List<BatchEntity> findAll();

    BatchEntity findById(int id);
}
