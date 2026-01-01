package com.xworkz.foodapp.dao;

import com.xworkz.foodapp.dto.FoodStallDTO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class FoodDAOImpl implements FoodDAO{
    @Override
    public boolean save(FoodStallDTO foodStallDTO) {
        Configuration configuration =new Configuration();
        configuration.configure();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        transaction.commit();
        return true;
    }
}
