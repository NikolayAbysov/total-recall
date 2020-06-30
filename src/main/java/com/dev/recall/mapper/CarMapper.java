package com.dev.recall.mapper;

import com.dev.recall.dto.CarRequestAddDto;
import com.dev.recall.model.Car;

public class CarMapper {
    public static Car map(CarRequestAddDto carRequestAddDto) {
        Car car = new Car();
        car.setEngineType(carRequestAddDto.getEngineType());
        car.setMaxSpeed(carRequestAddDto.getMaxSpeed());
        car.setTimeToMaxSpeed(carRequestAddDto.getTimeToMaxSpeed());
        car.setMaxPassengers(carRequestAddDto.getMaxPassengers());
        return car;
    }
}
