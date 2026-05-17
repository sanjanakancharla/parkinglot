package com.parkinglot.vehicle;

import com.parkinglot.VehicleSize;

public class Motorcycle implements Vehicle {

    String licensePlate;

    Motorcycle(String licensePlate){
        this.licensePlate = licensePlate;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }
}
