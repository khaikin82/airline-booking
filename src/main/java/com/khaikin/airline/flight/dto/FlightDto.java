package com.khaikin.airline.flight.dto;

import com.khaikin.airline.airplane.AirplaneDto;
import com.khaikin.airline.airport.AirportDto;
import com.khaikin.airline.booking.Booking;
import com.khaikin.airline.flight.FlightStatus;
import com.khaikin.airline.seatclass.SeatClass;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightDto {
    private String flightNumber;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private FlightStatus flightStatus;
    private List<SeatClass> seatClasses;
    private AirplaneDto airplane;
    private AirportDto departureAirport;
    private AirportDto arrivalAirport;
    private List<Booking> bookings;
}
