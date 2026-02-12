package com.xworkz.ShivaniRApp.repo.impl;

import com.xworkz.ShivaniRApp.entity.StudentEntity;
import com.xworkz.ShivaniRApp.repo.StudentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
public class StudentRepositoryImpl implements StudentRepository {

    @PersistenceUnit
    private EntityManagerFactory factory;

    // ================= SAVE STUDENT =================
    @Override
    public void save(StudentEntity student) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    // ================= FIND STUDENTS BY BATCH =================
    @Override
    public List<StudentEntity> findByBatch(int batchId) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery(
                            "FROM StudentEntity s WHERE s.batch.id = :bid",
                            StudentEntity.class
                    )
                    .setParameter("bid", batchId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    // ================= FIND PHOTO BY STUDENT ID =================
    @Override
    public String findPhotoPathByStudentId(int studentId) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.createQuery(
                            "SELECT s.photoPath FROM StudentEntity s WHERE s.id = :sid",
                            String.class
                    )
                    .setParameter("sid", studentId)
                    .getSingleResult();
        } finally {
            em.close();
        }
    }
    @Override
    public void deleteById(int studentId) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();

            StudentEntity student = em.find(StudentEntity.class, studentId);
            if (student != null) {
                em.remove(student);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public StudentEntity findById(int studentId) {
        EntityManager em = factory.createEntityManager();
        try {
            return em.find(StudentEntity.class, studentId);
        } finally {
            em.close();
        }
    }


    @Override
    public void update(StudentEntity student) {
        EntityManager em = factory.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }


}
