package com.parkinglot.vehicle;

import com.parkinglot.VehicleSize;

public class Truck implements Vehicle {
    String licensePlate;

    Truck(String licensePlate) {
        this.licensePlate = licensePlate;
    }
    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE;
    }

    @Override
    public String getLicensePlate() {
        return this.licensePlate;
    }
}
