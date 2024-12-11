package com.khaikin.airline.airplane;

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
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;
    private final FlightRepository flightRepository;

    @Override
    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @Override
    public Airplane getAirplaneById(Integer id) {
        Optional<Airplane> airplane = airplaneRepository.findById(id);
        if (airplane.isPresent()) {
            return airplane.get();
        } else {
            throw new ResourceNotFoundException("Airplane not found with id: " + id);
        }
    }

    @Override
    public Airplane createAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }


    @Override
    public Airplane updateAirplane(Integer id, Airplane updateAirplane) {
        Optional<Airplane> airplaneOptional = airplaneRepository.findById(id);
        if (airplaneOptional.isPresent()) {
            Airplane airplane = airplaneOptional.get();
            airplane.setCode(updateAirplane.getCode());
            airplane.setModel(updateAirplane.getModel());
            airplane.setManufacturer(updateAirplane.getManufacturer());
            airplane.setEconomySeatNumber(updateAirplane.getEconomySeatNumber());
            airplane.setBusinessSeatNumber(updateAirplane.getBusinessSeatNumber());

            Boolean isActive = updateAirplane.getIsActive();
            if (airplane.getIsActive() == isActive) {
                return airplane;
            }
            if (!isActive) {
                List<Flight> flights = flightRepository.findFlightsInUseByAirplaneId(id);
                if (flights != null && !flights.isEmpty()) {
                    throw new ConflictException("Airplane in use with id: " + id);
                }
            }
            airplane.setIsActive(isActive);

            return airplaneRepository.save(airplane);
        } else {
            throw new ResourceNotFoundException("Airplane not found with id: " + id);
        }
    }

    @Override
    public Airplane setAirplaneActive(Integer id, Boolean isActive) {
        Optional<Airplane> airplaneOptional = airplaneRepository.findById(id);
        if (airplaneOptional.isPresent()) {
            Airplane airplane = airplaneOptional.get();
            if (airplane.getIsActive() == isActive) {
                return airplane;
            }
            if (!isActive) {
                List<Flight> flights = flightRepository.findFlightsInUseByAirplaneId(id);
                if (flights != null && !flights.isEmpty()) {
                    throw new ConflictException("Airplane in use with id: " + id);
                }
            }
            airplane.setIsActive(isActive);
            return airplaneRepository.save(airplane);
        } else {
            throw new ResourceNotFoundException("Airplane not found with id: " + id);
        }
    }

    @Override
    public void deleteAirplaneById(Integer id) {
        Optional<Airplane> airplaneOptional = airplaneRepository.findById(id);
        if (airplaneOptional.isPresent()) {
            Airplane airplane = airplaneOptional.get();

            if (airplane.getFlights().isEmpty()) {
                airplaneRepository.deleteById(id);
            } else {
                throw new ConflictException("Airplane in use!");
            }

        } else {
            throw new ResourceNotFoundException("Airplane not found with id: " + id);
        }
    }
}
