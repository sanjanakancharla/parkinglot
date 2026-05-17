package com.parkinglot.parkingspot;

import com.parkinglot.VehicleSize;
import com.parkinglot.vehicle.Vehicle;

public class OversizedSpot implements ParkingSpot{

    Vehicle vehicle;
    int spotNumber;

    OversizedSpot(Vehicle vehicle, int spotNumber){
        this.vehicle = vehicle;
        this.spotNumber = spotNumber;
    }

    @Override
    public boolean isAvailable() {
        return this.vehicle==null;
    }

    @Override
    public void occupy(Vehicle vehicle) {
        if(isAvailable()){
         this.vehicle=vehicle;
        }else{
            //cannot occupy
        }
    }

    @Override
    public void vacate() {
        this.vehicle=null;
    }

    @Override
    public VehicleSize getSize() {
        return VehicleSize.LARGE;
    }

    @Override
    public int getSpotNumber() {
        return spotNumber;
    }
}
