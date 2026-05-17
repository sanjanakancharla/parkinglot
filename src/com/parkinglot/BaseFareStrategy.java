package com.parkinglot;

import com.parkinglot.ticket.Ticket;

import java.math.BigDecimal;

public class BaseFareStrategy implements FareStrategy{

    private static final BigDecimal SMALL_VEHICLE_RATE = new BigDecimal("1.0");
    private static final BigDecimal MEDIUM_VEHIVLE_RATE = new BigDecimal("2.0");



    @Override
    public BigDecimal calculateFare(BigDecimal inputFare, Ticket ticket) {
        return null;
    }
}
