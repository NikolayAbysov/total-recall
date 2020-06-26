package com.dev.recall.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "car_door")
public class CarDoor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean isDoorOpen;
    private boolean isWindowOpen;

    public CarDoor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDoorOpen(boolean doorOpen) {
        isDoorOpen = doorOpen;
    }

    public void setWindowOpen(boolean windowOpen) {
        isWindowOpen = windowOpen;
    }

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
