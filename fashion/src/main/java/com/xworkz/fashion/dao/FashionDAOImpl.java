package com.xworkz.fashion.dao;

import com.xworkz.fashion.entity.FashionEntity;
import org.springframework.beans.BeanUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FashionDAOImpl implements FashionDAO {

    public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("fashionPU");

    @Override
    public boolean save(FashionEntity entity) {
        EntityManager  em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean update(FashionEntity entity) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
        finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean read(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.find(FashionEntity.class , id);
            em.getTransaction().commit();
        }
        catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return false;
    }

    @Override
    public boolean delete(FashionEntity entity) {
        EntityManager em = emf.createEntityManager();

        try{
            em.getTransaction().begin();
            FashionEntity managed = em.find(FashionEntity.class , entity.getId());
            if(managed != null) {
                em.remove(managed);
                em.getTransaction().commit();
            }
        }
        catch (Exception e){
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return false;
    }

}
