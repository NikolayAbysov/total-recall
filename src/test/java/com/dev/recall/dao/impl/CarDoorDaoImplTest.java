package com.dev.recall.dao.impl;

import com.dev.recall.dao.CarDoorDao;
import com.dev.recall.model.CarDoor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarDoorDaoImplTest {
    private static CarDoor carDoor;
    private static CarDoorDao carDoorDao;

    @BeforeEach
    void init() {
        carDoor = new CarDoor();
        carDoorDao = new CarDoorDaoImpl();
    }

    @Test
    void openDoorOk() {
        assertEquals(carDoor, carDoorDao.save(carDoor));
    }
}
