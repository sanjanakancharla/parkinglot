package com.parkinglot.vehicle;

import com.parkinglot.VehicleSize;

public class Car implements Vehicle {
    private String licensePlate;

    public Car(String licensePlate){
        this.licensePlate = licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.MEDIUM;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }
}
