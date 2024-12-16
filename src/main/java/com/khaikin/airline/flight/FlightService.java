package com.khaikin.airline.flight;


import com.khaikin.airline.flight.dto.FindFlightRequest;
import com.khaikin.airline.flight.dto.FlightDto;

import java.util.List;

public interface FlightService {
    public List<FlightDto> getAllFlights();

    public FlightDto getFlightById(Integer id);

    public FlightDto createFlight(Flight flight);

    public List<FlightDto> findAppropriateFlight(FindFlightRequest findFlightRequest);

    public FlightDto updateFlight(Integer id, Flight updateFlight);

    public void deleteFlightById(Integer id);

    public void updateSeatBookedNumber(Integer id, String seatClass, Integer count);


}

