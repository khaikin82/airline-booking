package com.khaikin.airline.test;

import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airplane.AirplaneService;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.airport.AirportService;
import com.khaikin.airline.flight.Flight;
import com.khaikin.airline.flight.FlightService;
import com.khaikin.airline.flight.FlightStatus;
import com.khaikin.airline.seatclass.SeatClass;
import com.khaikin.airline.seatclass.SeatClassService;
import com.khaikin.airline.seatclass.SeatClassType;
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
    private final AirplaneService airplaneService;
    private final SeatClassService seatClassService;

    @Override
    public void run(String... args)
            throws Exception {

        // airport
        List<Airport> airports = new ArrayList<>();

        airports.add(new Airport("Noi Bai International Airport", "HAN", "Viet Nam", "Ha Noi, Viet Nam"));
        airports.add(new Airport("Changi Airport", "SIN", "Southeast Asia", "Singapore, Singapore"));
        airports.add(new Airport("Tokyo Haneda Airport", "HND", "Asia", "Tokyo, Japan"));
        airports.add(new Airport("Incheon International Airport", "ICN", "Asia", "Seoul, South Korea"));
        airports.add(new Airport("Heathrow Airport", "LHR", "Europe", "London, United Kingdom"));
        airports.add(new Airport("Charles de Gaulle Airport", "CDG", "Europe", "Paris, France"));
        airports.add(new Airport("Frankfurt Airport", "FRA", "Europe", "Frankfurt, Germany"));
        airports.add(new Airport("John F. Kennedy International Airport", "JFK", "North America",
                                 "New York, USA"));
        airports.add(new Airport("Los Angeles International Airport", "LAX", "North America", "Los Angeles, USA"));
        airports.add(new Airport("Sydney Kingsford Smith Airport", "SYD", "Oceania", "Sydney, Australia"));
        airports.add(new Airport("Kuala Lumpur International Airport", "KUL", "Southeast Asia",
                                 "Kuala Lumpur, Malaysia"));
        airports.add(new Airport("Tan Son Nhat International Airport", "SGN", "Southeast Asia",
                                 "Ho Chi Minh City, Viet Nam"));
        airports.add(new Airport("Da Nang International Airport", "DAD", "Southeast Asia", "Da Nang, Viet Nam"));
        airports.add(new Airport("Cam Ranh International Airport", "CXR", "Southeast Asia",
                                 "Khanh Hoa, Viet Nam"));
        airports.add(new Airport("Phu Quoc International Airport", "PQC", "Southeast Asia",
                                 "Phu Quoc, Viet Nam"));
        airports.add(new Airport("Cat Bi International Airport", "HPH", "Southeast Asia", "Hai Phong, Viet Nam"));

        airports.add(new Airport("Suvarnabhumi Airport", "BKK", "Southeast Asia", "Bangkok, Thailand"));
        airports.add(new Airport("Changi Airport", "SIN", "Southeast Asia", "Singapore, Singapore"));

        for (Airport airport : airports) {
            airportService.createAirport(airport);
        }

        // airplane
        List<Airplane> airplanes = new ArrayList<>();
        airplanes.add(new Airplane("AP001", "Boeing 737", "Boeing", 180));
        airplanes.add(new Airplane("AP002", "Airbus A320", "Airbus", 160));
        airplanes.add(new Airplane("AP003", "Boeing 787", "Boeing", 242));
        airplanes.add(new Airplane("AP004", "Airbus A350", "Airbus", 300));
        airplanes.add(new Airplane("AP005", "Boeing 777", "Boeing", 396));

        airplanes.add(new Airplane("AP006", "Airbus A330", "Airbus", 300));
        airplanes.add(new Airplane("AP007", "Boeing 747", "Boeing", 416));
        airplanes.add(new Airplane("AP008", "Airbus A340", "Airbus", 380));
        airplanes.add(new Airplane("AP009", "Boeing 767", "Boeing", 290));
        airplanes.add(new Airplane("AP010", "Airbus A380", "Airbus", 555));

        for (Airplane airplane : airplanes) {
            airplaneService.createAirplane(airplane);
        }

        // flight

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(LocalDateTime.of(2024, 10, 4, 6, 0),
                               "VN123",
                               LocalDateTime.of(2024, 10, 4, 8, 0),
                               FlightStatus.ARRIVED, airplanes.get(0), airports.get(0), airports.get(1)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 4, 10, 0),
                               "VN456",
                               LocalDateTime.of(2024, 12, 4, 15, 0),
                               FlightStatus.IN_AIR, airplanes.get(1), airports.get(0), airports.get(5)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 6, 14, 0),
                               "VN789",
                               LocalDateTime.of(2024, 12, 6, 16, 0),
                               FlightStatus.SCHEDULED, airplanes.get(2), airports.get(1), airports.get(0)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 6, 15, 0),
                               "VN101",
                               LocalDateTime.of(2024, 12, 6, 20, 0),
                               FlightStatus.SCHEDULED, airplanes.get(0), airports.get(5), airports.get(10)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 8, 22, 0),
                               "VN102",
                               LocalDateTime.of(2024, 12, 9, 0, 0),
                               FlightStatus.CANCELLED, airplanes.get(3), airports.get(7), airports.get(0)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 9, 1, 0),
                               "VN103",
                               LocalDateTime.of(2024, 12, 9, 3, 0),
                               FlightStatus.SCHEDULED, airplanes.get(4), airports.get(0), airports.get(2)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 10, 5, 0),
                               "VN104",
                               LocalDateTime.of(2024, 12, 10, 7, 0),
                               FlightStatus.SCHEDULED, airplanes.get(0), airports.get(1), airports.get(0)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 11, 9, 0),
                               "VN105",
                               LocalDateTime.of(2024, 12, 11, 11, 0),
                               FlightStatus.SCHEDULED, airplanes.get(5), airports.get(0), airports.get(1)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 12, 13, 0),
                               "VN106",
                               LocalDateTime.of(2024, 12, 12, 15, 0),
                               FlightStatus.SCHEDULED, airplanes.get(2), airports.get(6), airports.get(9)));
        flights.add(new Flight(LocalDateTime.of(2024, 12, 13, 17, 0),
                               "VN107",
                               LocalDateTime.of(2024, 12, 13, 19, 0),
                               FlightStatus.SCHEDULED, airplanes.get(3), airports.get(8), airports.get(5)));

        for (Flight flight : flights) {
            flightService.createFlight(flight);
        }


        // seatClasses
        List<SeatClass> seatClasses = new ArrayList<>();
        seatClasses.add(new SeatClass(SeatClassType.ECONOMY, 1000000L, 200, 150, flights.get(0)));
        seatClasses.add(new SeatClass(SeatClassType.BUSINESS, 5000000L, 50, 30, flights.get(0)));
        seatClasses.add(new SeatClass(SeatClassType.ECONOMY, 1400000L, 190, 5, flights.get(1)));
        seatClasses.add(new SeatClass(SeatClassType.ECONOMY, 1200000L, 180, 160, flights.get(2)));
        seatClasses.add(new SeatClass(SeatClassType.BUSINESS, 4500000L, 60, 45, flights.get(1)));

        for (SeatClass seatClass : seatClasses) {
            seatClassService.createSeatClass(seatClass);
        }


    }
}
