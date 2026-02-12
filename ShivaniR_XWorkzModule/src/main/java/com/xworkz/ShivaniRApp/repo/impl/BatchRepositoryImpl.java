package com.xworkz.ShivaniRApp.repo.impl;

import com.xworkz.ShivaniRApp.entity.BatchEntity;
import com.xworkz.ShivaniRApp.repo.BatchRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class BatchRepositoryImpl implements BatchRepository {

    @PersistenceUnit
    private EntityManagerFactory factory;

    @Override
    public void save(BatchEntity batch) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(batch);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<BatchEntity> findAll() {
        EntityManager em = factory.createEntityManager();
        List<BatchEntity> list =
                em.createQuery("from BatchEntity", BatchEntity.class)
                        .getResultList();
        em.close();
        return list;
    }

    @Override
    public BatchEntity findById(int id) {
        EntityManager em = factory.createEntityManager();
        BatchEntity batch = em.find(BatchEntity.class, id);
        em.close();
        return batch;
    }
}
