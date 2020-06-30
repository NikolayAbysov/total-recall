package com.dev.recall.dao.impl;

import com.dev.recall.dao.CarDoorDao;
import com.dev.recall.model.CarDoor;
import com.dev.recall.util.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class CarDoorDaoImpl implements CarDoorDao {
    @Override
    public CarDoor save(CarDoor carDoor) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(carDoor);
            transaction.commit();
            return carDoor;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Error while adding carDoor. Stacktrace: ", e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
