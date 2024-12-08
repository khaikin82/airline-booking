package com.khaikin.airline.airport;

import com.khaikin.airline.exception.ResourceNotFoundException;
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
    public Airport getAirportById(Integer id) {
        Optional<Airport> airport = airportRepository.findById(id);
        if (airport.isPresent()) {
            return airport.get();
        } else {
            throw new ResourceNotFoundException("Airport not found with id: " + id);
        }
    }

    @Override
    public void deleteAirportById(Integer id) {
        airportRepository.deleteById(id);
    }

    @Override
    public List<Airport> getAirportsByRegion(String region) {
        return airportRepository.findByRegion(region);
    }

    @Override
    public Airport updateAirport(Integer id, Airport updateAirport) {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        if (airportOptional.isPresent()) {
            Airport airport = airportOptional.get();
            airport.setCode(updateAirport.getCode());
            airport.setName(updateAirport.getName());
            airport.setRegion(updateAirport.getRegion());
            airport.setCity(updateAirport.getCity());
            return airportRepository.save(airport);
        } else {
            throw new ResourceNotFoundException("Airport not found!");
        }
    }


}
