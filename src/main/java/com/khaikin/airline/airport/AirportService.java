package com.khaikin.airline.airport;

import java.util.List;

public interface AirportService {
    public List<Airport> getAllAirports();

    public Airport createAirport(Airport airport);

    public List<Airport> findInArea(String area);


}
