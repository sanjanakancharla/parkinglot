package com.parkinglot;

import com.parkinglot.ticket.Ticket;

import java.math.BigDecimal;
import java.util.List;

public class FareCalculator {
    private final List<FareStrategy> fareStrategies;

    public FareCalculator(List<FareStrategy> fareStrategies) {
        this.fareStrategies = fareStrategies;
    }

    public BigDecimal calculateFare(Ticket ticket){
        BigDecimal fare = BigDecimal.ZERO;
        for(FareStrategy strategy: fareStrategies){
            fare = strategy.calculateFare(fare, ticket);
        }
        return fare;
    }



}
