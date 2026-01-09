package com.xworkz.productapp.dao;

import com.xworkz.productapp.entity.ProductEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProductDAOImpl implements ProductDAO {

    private SessionFactory getSessionFactory() {
        Configuration cfg = new Configuration();
        cfg.configure();
        cfg.addAnnotatedClass(ProductEntity.class);
        return cfg.buildSessionFactory();
    }

    @Override
    public boolean save(ProductEntity entity) {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(entity);
        tx.commit();

        session.close();
        factory.close();
        return true;
    }

    @Override
    public boolean update(ProductEntity entity) {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(entity);
        tx.commit();

        session.close();
        factory.close();
        return true;
    }

    @Override
    public boolean delete(ProductEntity entity) {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.delete(entity);
        tx.commit();

        session.close();
        factory.close();
        return true;
    }

    @Override
    public ProductEntity read(int id) {
        SessionFactory factory = getSessionFactory();
        Session session = factory.openSession();

        ProductEntity entity = session.get(ProductEntity.class, id);

        session.close();
        factory.close();
        return entity;
    }
}
