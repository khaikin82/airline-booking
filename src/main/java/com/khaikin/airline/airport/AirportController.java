package com.khaikin.airline.airport;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/airports")
@RequiredArgsConstructor
public class AirportController {
    private final AirportService airportService;

    @GetMapping
    public ResponseEntity<List<Airport>> getAllAirports() {
        List<Airport> airports = airportService.getAllAirports();
        return ResponseEntity.ok(airports);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airport> getAirportById(@PathVariable Integer id) {
        Airport airport = airportService.getAirportById(id);
        return ResponseEntity.ok(airport);
    }

    @PostMapping
    public Airport createAirport(@RequestBody Airport airport) {
        return airportService.createAirport(airport);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirportById(@PathVariable Integer id) {
        airportService.deleteAirportById(id);
        return ResponseEntity.noContent().build();
    }

}
