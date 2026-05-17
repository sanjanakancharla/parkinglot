package com.parkinglot.ticket;

import com.parkinglot.parkingspot.ParkingSpot;
import com.parkinglot.vehicle.Vehicle;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Objects;

public class Ticket {
    private final String ticketId;
    private final Vehicle vehicle;

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    private final ParkingSpot parkingSpot;
    private final LocalDateTime entryTime;

    public void setExitTime(LocalDateTime exitTime) {
        this.exitTime = exitTime;
    }

    private  LocalDateTime exitTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSpot parkingSpot, LocalDateTime entryTime){
        this.ticketId = ticketId;
        this.vehicle=vehicle;
        this.parkingSpot=parkingSpot;
        this.entryTime=entryTime;
    }

    public BigDecimal calculateParkingDuration(){
        return new BigDecimal(Duration.between(entryTime, Objects.requireNonNullElseGet(exitTime, LocalDateTime::now)).toMinutes());
    }

}
