package com.dev.recall.car;

import com.dev.recall.model.Car;
import com.dev.recall.service.CarService;
import com.dev.recall.service.impl.CarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarTest {
    private static Car car;
    private static CarService carService = new CarServiceImpl();

    @BeforeEach
    void init() {
        car = new Car();
        car.setMaxSpeed(100);
        car.setMaxPassengers(2);
    }

    @Test
    void changeCurrentSpeedOk() {
        carService.changeCurrentSpeed(car, 50);
        Assertions.assertEquals(50, car.getCurrentSpeed());
        carService.changeCurrentSpeed(car, -25);
        Assertions.assertEquals(25, car.getCurrentSpeed());
    }

    @Test
    void changeCurrentSpeedNotOk() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carService.changeCurrentSpeed(car, 200);
        });
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carService.changeCurrentSpeed(car, -200);
        });
    }

    @Test
    void addPassengerOk() {
        carService.addPassenger(car);
        Assertions.assertEquals(1, car.getCurrentPassengersNum());
    }

    @Test
    void addPassengerNotOk() {
        carService.addPassenger(car);
        carService.addPassenger(car);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carService.addPassenger(car);;
        });
    }

    @Test
    void detractPassengerOk() {
        carService.addPassenger(car);
        carService.detractPassenger(car);
        Assertions.assertEquals(0, car.getCurrentPassengersNum());
    }

    @Test
    void detractPassengerNotOk() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carService.detractPassenger(car);
        });
    }

    @Test
    void getPassengersOutOk() {
        carService.addPassenger(car);
        carService.addPassenger(car);
        carService.getPassengersOut(car);
        Assertions.assertEquals(0, car.getCurrentPassengersNum());
    }

    @Test
    void addWheelsOk() {
        carService.addWheels(car, 5);
        Assertions.assertEquals(5, car.getWheels().length);
    }

    @Test
    void addWheelsNotOk() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            carService.addWheels(car, -5);
        });
    }

    @Test
    void takeAllCarWheelsOffOk() {
        carService.addWheels(car, 5);
        carService.takeAllCarWheelsOff(car);
        Assertions.assertEquals(0, car.getWheels().length);
    }
}
