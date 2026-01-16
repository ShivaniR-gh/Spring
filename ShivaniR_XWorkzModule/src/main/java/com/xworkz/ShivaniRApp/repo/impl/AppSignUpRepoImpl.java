package com.xworkz.ShivaniRApp.repo.impl;

import com.xworkz.ShivaniRApp.dto.AppDTO;
import com.xworkz.ShivaniRApp.entity.AppEntity;
import com.xworkz.ShivaniRApp.repo.AppSignUpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

@Repository
public class AppSignUpRepoImpl implements AppSignUpRepo {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public boolean register(AppEntity entity) {

        EntityManager em = entityManagerFactory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
        return false;
    }

    @Override
    public AppEntity findByEmail(String email) {

        EntityManager em = entityManagerFactory.createEntityManager();
        AppEntity entity = null;

        try {
            Query query = em.createQuery(
                    "SELECT a FROM AppEntity a WHERE a.email = :email");
            query.setParameter("email", email);
            entity = (AppEntity) query.getSingleResult();
        } catch (Exception e) {
            entity = null; // email not found
        } finally {
            em.close();
        }

        return entity;
    }

    @Override
    public boolean login(AppDTO appDTO) {
        return false;
    }
}
