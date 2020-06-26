package com.dev.recall.util;

import com.dev.recall.model.Car;
import com.dev.recall.model.CarDoor;
import com.dev.recall.model.CarWheel;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactoryUtil {
    private static SessionFactory sessionFactory;

    private HibernateSessionFactoryUtil(){
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Car.class);
                configuration.addAnnotatedClass(CarDoor.class);
                configuration.addAnnotatedClass(CarWheel.class);
                StandardServiceRegistryBuilder builder =
                        new StandardServiceRegistryBuilder()
                                .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return sessionFactory;
    }
}
