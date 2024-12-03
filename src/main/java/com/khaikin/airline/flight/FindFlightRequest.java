package com.khaikin.airline.flight;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FindFlightRequest {
    private String departureAirportName;
    private String arrivalAirportName;
    private LocalDate departureDate;
    private Integer passengerNumber;
}
