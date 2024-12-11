package com.khaikin.airline.flight;

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
}
