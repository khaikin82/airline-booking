package com.khaikin.airline.airport;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Airport> getAirportById(Integer id) {
        return airportRepository.findById(id);
    }

    @Override
    public void deleteAirportById(Integer id) {
        airportRepository.deleteById(id);
    }

    @Override
    public List<Airport> getAirportsByArea(String area) {
        return airportRepository.findByArea(area);
    }


}
