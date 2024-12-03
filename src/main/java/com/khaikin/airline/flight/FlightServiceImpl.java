package com.khaikin.airline.flight;

import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airplane.AirplaneRepository;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.airport.AirportRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private final AirplaneRepository airplaneRepository;
    private final AirportRepository airportRepository;

    @Override
    public List<Flight> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Transactional
    public Flight updateAirplane(Integer flightId, Integer airplaneId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));
        Airplane airplane = airplaneRepository.findById(airplaneId)
                .orElseThrow(() -> new RuntimeException("Airplane not found"));
        flight.setAirplane(airplane);
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateDepartureAirport(Integer flightId, Integer airportId) {
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));
        Airport airport = airportRepository.findById(airportId)
                .orElseThrow(() -> new RuntimeException("Departure Airport not found"));
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
        Flight flight = flightRepository.findById(flightId).orElseThrow(() -> new RuntimeException("Flight not found"));
        Airport airport = airportRepository.findById(airportId)
                .orElseThrow(() -> new RuntimeException("Arrival Airport not found"));
        flight.setArrivalAirport(airport);
        return flightRepository.save(flight);
    }

    @Override
    public Flight updateArrivalAirport(Flight flight, Airport airport) {
        flight.setArrivalAirport(airport);
        return flightRepository.save(flight);
    }


    @Override
    public List<Flight> findAppropriateFlight(FindFlightRequest findFlightRequest) {
        return flightRepository.findByRequest(
                findFlightRequest.getDepartureAirportName(),
                findFlightRequest.getArrivalAirportName(),
                findFlightRequest.getDepartureDate(),
                findFlightRequest.getPassengerNumber());
    }
}
