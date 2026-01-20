package com.xworkz.ShivaniRApp.repo.impl;

import com.xworkz.ShivaniRApp.entity.AppEntity;
import com.xworkz.ShivaniRApp.repo.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Repository
public class AppRepositoryImpl implements AppRepository {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(AppEntity entity) {
        try {
            EntityManager em = factory.createEntityManager();
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String checkUser(String email) {
        try {
            EntityManager em = factory.createEntityManager();
            Query query = em.createNamedQuery("checkUserExists");
            query.setParameter("email", email);
            return (String) query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void updateCount(String email) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("updateCount");
        query.setParameter("eMail", email);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public int getCount(String email) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createNamedQuery("getCount");
        return (int) query.setParameter("eMail", email).getSingleResult();
    }

    @Override
    public void setCountToZero(String email) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createNamedQuery("setCountToZero");
        query.setParameter("eMail", email);
        query.executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public boolean checkUserExistsByEmail(String email) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createNamedQuery("checkUserExistsByEmail");
        long count = (long) query.setParameter("email", email).getSingleResult();
        return count > 0;
    }

    @Override
    public boolean checkUserExistsByPhone(String phoneNumber) {
        EntityManager em = factory.createEntityManager();
        Query query = em.createNamedQuery("checkUserExistsByPhone");
        long count = (long) query.setParameter("phNo", phoneNumber).getSingleResult();
        return count > 0;
    }
}
