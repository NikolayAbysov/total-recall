package com.dev.recall.model;

public class CarDoor {
    private boolean isDoorOpen;
    private boolean isWindowOpen;

    public boolean openDoor() {
        isDoorOpen = true;
        return true;
    }

    public boolean closeDoor() {
        isDoorOpen = false;
        return false;
    }

    public boolean openWindow() {
        isWindowOpen = true;
        return true;
    }

    public boolean closeWindow() {
        isWindowOpen = false;
        return false;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public boolean isWindowOpen() {
        return isWindowOpen;
    }
}
