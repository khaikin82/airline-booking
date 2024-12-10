package com.khaikin.airline.flight;


import com.khaikin.airline.flight.dto.FindFlightRequest;
import com.khaikin.airline.flight.dto.FlightDto;

import java.util.List;

public interface FlightService {
    public List<FlightDto> getAllFlights();

    public FlightDto createFlight(Flight flight);

    public FlightDto getFlightById(Integer id);

    public List<FlightDto> findAppropriateFlight(FindFlightRequest findFlightRequest);

    public void deleteFlightById(Integer id);

    public FlightDto updateFlight(Integer id, Flight updateFlight);

}

