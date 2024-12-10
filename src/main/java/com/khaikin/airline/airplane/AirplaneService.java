package com.khaikin.airline.airplane;

import java.util.List;

public interface AirplaneService {
    public List<Airplane> getAllAirplanes();

    public Airplane getAirplaneById(Integer id);

    public Airplane createAirplane(Airplane airplane);

    public Airplane updateAirplane(Integer id, Airplane updateAirplane);

    public Airplane setAirplaneActive(Integer id, Boolean isActive);

    public void deleteAirplaneById(Integer id);

}
