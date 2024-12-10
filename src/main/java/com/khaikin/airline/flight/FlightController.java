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
    public ResponseEntity<FlightDto> createFlight(@RequestBody Flight flight) {
        FlightDto newFlightDto = flightService.createFlight(flight);
        return ResponseEntity.ok(newFlightDto);
    }

    @PostMapping("/find")
    public List<FlightDto> findAppropriateFlight(@RequestBody FindFlightRequest findFlightRequest) {
        return flightService.findAppropriateFlight(findFlightRequest);
    }


    @PutMapping("/{id}")
    public ResponseEntity<FlightDto> updateAirplane(@PathVariable Integer id, @RequestBody Flight updateFlight) {
        FlightDto updatedFlight = flightService.updateFlight(id, updateFlight);
        return ResponseEntity.ok(updatedFlight);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirplaneById(@PathVariable Integer id) {
        flightService.deleteFlightById(id);
        return ResponseEntity.noContent().build();
    }

}
