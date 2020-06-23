package com.dev.recall.service;

import com.dev.recall.model.CarWheel;

public interface CarWheelService {

    public void changeToNew(CarWheel carWheel);

    public void wearOut(CarWheel carWheel, float percent);

    public String printDetailsToConsole(CarWheel carWheel);
}
