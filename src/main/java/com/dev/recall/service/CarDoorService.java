package com.dev.recall.service;

import com.dev.recall.model.CarDoor;

public interface CarDoorService {

    public void actionDoor(CarDoor carDoor);

    public void actionWindow(CarDoor carDoor);

    public String printDetailsToConsole(CarDoor carDoor);
}
