package com.parkinglot;

import com.parkinglot.ticket.Ticket;

import java.math.BigDecimal;

public interface FareStrategy {
    BigDecimal calculateFare(BigDecimal inputFare, Ticket ticket);
}
