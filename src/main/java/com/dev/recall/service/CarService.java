package com.dev.recall.service;

import com.dev.recall.model.Car;
import com.dev.recall.model.CarDoor;
import com.dev.recall.model.CarWheel;

public interface CarService {

    public void changeCurrentSpeed(Car car, int value);

    public void addPassenger(Car car);

    public void detractPassenger(Car car);

    public void getPassengersOut(Car car);

    public CarDoor getCarDoorByIndex(Car car, int index);

    public CarWheel getCarWheelByIndex(Car car, int index);

    public void takeAllCarWheelsOff(Car car);

    public void addWheels(Car car, int value);

    public int getPossibleMaxSpeed(Car car);

    public String printDetailsToConsole(Car car);
}
