package com.khaikin.airline.flight;

import com.khaikin.airline.passenger.PassengerNumberRequest;
import lombok.Data;

import java.time.LocalDate;

@Data
public class FindFlightRequest {
    private String departureAirportName;
    private String arrivalAirportName;
    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private PassengerNumberRequest passengerNumberRequest;
}
