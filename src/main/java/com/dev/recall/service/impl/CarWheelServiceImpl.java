package com.dev.recall.service.impl;

import com.dev.recall.model.CarWheel;
import com.dev.recall.service.CarWheelService;

public class CarWheelServiceImpl implements CarWheelService {
    @Override
    public void changeToNew(CarWheel carWheel) {
        carWheel.setStatus(1F);
    }

    @Override
    public void wearOut(CarWheel carWheel, float percent) {
        if (percent > 1F) {
            throw new IllegalArgumentException("Percent can't be more than 1");
        }
        carWheel.setStatus(carWheel.getStatus() - percent);
    }

    @Override
    public String printDetailsToConsole(CarWheel carWheel) {
        return "Wheel details: \n" + "Status : " + carWheel.getStatus();
    }
}
