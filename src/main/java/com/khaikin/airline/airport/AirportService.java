package com.khaikin.airline.airport;

import java.util.List;

public interface AirportService {
    public List<Airport> getAllAirports();

    public Airport createAirport(Airport airport);

    public Airport getAirportById(Integer id);

    public void deleteAirportById(Integer id);

    public List<Airport> getAirportsByRegion(String region);


}
