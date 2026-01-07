package com.xworkz.clothingcompany.dao;

import com.xworkz.clothingcompany.entity.ClothEntity;

import javax.persistence.*;
import java.util.List;

public class ClothDAOImpl implements ClothDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("clothPU");


    @Override
    public boolean save(ClothEntity entity) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    // ========== COMMON SINGLE RESULT METHOD ==========
    private <T> T singleResult(String jpql, String param, Object value, Class<T> type) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<T> query = em.createQuery(jpql, type);

        if (param != null && value != null) {
            query.setParameter(param, value);
        }

        T result = query.getSingleResult();
        em.close();
        return result;
    }

    // ========== COMMON LIST METHOD ==========
    private List<ClothEntity> getList(String jpql, String param, Object value) {
        EntityManager em = emf.createEntityManager();
        TypedQuery<ClothEntity> query = em.createQuery(jpql, ClothEntity.class);
        query.setParameter(param, value);
        List<ClothEntity> list = query.getResultList();
        em.close();
        return list;
    }

    // ================= 20 OPERATIONS =================

    public String getClothTypeByClothName(String name) {
        EntityManager em = emf.createEntityManager();
        List<String> list = em.createQuery(
                        "select c.clothType from ClothEntity c where c.clothName=:n",
                        String.class
                ).setParameter("n", name)
                .getResultList();

        em.close();

        return list.isEmpty() ? null : list.get(0);
    }


    @Override
    public double getClothPriceByClothName(String name) {
        return singleResult(
                "select c.price from ClothEntity c where c.clothName=:n",
                "n", name, Double.class
        );
    }

    @Override
    public String getBrandByClothName(String name) {
        return singleResult(
                "select c.brand from ClothEntity c where c.clothName=:n",
                "n", name, String.class
        );
    }

    @Override
    public String getColorByClothName(String name) {
        return singleResult(
                "select c.color from ClothEntity c where c.clothName=:n",
                "n", name, String.class
        );
    }

    @Override
    public String getSizeByClothName(String name) {
        return singleResult(
                "select c.size from ClothEntity c where c.clothName=:n",
                "n", name, String.class
        );
    }

    @Override
    public String getMaterialByClothName(String name) {
        return singleResult(
                "select c.material from ClothEntity c where c.clothName=:n",
                "n", name, String.class
        );
    }

    @Override
    public String getGenderByClothName(String name) {
        return singleResult(
                "select c.gender from ClothEntity c where c.clothName=:n",
                "n", name, String.class
        );
    }

    @Override
    public List<String> getAllClothNames() {
        EntityManager em = emf.createEntityManager();
        List<String> list = em.createQuery(
                "select c.clothName from ClothEntity c", String.class
        ).getResultList();
        em.close();
        return list;
    }

    @Override
    public List<String> getAllBrands() {
        EntityManager em = emf.createEntityManager();
        List<String> list = em.createQuery(
                "select distinct c.brand from ClothEntity c", String.class
        ).getResultList();
        em.close();
        return list;
    }

    @Override
    public List<ClothEntity> getClothsByBrand(String brand) {
        return getList(
                "select c from ClothEntity c where c.brand=:b",
                "b", brand
        );
    }

    @Override
    public List<ClothEntity> getClothsByColor(String color) {
        return getList(
                "select c from ClothEntity c where c.color=:c",
                "c", color
        );
    }

    @Override
    public List<ClothEntity> getClothsByGender(String gender) {
        return getList(
                "select c from ClothEntity c where c.gender=:g",
                "g", gender
        );
    }

    @Override
    public List<ClothEntity> getClothsByType(String type) {
        return getList(
                "select c from ClothEntity c where c.clothType=:t",
                "t", type
        );
    }

    @Override
    public long countByBrand(String brand) {
        return singleResult(
                "select count(c) from ClothEntity c where c.brand=:b",
                "b", brand, Long.class
        );
    }

    @Override
    public double getMaxPrice() {
        return singleResult(
                "select max(c.price) from ClothEntity c",
                null, null, Double.class
        );
    }

    @Override
    public double getMinPrice() {
        return singleResult(
                "select min(c.price) from ClothEntity c",
                null, null, Double.class
        );
    }

    @Override
    public double getAveragePrice() {
        return singleResult(
                "select avg(c.price) from ClothEntity c",
                null, null, Double.class
        );
    }

    @Override
    public boolean updatePriceByName(String name, double price) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        int updated = em.createQuery(
                        "update ClothEntity c set c.price=:p where c.clothName=:n")
                .setParameter("p", price)
                .setParameter("n", name)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
        return updated > 0;
    }

    @Override
    public boolean deleteByName(String name) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        int deleted = em.createQuery(
                        "delete from ClothEntity c where c.clothName=:n")
                .setParameter("n", name)
                .executeUpdate();
        em.getTransaction().commit();
        em.close();
        return deleted > 0;
    }
}
