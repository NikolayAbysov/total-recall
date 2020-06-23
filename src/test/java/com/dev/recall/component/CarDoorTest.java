package com.dev.recall.component;

import com.dev.recall.model.CarDoor;
import com.dev.recall.service.CarDoorService;
import com.dev.recall.service.impl.CarDoorServiceIMpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarDoorTest {
    private static CarDoor carDoor;
    private static CarDoorService carDoorService = new CarDoorServiceIMpl();

    @BeforeEach
    void init() {
        carDoor = new CarDoor();
    }

    @Test
    void openDoorOk() {
        assertTrue(carDoor.openDoor());
    }

    @Test
    void closeDoorOk() {
        assertFalse(carDoor.closeDoor());
    }

    @Test
    void openWindowOk() {
        assertTrue(carDoor.openWindow());
    }

    @Test
    void closeWindowOk() {
        assertFalse(carDoor.closeWindow());
    }

    @Test
    void ActionDoorOk() {
        carDoor.closeDoor();
        assertFalse(carDoor.isDoorOpen());
        carDoorService.actionDoor(carDoor);
        assertTrue(carDoor.isDoorOpen());
    }

    @Test
    void ActionWindowOk() {
        carDoor.closeWindow();
        assertFalse(carDoor.isWindowOpen());
        carDoorService.actionWindow(carDoor);
        assertTrue(carDoor.isWindowOpen());

    }
}
