package com.khaikin.airline.airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    public List<Airport> getAllAirports();

    public Airport createAirport(Airport airport);

    public Optional<Airport> getAirportById(Integer id);

    public void deleteAirportById(Integer id);

    public List<Airport> getAirportsByRegion(String region);


}
