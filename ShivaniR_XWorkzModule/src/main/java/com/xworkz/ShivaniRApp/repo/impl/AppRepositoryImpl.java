package com.xworkz.ShivaniRApp.repo.impl;

import com.xworkz.ShivaniRApp.entity.AppEntity;
import com.xworkz.ShivaniRApp.repo.AppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class AppRepositoryImpl implements AppRepository {

    @Autowired
    private EntityManagerFactory factory;

    @Override
    public boolean save(AppEntity entity) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        return true;
    }

    @Override
    public String checkUser(String email) {
        try {
            EntityManager em = factory.createEntityManager();
            return (String) em.createNamedQuery("checkUserExists")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void updateCount(String email) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("updateCount")
                .setParameter("eMail", email)
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public int getCount(String email) {
        EntityManager em = factory.createEntityManager();
        return (int) em.createNamedQuery("getCount")
                .setParameter("eMail", email)
                .getSingleResult();
    }

    @Override
    public void setCountToZero(String email) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.createNamedQuery("setCountToZero")
                .setParameter("eMail", email)
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public boolean checkUserExistsByEmail(String email) {
        EntityManager em = factory.createEntityManager();
        long count = (long) em.createNamedQuery("checkUserExistsByEmail")
                .setParameter("email", email)
                .getSingleResult();
        return count > 0;
    }

    @Override
    public boolean checkUserExistsByPhone(String phoneNumber) {
        EntityManager em = factory.createEntityManager();
        long count = (long) em.createNamedQuery("checkUserExistsByPhone")
                .setParameter("phNo", phoneNumber)
                .getSingleResult();
        return count > 0;
    }

    //NEW METHODS

    @Override
    public boolean isAccountLocked(String email) {
        EntityManager em = factory.createEntityManager();
        return (boolean) em.createQuery(
                        "select a.accountLocked from AppEntity a where a.email=:email")
                .setParameter("email", email)
                .getSingleResult();
    }

    @Override
    public void lockAccount(String email) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery(
                        "update AppEntity a set a.accountLocked=true where a.email=:email")
                .setParameter("email", email)
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void saveOtp(String email, String otp, LocalDateTime expiry) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery(
                        "update AppEntity a set a.otp=:otp, a.otpExpiry=:exp where a.email=:email")
                .setParameter("otp", otp)
                .setParameter("exp", expiry)
                .setParameter("email", email)
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public AppEntity findByEmail(String email) {
        EntityManager em = factory.createEntityManager();

        List<AppEntity> list = em.createQuery(
                        "from AppEntity a where a.email = :email", AppEntity.class)
                .setParameter("email", email)
                .getResultList();

        if (list.isEmpty()) {
            return null;
        }

        return list.get(0); // safely return first record
    }


    @Override
    public void updatePassword(String email, String password) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery(
                        "update AppEntity a set a.password=:pwd, " +
                                "a.otp=null, a.otpExpiry=null, " +
                                "a.accountLocked=false, a.failedAttempts=0 " +
                                "where a.email=:email"
                )
                .setParameter("pwd", password)
                .setParameter("email", email)
                .executeUpdate();
        em.getTransaction().commit();
    }

    @Override
    public void clearOtp(String email) {
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.createQuery(
                        "update AppEntity a set a.otp=null, a.otpExpiry=null where a.email=:email"
                ).setParameter("email", email)
                .executeUpdate();
        em.getTransaction().commit();
    }

}
