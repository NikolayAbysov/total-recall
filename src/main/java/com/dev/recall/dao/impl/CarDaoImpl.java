package com.dev.recall.dao.impl;

import com.dev.recall.dao.CarDao;
import com.dev.recall.model.Car;
import com.dev.recall.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarDaoImpl implements CarDao {
    @Override
    public Car save(Car car) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(car);
            transaction.commit();
            return car;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error while adding car. Stacktrace: ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
