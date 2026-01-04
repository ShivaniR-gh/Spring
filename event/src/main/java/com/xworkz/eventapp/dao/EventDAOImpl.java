package com.xworkz.eventapp.dao;

import com.xworkz.eventapp.entity.EventEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EventDAOImpl implements EventDAO{
    @Override
    public boolean save(EventEntity event) {

        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(EventEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(event);
        transaction.commit();
        return true;
    }

    @Override
    public boolean update(EventEntity event) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(EventEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(event);
        transaction.commit();
        return true;
    }

    @Override
    public boolean delete(EventEntity event) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(EventEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(event);
        transaction.commit();
        return true;
    }

    @Override
    public EventEntity read(int id) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(EventEntity.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        EventEntity entity = session.get(EventEntity.class, id);
        session.get(EventEntity.class, id);
        return entity;
    }

}
