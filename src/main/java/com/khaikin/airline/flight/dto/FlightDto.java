package com.khaikin.airline.flight.dto;

import com.khaikin.airline.airplane.AirplaneDto;
import com.khaikin.airline.airport.AirportDto;
import com.khaikin.airline.booking.BookingDto;
import com.khaikin.airline.flight.FlightStatus;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

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


    private AirplaneDto airplane;
    private AirportDto departureAirport;
    private AirportDto arrivalAirport;
    private List<BookingDto> bookings;
}
