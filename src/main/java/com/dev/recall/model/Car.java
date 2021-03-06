package com.dev.recall.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private final LocalDate manufactureDate;
    private String engineType;
    private int maxSpeed;
    private int timeToMaxSpeed;
    private int maxPassengers;
    private int currentPassengersNum;
    private int currentSpeed;
    @OneToMany
    @OrderColumn(name = "car_wheels")
    private CarWheel[] wheels;
    @OneToMany
    @OrderColumn(name = "car_doors")
    private CarDoor[] doors;

    public Car() {
        this.manufactureDate = LocalDate.now();
        this.wheels = new CarWheel[0];
        this.doors = new CarDoor[0];
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getTimeToMaxSpeed() {
        return timeToMaxSpeed;
    }

    public void setTimeToMaxSpeed(int timeToMaxSpeed) {
        this.timeToMaxSpeed = timeToMaxSpeed;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }

    public int getCurrentPassengersNum() {
        return currentPassengersNum;
    }

    public void setCurrentPassengersNum(int currentPassengersNum) {
        this.currentPassengersNum = currentPassengersNum;
    }

    public int getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    public CarWheel[] getWheels() {
        return wheels;
    }

    public void setWheels(CarWheel[] wheels) {
        this.wheels = wheels;
    }

    public CarDoor[] getDoors() {
        return doors;
    }

    public void setDoors(CarDoor[] doors) {
        this.doors = doors;
    }
}
