package com.dev.recall.service.impl;

import com.dev.recall.model.Car;
import com.dev.recall.model.CarDoor;
import com.dev.recall.model.CarWheel;
import com.dev.recall.service.CarService;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarServiceImpl implements CarService {
    @Override
    public void changeCurrentSpeed(Car car, int value) {
        if (value < 0 && Math.abs(value) > car.getCurrentSpeed()) {
            throw new IllegalArgumentException("Change speed value is greater than current speed");
        } else if (value + car.getCurrentSpeed() > car.getMaxSpeed()) {
            throw new IllegalArgumentException("Change speed value is greater than current speed");
        }
        car.setCurrentSpeed(car.getCurrentSpeed() + value);
    }

    @Override
    public void addPassenger(Car car) {
        if (car.getCurrentPassengersNum() + 1 > car.getMaxPassengers()) {
            throw new IllegalArgumentException("Number of passengers exceeds max limit");
        }
        car.setCurrentPassengersNum(car.getCurrentPassengersNum() + 1);
    }

    @Override
    public void detractPassenger(Car car) {
        if (car.getCurrentPassengersNum() - 1 < 0) {
            throw new IllegalArgumentException("Number of passengers exceeds min limit");
        }
        car.setCurrentPassengersNum(car.getCurrentPassengersNum() - 1);
    }

    @Override
    public void getPassengersOut(Car car) {
        car.setCurrentPassengersNum(0);
    }

    @Override
    public CarDoor getCarDoorByIndex(Car car, int index) {
        return car.getDoors()[index];
    }

    @Override
    public CarWheel getCarWheelByIndex(Car car, int index) {
        return car.getWheels()[index];
    }

    @Override
    public void takeAllCarWheelsOff(Car car) {
        car.setWheels(new CarWheel[0]);
    }

    @Override
    public void addWheels(Car car, int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value can't be negative");
        }
        List<CarWheel> carWheelList = Arrays.stream(car.getWheels())
                .collect(Collectors
                        .toList());
        for (int i = 0; i < value; i++) {
            carWheelList.add(new CarWheel());
        }
        car.setWheels(carWheelList.toArray(new CarWheel[0]));
    }

    @Override
    public int getPossibleMaxSpeed(Car car) {
        if (car.getCurrentPassengersNum() == 0) {
            return 0;
        }
        Optional<CarWheel> wheel = Arrays.stream(car.getWheels())
                .min(Comparator
                        .comparing(CarWheel::getStatus));
        if (wheel.isEmpty()) {
            return 0;
        }
        return (int) (car.getMaxSpeed() * wheel.get().getStatus());
    }

    @Override
    public String printDetailsToConsole(Car car) {
        return "Car{"
                + "manufactureDate=" + car.getManufactureDate()
                + ", \nengineType='" + car.getEngineType() + '\''
                + ", \nmaxSpeed=" + car.getMaxSpeed()
                + ", \ntimeToMaxSpeed=" + car.getTimeToMaxSpeed()
                + ", \nmaxPassengers=" + car.getMaxPassengers()
                + ", \ncurrentPassengersNum=" + car.getCurrentPassengersNum()
                + ", \ncurrentSpeed=" + car.getCurrentSpeed()
                + ", \nwheels=" + car.getWheels().length
                + ", \ndoors=" + car.getDoors().length
                + ", \ncurrent possible max speed=" + getPossibleMaxSpeed(car)
                + '}';
    }
}
