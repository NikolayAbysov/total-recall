package com.dev.recall.service.impl;

import com.dev.recall.model.CarDoor;
import com.dev.recall.service.CarDoorService;

public class CarDoorServiceIMpl implements CarDoorService {

    @Override
    public void actionDoor(CarDoor carDoor) {
        if (carDoor.isDoorOpen()) {
            carDoor.closeDoor();
        } else {
            carDoor.openDoor();
        }
    }

    @Override
    public void actionWindow(CarDoor carDoor) {
        if (carDoor.isWindowOpen()) {
            carDoor.closeWindow();
        } else {
            carDoor.openWindow();
        }
    }

    @Override
    public String printDetailsToConsole(CarDoor carDoor) {
        return "Door details: \n" + "isDoorOpen : " + carDoor.isDoorOpen() + "\n"
                + "isWindowOpen : " + carDoor.isWindowOpen();
    }
}
