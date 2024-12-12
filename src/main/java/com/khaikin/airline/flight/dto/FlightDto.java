package com.khaikin.airline.flight.dto;

import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.flight.FlightStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDto {
    private Integer id;
    private String flightNumber;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private FlightStatus flightStatus;

    private Long economyPrice;
    private Long businessPrice;
    private Integer economySeatBookedNumber;
    private Integer businessSeatBookedNumber;


    private Airplane airplane;
    private Airport departureAirport;
    private Airport arrivalAirport;
}
