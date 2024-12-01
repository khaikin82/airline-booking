package com.khaikin.airline.airport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;


    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> findInArea(String area) {
        return airportRepository.findByArea(area);
    }

    @Override
    public List<Airport> findInCountry(String country) {
        return airportRepository.findByCountry(country);
    }

//    @Override
//    public List<Airport> findInCity(String city) {
//        return airportRepository.findByCity(city);
//    }
}
