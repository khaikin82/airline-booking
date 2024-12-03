package com.khaikin.airline.test;

import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.airport.AirportService;
import com.khaikin.airline.flight.Flight;
import com.khaikin.airline.flight.FlightRepository;
import com.khaikin.airline.flight.FlightService;
import com.khaikin.airline.seat.Seat;
import com.khaikin.airline.seat.SeatType;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DataSeeder implements CommandLineRunner {
    private final AirportService airportService;
    private final FlightService flightService;
    private final FlightRepository flightRepository;

    @Override
    public void run(String... args)
            throws Exception {

        // airport
        Airport airport1 = new Airport("Đà Nẵng", "VVDN/DAD",
                                       "Asean", "Viet Nam"
        );
        Airport airport2 = new Airport("Điện Biên Phủ", "VVDB/DIN",
                                       "Asean", "Viet Nam"
        );
        Airport airport3 = new Airport("Nội Bài", "VVNB/HAN",
                                       "Asean", "Viet Nam"
        );
        Airport airport4 = new Airport("Tân Sơn Nhất", "VVTS/SGN",
                                       "Asean", "Viet Nam"
        );


        airportService.createAirport(airport1);
        airportService.createAirport(airport2);
        airportService.createAirport(airport3);
        airportService.createAirport(airport4);

        // seatTypes
        List<Seat> seats = new ArrayList<>();
        seats.add(new Seat("A1", SeatType.STANDARD, 10000L, true));
        seats.add(new Seat("D1", SeatType.BUSINESS, 20000L, true));

        // flight
        Flight flight0 = new Flight();
        flight0.setFlightNumber("F0");
        flight0.setDepartureTime(LocalDateTime.of(2024, 1, 10, 0, 30));
        flight0.setArrivalTime(LocalDateTime.of(2024, 1, 12, 15, 15));
        flight0.setStatus("Hello");


        Flight flight1 = new Flight();
        flight1.setFlightNumber("F1");
        flight1.setDepartureTime(LocalDateTime.of(2024, 1, 10, 10, 30));
        flight1.setArrivalTime(LocalDateTime.of(2024, 1, 12, 5, 0));
        flight1.setStatus("Arrived");


        Flight flight2 = new Flight();
        flight2.setFlightNumber("F2");
        flight2.setDepartureTime(LocalDateTime.of(2024, 1, 12, 10, 0));
        flight2.setArrivalTime(LocalDateTime.of(2024, 1, 16, 2, 0));
        flight2.setStatus("Arrived");

        Flight flight3 = new Flight();
        flight3.setFlightNumber("F3");
        flight3.setDepartureTime(LocalDateTime.of(2024, 1, 1, 15, 30));
        flight3.setArrivalTime(LocalDateTime.of(2024, 1, 8, 5, 40));
        flight3.setStatus("Arrived");


        Flight flight4 = new Flight();
        flight4.setFlightNumber("F4");
        flight4.setDepartureTime(LocalDateTime.of(2024, 1, 9, 13, 30));
        flight4.setArrivalTime(LocalDateTime.of(2024, 1, 10, 15, 0));
        flight4.setStatus("Arrived");


        flightService.createFlight(flight0);
        flightService.createFlight(flight1);
        flightService.createFlight(flight2);
        flightService.createFlight(flight3);
        flightService.createFlight(flight4);


        flightService.updateDepartureAirport(flight0, airport1);
        flightService.updateArrivalAirport(flight0, airport2);
        flightService.updateDepartureAirport(flight1, airport1);
        flightService.updateArrivalAirport(flight1, airport3);

//        List<Flight> foundFlight = flightRepository.findByRequest(
//                LocalDate.of(2024, 1, 10),
//                LocalDate.of(2024, 1, 12));
//        System.out.println(foundFlight);

    }
}
