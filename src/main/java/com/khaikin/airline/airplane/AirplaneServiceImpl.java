package com.khaikin.airline.airplane;

import com.khaikin.airline.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AirplaneServiceImpl implements AirplaneService {
    private final AirplaneRepository airplaneRepository;

    @Override
    public List<Airplane> getAllAirplanes() {
        return airplaneRepository.findAll();
    }

    @Override
    public Airplane createAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
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
    public void deleteAirplaneById(Integer id) {
        Optional<Airplane> airplane = airplaneRepository.findById(id);
        if (airplane.isPresent()) {
            airplaneRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Airplane not found with id: " + id);
        }
    }

    @Override
    public Optional<Airplane> updateAirplane(Integer id, Airplane updateAirplane) {
        return airplaneRepository.findById(id).map(airplane -> {
            airplane.setCode(updateAirplane.getCode());
            airplane.setModel(updateAirplane.getModel());
            airplane.setManufacturer(updateAirplane.getManufacturer());
            airplane.setEconomySeatNumber(updateAirplane.getEconomySeatNumber());
            airplane.setBusinessSeatNumber(updateAirplane.getBusinessSeatNumber());
            return airplaneRepository.save(airplane);
        });
    }
}
