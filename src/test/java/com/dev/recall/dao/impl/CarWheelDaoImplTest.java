package com.dev.recall.dao.impl;

import com.dev.recall.dao.CarWheelDao;
import com.dev.recall.model.CarWheel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarWheelDaoImplTest {
    private static CarWheel carWheel;
    private static CarWheelDao carWheelDao;

    @BeforeEach
    void init() {
        carWheel = new CarWheel();
        carWheelDao = new CarWheelDaoImpl();
    }

    @Test
    void openDoorOk() {
        assertNotNull(carWheelDao.save(carWheel).getId(), "Entity should have Id after save");
    }
}
