package com.dev.recall.component;

import com.dev.recall.model.CarWheel;
import com.dev.recall.service.CarWheelService;
import com.dev.recall.service.impl.CarWheelServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarWheelTest {
    private static CarWheel carWheel;
    private static CarWheelService carWheelService = new CarWheelServiceImpl();
    @BeforeEach
    void init() {
        carWheel = new CarWheel();
    }

    @Test
    void wearOutOk() {
        carWheelService.wearOut(carWheel, 0.5F);
        Assertions.assertEquals(0.5F, carWheel.getStatus());
    }

    @Test
    void wearOutNotOk() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carWheelService.wearOut(carWheel, 2F);
        });
    }

    @Test
    void changeToNewOk() {
        carWheelService.wearOut(carWheel, 0.5F);
        Assertions.assertEquals(0.5F, carWheel.getStatus());
        carWheelService.changeToNew(carWheel);
        Assertions.assertEquals(1F, carWheel.getStatus());
    }
}
