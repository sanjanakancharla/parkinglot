package com.parkinglot.parkingmanager;

import com.parkinglot.VehicleSize;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.vehicle.Vehicle;

import java.util.List;
import java.util.Map;

public class ParkingManager {
    Map<VehicleSize, List<ParkingSpot>> availableSpots;
    Map<Vehicle, ParkingSpot> vehicleToSpotMap;

    ParkingSpot findSpotForVehicle(Vehicle vehicle){
        VehicleSize vehicleSize = vehicle.getSize();
        for(VehicleSize size: VehicleSize.values()){
            if(size.ordinal()>=vehicleSize.ordinal()){
                List<ParkingSpot> spots = availableSpots.get(vehicleSize);
                for(ParkingSpot spot: spots){
                    if(spot.isAvailable())
                    {
                        return  spot;
                    }
                }
            }
        }
        return  null;
    }

public ParkingSpot parkVehicle(Vehicle vehicle){
    ParkingSpot spot = findSpotForVehicle(vehicle);
    if(spot!=null){
        spot.occupy(vehicle);
        vehicleToSpotMap.put(vehicle, spot);
        availableSpots.get(vehicle.getSize()).remove(spot);
        return spot;
    }
    return null;
    }

    public void unparkVehicle(Vehicle vehicle){
        ParkingSpot spot = vehicleToSpotMap.remove(vehicle.getSize());
        if(spot!=null){
            spot.vacate();
            availableSpots.get(vehicle.getSize()).add(spot);
        }
    }


}
