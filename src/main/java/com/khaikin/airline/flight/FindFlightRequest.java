package com.khaikin.airline.flight;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FindFlightRequest {
    private Integer departureAirportId;
    private Integer arrivalAirportId;
    private LocalDate departureDate;
    private Integer passengerNumber;
}
