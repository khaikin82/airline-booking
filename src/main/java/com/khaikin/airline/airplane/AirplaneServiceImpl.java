package com.khaikin.airline.airplane;

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
    public Optional<Airplane> getAirplane(Integer id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public void deleteAirplane(Integer id) {
        airplaneRepository.deleteById(id);
    }

    @Override
    public Optional<Airplane> updateAirplane(Integer id, Airplane updateAirplane) {
        return airplaneRepository.findById(id).map(airplane -> {
            airplane.setCode(updateAirplane.getCode());
            airplane.setModel(updateAirplane.getModel());
            airplane.setManufacturer(updateAirplane.getManufacturer());
            airplane.setCapacity(updateAirplane.getCapacity());
            return airplaneRepository.save(airplane);
        });
    }
}
