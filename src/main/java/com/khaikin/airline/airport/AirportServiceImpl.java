package com.khaikin.airline.airport;

import com.khaikin.airline.exception.ConflictException;
import com.khaikin.airline.exception.ResourceNotFoundException;
import com.khaikin.airline.flight.Flight;
import com.khaikin.airline.flight.FlightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirportServiceImpl implements AirportService {
    private final AirportRepository airportRepository;
    private final FlightRepository flightRepository;

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
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
    public List<Airport> getAirportsByRegion(String region) {
        return airportRepository.findByRegion(region);
    }

    @Override
    public Airport createAirport(Airport airport) {
        return airportRepository.save(airport);
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

            Boolean isActive = updateAirport.getIsActive();
            if (airport.getIsActive() == isActive) {
                return airport;
            }
            if (!isActive) {
                List<Flight> flights = flightRepository.findFlightsInUseByAirportId(id);
                if (flights != null && !flights.isEmpty()) {
                    throw new ConflictException("Airport in use with id: " + id);
                }
            }
            airport.setIsActive(isActive);

            return airportRepository.save(airport);
        } else {
            throw new ResourceNotFoundException("Airport not found!");
        }
    }

    @Override
    public Airport setAirportActive(Integer id, Boolean isActive) {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        if (airportOptional.isPresent()) {
            Airport airport = airportOptional.get();
            if (airport.getIsActive() == isActive) {
                return airport;
            }
            if (!isActive) {
                List<Flight> flights = flightRepository.findFlightsInUseByAirportId(id);
                if (flights != null && !flights.isEmpty()) {
                    throw new ConflictException("Airport in use with id: " + id);
                }
            }
            airport.setIsActive(isActive);
            return airportRepository.save(airport);
        } else {
            throw new ResourceNotFoundException("Airport not found!");
        }
    }

    @Override
    public void deleteAirportById(Integer id) {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        if (airportOptional.isPresent()) {
            Airport airport = airportOptional.get();

            if (airport.getDepartureFlights().isEmpty() && airport.getArrivalFlights().isEmpty()) {
                airportRepository.deleteById(id);
            } else {
                throw new ConflictException("Airport in use!");
            }

        } else {
            throw new ResourceNotFoundException("Airport not found with id: " + id);
        }
    }

}
