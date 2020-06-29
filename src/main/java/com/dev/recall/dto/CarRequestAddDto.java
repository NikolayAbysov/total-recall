package com.dev.recall.dto;

public class CarRequestAddDto {
    private String engineType;
    private int maxSpeed;
    private int timeToMaxSpeed;
    private int maxPassengers;

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
}
