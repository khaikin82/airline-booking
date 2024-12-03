package com.khaikin.airline.airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneService {
    public List<Airplane> getAllAirplanes();

    public Airplane createAirplane(Airplane airplane);

    public Optional<Airplane> getAirplane(Integer id);

    public void deleteAirplane(Integer id);

    public Optional<Airplane> updateAirplane(Integer id, Airplane updateAirplane);
}
