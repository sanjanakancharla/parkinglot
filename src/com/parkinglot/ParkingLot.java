package com.parkinglot;

import com.parkinglot.parkingmanager.ParkingManager;
import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.ticket.Ticket;
import com.parkinglot.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
The ParkingLot class acts as a facade, providing a simple interface for clients to interact with the parking lot system while delegating complex tasks to ParkingManager and FareCalculator. It relies on ParkingManager for spot allocation and FareCalculator for pricing, managing the flow of vehicles through entry and exit operations.
*/

public class ParkingLot {
    private final ParkingManager parkingManager;
    private final FareCalculator fareCalculator;

    public ParkingLot(ParkingManager parkingManager, FareCalculator fareCalculator){
        this.parkingManager = parkingManager;
        this.fareCalculator=fareCalculator;
    }

    public Ticket enterVehicle(Vehicle vehicle){
        ParkingSpot spot = parkingManager.parkVehicle(vehicle);
        if(spot!=null){
            Ticket ticket = new Ticket(generateTicketId(), vehicle, spot, LocalDateTime.now());
            return ticket;
        }
        else{
            return null;
        }
    }

    public void leaveVehicle(Ticket ticket){
        if(ticket!=null && ticket.getExitTime()==null){
            ticket.setExitTime(LocalDateTime.now());
            parkingManager.unparkVehicle(ticket.getVehicle());
            BigDecimal fare = fareCalculator.calculateFare(ticket);
        }
        else{
            //invalid ticket or vehicle already exited.
        }
    }






}
