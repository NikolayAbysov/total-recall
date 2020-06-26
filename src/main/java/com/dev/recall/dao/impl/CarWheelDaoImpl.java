package com.dev.recall.dao.impl;

import com.dev.recall.dao.CarWheelDao;
import com.dev.recall.model.CarWheel;
import com.dev.recall.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarWheelDaoImpl implements CarWheelDao {
    @Override
    public CarWheel save(CarWheel carWheel) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(carWheel);
            transaction.commit();
            return carWheel;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error while adding carWheel. Stacktrace: ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
