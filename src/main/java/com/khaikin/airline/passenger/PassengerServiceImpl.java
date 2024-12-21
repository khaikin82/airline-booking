package com.khaikin.airline.passenger;

import com.khaikin.airline.exception.ConflictException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        if (passenger.getDob().isAfter(LocalDate.now())) {
            throw new ConflictException("Dob is after now!");
        }
        return passengerRepository.save(passenger);
    }
}
