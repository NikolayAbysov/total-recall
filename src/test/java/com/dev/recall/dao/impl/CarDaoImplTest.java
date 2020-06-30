package com.dev.recall.dao.impl;

import com.dev.recall.dao.CarDao;
import com.dev.recall.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarDaoImplTest {
    private static Car car;
    private static CarDao carDao;

    @BeforeEach
    void init() {
        car = new Car();
        carDao = new CarDaoImpl();
    }

    @Test
    void openDoorOk() {
        assertNotNull(carDao.save(car).getId(), "Entity should have Id after save");
    }
}
