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

    @Query(" SELECT f FROM Flight f " +
            "WHERE f.airplane.id = :airplaneId " +
            "AND (f.flightStatus = 'SCHEDULED' OR f.flightStatus = 'IN_AIR') "
    )
    List<Flight> findFlightsInUseByAirplaneId(@Param("airplaneId") Integer airplaneId);

    @Query(" SELECT f FROM Flight f " +
            "WHERE (f.departureAirport.id = :airportId OR f.arrivalAirport.id = :airportId) " +
            "AND (f.flightStatus = 'SCHEDULED' OR f.flightStatus = 'IN_AIR') "
    )
    List<Flight> findFlightsInUseByAirportId(@Param("airportId") Integer airportId);


    @Query(" SELECT f FROM Flight f " +
            "WHERE f.airplane.id = :airplaneId " +
            "AND f.flightStatus = :flightStatus "
    )
    List<Flight> findFlightsByAirplaneIdAndFlightStatus(@Param("airplaneId") Integer airplaneId,
                                                        @Param("flightStatus") FlightStatus flightStatus

    );

    @Query(" SELECT f FROM Flight f " +
            "WHERE (f.departureAirport.id = :airportId OR f.arrivalAirport.id = :airportId) " +
            "AND f.flightStatus = :flightStatus "
    )
    List<Flight> findFlightsByAirportIdAndFlightStatus(@Param("airportId") Integer airportId,
                                                       @Param("flightStatus") FlightStatus flightStatus

    );
}
