package com.khaikin.airline.flight;


import com.khaikin.airline.airport.Airport;

import java.util.List;

public interface FlightService {
    public List<FlightDto> getAllFlights();

    public Flight createFlight(Flight flight);

    public Flight updateAirplane(Integer flightId, Integer airplaneId);

    public Flight updateDepartureAirport(Integer flightId, Integer airportId);

    public Flight updateDepartureAirport(Flight flight, Airport airport);

    public Flight updateArrivalAirport(Integer flightId, Integer airportId);

    public Flight updateArrivalAirport(Flight flight, Airport airport);

    public List<Flight> findAppropriateFlight(FindFlightRequest findFlightRequest);

}

