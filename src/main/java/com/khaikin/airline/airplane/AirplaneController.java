package com.khaikin.airline.airplane;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/airplanes")
@RequiredArgsConstructor
public class AirplaneController {
    private final AirplaneService airplaneService;

    @GetMapping
    public ResponseEntity<List<Airplane>> getAllAirplanes() {
        List<Airplane> airplanes = airplaneService.getAllAirplanes();
        return ResponseEntity.ok(airplanes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable Integer id) {
        Airplane airplane = airplaneService.getAirplaneById(id);
        return ResponseEntity.ok(airplane);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirplaneById(@PathVariable Integer id) {
        airplaneService.deleteAirplaneById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public Airplane createAirplane(@RequestBody Airplane airplane) {
        return airplaneService.createAirplane(airplane);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airplane> updateAirplane(@PathVariable Integer id, @RequestBody Airplane updateAirplane) {
        Optional<Airplane> updatedAirplane = airplaneService.updateAirplane(id, updateAirplane);
        return updatedAirplane.map(airplane -> ResponseEntity.ok().body(airplane))
                .orElse(ResponseEntity.notFound().build());
    }
}
