package com.parkinglot.parkingspot;

import com.parkinglot.VehicleSize;
import com.parkinglot.vehicle.Vehicle;

public interface ParkingSpot {
    boolean isAvailable();
    void occupy(Vehicle vehicle);
    void vacate();
    VehicleSize getSize();
    int getSpotNumber();
}
