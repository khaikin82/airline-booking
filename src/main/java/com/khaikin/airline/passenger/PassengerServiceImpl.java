package com.khaikin.airline.passenger;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassengerServiceImpl implements PassengerService {
    private final PassengerRepository passengerRepository;

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Passenger createPassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }
}
