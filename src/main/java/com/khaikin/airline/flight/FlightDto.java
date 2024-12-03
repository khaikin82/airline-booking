package com.khaikin.airline.flight;

import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.booking.Booking;
import com.khaikin.airline.seatclass.SeatClass;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class FlightDto {
    private String flightNumber;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private String status;
    private List<SeatClass> seatClasses;
    private Airplane airplane;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private List<Booking> bookings;
}
