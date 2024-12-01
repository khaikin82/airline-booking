package com.khaikin.airline.flight;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    @Query(" SELECT f FROM Flight f " +
            "WHERE f.departureAirport.name = :departureAirportName " +
            "AND f.arrivalAirport.name = :arrivalAirportName " +
            "AND DATE(f.departureTime) = :departureDate " +
            "AND DATE(f.arrivalTime) = :arrivalDate")
    List<Flight> findByRequest(@Param("departureAirportName") String departureAirportName,
                               @Param("arrivalAirportName") String arrivalAirportName,
                               @Param("departureDate") LocalDate departureDate,
                               @Param("arrivalDate") LocalDate arrivalDate
    );

    @Query(" SELECT f FROM Flight f " +
            "WHERE f.departureAirport.name = :departureAirportName " +
            "AND DATE(f.departureTime) = :departureDate " +
            "AND DATE(f.arrivalTime) = :arrivalDate")
    List<Flight> findByRequest(@Param("departureAirportName") String departureAirportName,
                               @Param("departureDate") LocalDate departureDate,
                               @Param("arrivalDate") LocalDate arrivalDate
    );
}
