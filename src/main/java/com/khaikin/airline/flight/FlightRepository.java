package com.khaikin.airline.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query(" SELECT f FROM Flight f " +
            "WHERE f.departureAirport.id = :departureAirportId " +
            "AND f.arrivalAirport.id = :arrivalAirportId " +
            "AND DATE(f.departureTime) = :departureDate " +
            "AND 0 < :passengerNumber"
    )
    List<Flight> findByRequest(@Param("departureAirportId") Integer departureAirportId,
                               @Param("arrivalAirportId") Integer arrivalAirportId,
                               @Param("departureDate") LocalDate departureDate,
                               @Param("passengerNumber") Integer passengerNumber
    );

}
