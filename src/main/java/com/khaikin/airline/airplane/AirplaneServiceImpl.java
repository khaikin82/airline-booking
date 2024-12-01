package com.khaikin.airline.airplane;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
