package com.parkinglot.parkingspot;

import com.parkinglot.VehicleSize;
import com.parkinglot.vehicle.Vehicle;

public class CompactSpot implements ParkingSpot{

    Vehicle vehicle;
    int spotNumber;

    CompactSpot(Vehicle vehicle, int spotNumber){
        this.vehicle=vehicle;
        this.spotNumber=spotNumber;
    }

    @Override
    public boolean isAvailable() {
        return vehicle==null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if(isAvailable()){
            this.vehicle = vehicle;
        }
        else{
            //spot occupied
        }
    }

    @Override
    public void vacate() {
        this.vehicle=null;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.SMALL;
    }

    @Override
    public int getSpotNumber() {
        return this.spotNumber;
    }
}
