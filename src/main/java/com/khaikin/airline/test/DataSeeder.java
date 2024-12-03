package com.khaikin.airline.test;

import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airplane.AirplaneService;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.airport.AirportService;
import com.khaikin.airline.flight.Flight;
import com.khaikin.airline.flight.FlightService;
import com.khaikin.airline.seatclass.SeatClass;
import com.khaikin.airline.seatclass.SeatClassService;
import com.khaikin.airline.seatclass.SeatClassType;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

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
        Airport airport1 = new Airport("Noi Bai International Airport", "HAN", "Viet Nam", "Ha Noi, Viet Nam");
        Airport airport2 = new Airport("Changi Airport", "SIN", "Southeast Asia", "Singapore, Singapore");
        Airport airport3 = new Airport("Tokyo Haneda Airport", "HND", "Asia", "Tokyo, Japan");
        Airport airport4 = new Airport("Incheon International Airport", "ICN", "Asia", "Seoul, South Korea");
        Airport airport5 = new Airport("Heathrow Airport", "LHR", "Europe", "London, United Kingdom");
        Airport airport6 = new Airport("Charles de Gaulle Airport", "CDG", "Europe", "Paris, France");
        Airport airport7 = new Airport("Frankfurt Airport", "FRA", "Europe", "Frankfurt, Germany");
        Airport airport8 = new Airport("John F. Kennedy International Airport", "JFK", "North America",
                                       "New York, USA");
        Airport airport9 = new Airport("Los Angeles International Airport", "LAX", "North America", "Los Angeles, USA");
        Airport airport10 = new Airport("Sydney Kingsford Smith Airport", "SYD", "Oceania", "Sydney, Australia");
        Airport airport11 = new Airport("Kuala Lumpur International Airport", "KUL", "Southeast Asia",
                                        "Kuala Lumpur, Malaysia");
        Airport airport12 = new Airport("Tan Son Nhat International Airport", "SGN", "Southeast Asia",
                                        "Ho Chi Minh City, Viet Nam");
        Airport airport13 = new Airport("Da Nang International Airport", "DAD", "Southeast Asia", "Da Nang, Viet Nam");
        Airport airport14 = new Airport("Cam Ranh International Airport", "CXR", "Southeast Asia",
                                        "Khanh Hoa, Viet Nam");
        Airport airport15 = new Airport("Phu Quoc International Airport", "PQC", "Southeast Asia",
                                        "Phu Quoc, Viet Nam");
        Airport airport16 = new Airport("Cat Bi International Airport", "HPH", "Southeast Asia", "Hai Phong, Viet Nam");

        Airport airport17 = new Airport("Suvarnabhumi Airport", "BKK", "Southeast Asia", "Bangkok, Thailand");
        Airport airport18 = new Airport("Changi Airport", "SIN", "Southeast Asia", "Singapore, Singapore");

        airportService.createAirport(airport1);
        airportService.createAirport(airport2);
        airportService.createAirport(airport3);
        airportService.createAirport(airport4);
        airportService.createAirport(airport5);
        airportService.createAirport(airport6);
        airportService.createAirport(airport7);
        airportService.createAirport(airport8);
        airportService.createAirport(airport9);
        airportService.createAirport(airport10);
        airportService.createAirport(airport11);
        airportService.createAirport(airport12);
        airportService.createAirport(airport13);
        airportService.createAirport(airport14);
        airportService.createAirport(airport15);
        airportService.createAirport(airport16);
        airportService.createAirport(airport17);
        airportService.createAirport(airport18);


//        // seatTypes
//        List<Seat> seats = new ArrayList<>();
//        seats.add(new Seat("A1", SeatType.STANDARD, 10000L, true));
//        seats.add(new Seat("D1", SeatType.BUSINESS, 20000L, true));

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

        // airplane
        Airplane airplane1 = new Airplane();
        airplane1.setCode("AP001");
        airplane1.setModel("Boeing 737");
        airplane1.setManufacturer("Boeing");
        airplane1.setCapacity(180);

        Airplane airplane2 = new Airplane();
        airplane2.setCode("AP002");
        airplane2.setModel("Airbus A320");
        airplane2.setManufacturer("Airbus");
        airplane2.setCapacity(160);

        Airplane airplane3 = new Airplane();
        airplane3.setCode("AP003");
        airplane3.setModel("Boeing 787 Dreamliner");
        airplane3.setManufacturer("Boeing");
        airplane3.setCapacity(242);

        Airplane airplane4 = new Airplane();
        airplane4.setCode("AP004");
        airplane4.setModel("Airbus A350");
        airplane4.setManufacturer("Airbus");
        airplane4.setCapacity(300);

        Airplane airplane5 = new Airplane();
        airplane5.setCode("AP005");
        airplane5.setModel("Boeing 777");
        airplane5.setManufacturer("Boeing");
        airplane5.setCapacity(396);

        airplaneService.createAirplane(airplane1);
        airplaneService.createAirplane(airplane2);
        airplaneService.createAirplane(airplane3);
        airplaneService.createAirplane(airplane4);
        airplaneService.createAirplane(airplane5);


        // seatClass
        SeatClass seatClass1 = new SeatClass(SeatClassType.STANDARD, 1000L, 300, 12, flight0);
        SeatClass seatClass2 = new SeatClass(SeatClassType.BUSINESS, 2000L, 100, 8, flight0);
        
        seatClassService.createSeatClass(seatClass1);
        seatClassService.createSeatClass(seatClass2);

//        List<Flight> foundFlight = flightRepository.findByRequest(
//                LocalDate.of(2024, 1, 10),
//                LocalDate.of(2024, 1, 12));
//        System.out.println(foundFlight);

    }
}
