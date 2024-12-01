package com.khaikin.airline.passenger;

import java.util.List;

public interface PassengerService {
    public List<Passenger> getAllPassengers();

    public Passenger createPassenger(Passenger passenger);
}
