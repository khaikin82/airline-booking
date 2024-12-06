package com.khaikin.airline.flight;


import com.khaikin.airline.flight.dto.FindFlightRequest;
import com.khaikin.airline.flight.dto.FlightDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
@RequiredArgsConstructor
public class FlightController {
    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAllFlights() {
        List<FlightDto> flights = flightService.getAllFlights();
        return ResponseEntity.ok(flights);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FlightDto> getFlightById(@PathVariable Integer id) {
        FlightDto flightDto = flightService.getFlightById(id);
        return ResponseEntity.ok(flightDto);
    }

    @PostMapping
    public ResponseEntity<Flight> createFlight(@RequestBody Flight flight) {
        Flight newFlight = flightService.createFlight(flight);
        return ResponseEntity.ok(newFlight);
    }

    @PutMapping("/update-airplane")
    public ResponseEntity<Flight> updateAirplane(@RequestParam Integer flightId, @RequestParam Integer airplaneId) {
        Flight updatedFlight = flightService.updateAirplane(flightId, airplaneId);
        return ResponseEntity.ok(updatedFlight);
    }

    @PutMapping("/update-departure-airport")
    public ResponseEntity<Flight> updateDepartureAirport(@RequestParam Integer flightId,
                                                         @RequestParam Integer airportId) {
        Flight updatedFlight = flightService.updateDepartureAirport(flightId, airportId);
        return ResponseEntity.ok(updatedFlight);
    }

    @PutMapping("/update-arrival-airport")
    public ResponseEntity<Flight> updateArrivalAirport(@RequestParam Integer flightId,
                                                       @RequestParam Integer airportId) {
        Flight updatedFlight = flightService.updateDepartureAirport(flightId, airportId);
        return ResponseEntity.ok(updatedFlight);
    }

    @PostMapping("/find")
    public List<FlightDto> findAppropriateFlight(@RequestBody FindFlightRequest findFlightRequest) {
        return flightService.findAppropriateFlight(findFlightRequest);
    }
}
