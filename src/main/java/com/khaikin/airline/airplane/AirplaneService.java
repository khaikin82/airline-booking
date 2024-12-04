package com.khaikin.airline.airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneService {
    public List<Airplane> getAllAirplanes();

    public Airplane createAirplane(Airplane airplane);

    public Airplane getAirplaneById(Integer id);

    public void deleteAirplaneById(Integer id);

    public Optional<Airplane> updateAirplane(Integer id, Airplane updateAirplane);
}
