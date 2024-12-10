package com.khaikin.airline.airport;

import java.util.List;

public interface AirportService {
    public List<Airport> getAllAirports();


    public Airport getAirportById(Integer id);

    public List<Airport> getAirportsByRegion(String region);

    public Airport createAirport(Airport airport);

    public Airport updateAirport(Integer id, Airport updateAirport);

    public Airport setAirportActive(Integer id, Boolean isActive);

    public void deleteAirportById(Integer id);


}
