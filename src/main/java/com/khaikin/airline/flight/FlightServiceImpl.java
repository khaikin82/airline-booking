package com.khaikin.airline.flight;

import com.khaikin.airline.exception.ConflictException;
import com.khaikin.airline.exception.ResourceNotFoundException;
import com.khaikin.airline.flight.dto.FindFlightRequest;
import com.khaikin.airline.flight.dto.FlightDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        List<FlightDto> flightDtos = flights.stream().map(flight -> {
                    FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
                    return flightDto;
                })
                .collect(Collectors.toList());
        return flightDtos;
    }

    @Override
    public FlightDto getFlightById(Integer id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.get();
            FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
            return flightDto;
        } else {
            throw new ResourceNotFoundException("Flight not found");
        }
    }

    @Override
    public FlightDto createFlight(Flight flight) {
        if (flight.getEconomyPrice() < 0 || flight.getBusinessPrice() < 0) {
            throw new ConflictException("Price < 0");
        }
        if (flight.getEconomySeatBookedNumber() < 0 || flight.getBusinessSeatBookedNumber() < 0) {
            throw new ConflictException("Seat booked number < 0");
        }
        if (flight.getArrivalAirport().equals(flight.getDepartureAirport())) {
            throw new ConflictException("Departure airport is the same as Arrival airport");
        }
        if (!flight.getArrivalTime().isAfter(flight.getDepartureTime())) {
            throw new ConflictException("Arrival time is not after Departure time");
        }
        Flight newFlight = flightRepository.save(flight);
        FlightDto newFlightDto = modelMapper.map(newFlight, FlightDto.class);
        return newFlightDto;
    }


    @Override
    public List<FlightDto> findAppropriateFlight(FindFlightRequest findFlightRequest) {
        List<Flight> flights = flightRepository.findByRequest(
                findFlightRequest.getDepartureAirportId(),
                findFlightRequest.getArrivalAirportId(),
                findFlightRequest.getDepartureDate(),
                findFlightRequest.getPassengerNumber());
        List<FlightDto> flightDtos = flights.stream().map(flight -> {
                    FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
                    return flightDto;
                })
                .collect(Collectors.toList());

        return flightDtos;
    }

    @Override
    public FlightDto updateFlight(Integer id, Flight updateFlight) {
        if (updateFlight.getEconomyPrice() < 0 || updateFlight.getBusinessPrice() < 0) {
            throw new ConflictException("Price < 0");
        }
        if (updateFlight.getEconomySeatBookedNumber() < 0 || updateFlight.getBusinessSeatBookedNumber() < 0) {
            throw new ConflictException("Seat booked number < 0");
        }

        if (updateFlight.getArrivalAirport().equals(updateFlight.getDepartureAirport())) {
            throw new ConflictException("Departure airport is the same as  Arrival airport");
        }
        if (!updateFlight.getArrivalTime().isAfter(updateFlight.getDepartureTime())) {
            throw new ConflictException("Arrival time is not after Departure time");
        }

        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.get();

            flight.setFlightNumber(updateFlight.getFlightNumber());
            flight.setDepartureTime(updateFlight.getDepartureTime());
            flight.setArrivalTime(updateFlight.getArrivalTime());
            flight.setFlightStatus(updateFlight.getFlightStatus());
            flight.setEconomyPrice(updateFlight.getEconomyPrice());
            flight.setBusinessPrice(updateFlight.getBusinessPrice());
            flight.setEconomySeatBookedNumber(updateFlight.getEconomySeatBookedNumber());
            flight.setBusinessSeatBookedNumber(updateFlight.getBusinessSeatBookedNumber());
            flight.setAirplane(updateFlight.getAirplane());
            flight.setDepartureAirport(updateFlight.getDepartureAirport());
            flight.setArrivalAirport(updateFlight.getArrivalAirport());

            Flight updatedFlight = flightRepository.save(flight);
            FlightDto flightDto = modelMapper.map(updatedFlight, FlightDto.class);
            return flightDto;
        } else {
            throw new ResourceNotFoundException("Flight not found!");
        }
    }

    @Override
    public void deleteFlightById(Integer id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            flightRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Flight not found with id: " + id);
        }
    }

    @Override
    public void updateSeatBookedNumber(Integer id, String seatClass, Integer count) {
        if (count < 0) {
            throw new ConflictException("Seat count < 0");
        }
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.get();

            if (seatClass.equals("Economy")) {
                flight.setEconomySeatBookedNumber(count);
            } else if (seatClass.equals("Business")) {
                flight.setBusinessSeatBookedNumber(count);
            }

            flightRepository.save(flight);
        } else {
            throw new ResourceNotFoundException("Flight not found with id: " + id);
        }
    }
}
