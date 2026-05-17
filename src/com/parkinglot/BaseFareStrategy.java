package com.parkinglot;

import com.parkinglot.ticket.Ticket;

import java.math.BigDecimal;

public class BaseFareStrategy implements FareStrategy{

    private static final BigDecimal SMALL_VEHICLE_RATE = new BigDecimal("1.0");
    private static final BigDecimal MEDIUM_VEHIVLE_RATE = new BigDecimal("2.0");
    private static final BigDecimal LARGE_VEHICLE_RATE = new BigDecimal("3.0");

    @Override
    public BigDecimal calculateFare(BigDecimal inputFare, Ticket ticket) {

        BigDecimal fare = inputFare;
        BigDecimal rate;
        switch (ticket.getParkingSpot().getSize()){
            case SMALL:
                rate=SMALL_VEHICLE_RATE;
                break;
            case MEDIUM:
                rate=MEDIUM_VEHIVLE_RATE;
                break;
            default:
                rate=LARGE_VEHICLE_RATE;
        }
        fare = fare.add(rate.multiply(ticket.calculateParkingDuration()));
        return fare;
    }
}
