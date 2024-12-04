package com.khaikin.airline.airport;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AirportRepository extends JpaRepository<Airport, Integer> {
    List<Airport> findByArea(String region);

    Airport findByName(String airportName);

}
