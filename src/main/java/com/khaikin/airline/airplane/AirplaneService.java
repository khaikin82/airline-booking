package com.khaikin.airline.airplane;

import java.util.List;

public interface AirplaneService {
    public List<Airplane> getAllAirplanes();

    public Airplane createAirplane(Airplane airplane);
}
