package com.khaikin.airline.flight;

import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airplane.AirplaneDto;
import com.khaikin.airline.airplane.AirplaneRepository;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.airport.AirportDto;
import com.khaikin.airline.airport.AirportRepository;
import com.khaikin.airline.exception.ResourceNotFoundException;
import com.khaikin.airline.flight.dto.FindFlightRequest;
import com.khaikin.airline.flight.dto.FlightDto;
import jakarta.transaction.Transactional;
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
    private final AirplaneRepository airplaneRepository;
    private final AirportRepository airportRepository;
    private final ModelMapper modelMapper;


    @Override
    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        List<FlightDto> flightDtos = flights.stream().map(flight -> {
                    FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
                    AirplaneDto airplaneDto = modelMapper.map(flight.getAirplane(), AirplaneDto.class);
                    AirportDto departureAirportDto = modelMapper.map(flight.getDepartureAirport(), AirportDto.class);
                    AirportDto arrivalAirportDto = modelMapper.map(flight.getArrivalAirport(), AirportDto.class);

                    flightDto.setAirplane(airplaneDto);
                    flightDto.setDepartureAirport(departureAirportDto);
                    flightDto.setArrivalAirport(arrivalAirportDto);
                    return flightDto;
                })
                .collect(Collectors.toList());
        return flightDtos;
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public FlightDto getFlightById(Integer id) {
        Optional<Flight> flightOptional = flightRepository.findById(id);
        if (flightOptional.isPresent()) {
            Flight flight = flightOptional.get();
            FlightDto flightDto = modelMapper.map(flight, FlightDto.class);
            AirplaneDto airplaneDto = modelMapper.map(flight.getAirplane(), AirplaneDto.class);
            AirportDto departureAirportDto = modelMapper.map(flight.getDepartureAirport(), AirportDto.class);
            AirportDto arrivalAirportDto = modelMapper.map(flight.getArrivalAirport(), AirportDto.class);

            flightDto.setAirplane(airplaneDto);
            flightDto.setDepartureAirport(departureAirportDto);
            flightDto.setArrivalAirport(arrivalAirportDto);

            return flightDto;
        } else {
            throw new ResourceNotFoundException("Flight not found");
        }
    }

    @Transactional
    public Flight updateAirplane(Integer flightId, Integer airplaneId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found"));
        Airplane airplane = airplaneRepository.findById(airplaneId)
                .orElseThrow(() -> new ResourceNotFoundException("Airplane not found"));
        flight.setAirplane(airplane);
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateDepartureAirport(Integer flightId, Integer airportId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found"));
        Airport airport = airportRepository.findById(airportId)
                .orElseThrow(() -> new ResourceNotFoundException("Departure Airport not found"));
        flight.setDepartureAirport(airport);
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateDepartureAirport(Flight flight, Airport airport) {
        flight.setDepartureAirport(airport);
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateArrivalAirport(Integer flightId, Integer airportId) {
        Flight flight = flightRepository.findById(flightId)
                .orElseThrow(() -> new ResourceNotFoundException("Flight not found"));
        Airport airport = airportRepository.findById(airportId)
                .orElseThrow(() -> new ResourceNotFoundException("Arrival Airport not found"));
        flight.setArrivalAirport(airport);
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateArrivalAirport(Flight flight, Airport airport) {
        flight.setArrivalAirport(airport);
        return flightRepository.save(flight);
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
                    AirplaneDto airplaneDto = modelMapper.map(flight.getAirplane(), AirplaneDto.class);
                    AirportDto departureAirportDto = modelMapper.map(flight.getDepartureAirport(), AirportDto.class);
                    AirportDto arrivalAirportDto = modelMapper.map(flight.getArrivalAirport(), AirportDto.class);

                    flightDto.setAirplane(airplaneDto);
                    flightDto.setDepartureAirport(departureAirportDto);
                    flightDto.setArrivalAirport(arrivalAirportDto);
                    return flightDto;
                })
                .collect(Collectors.toList());

        return flightDtos;
    }
}
