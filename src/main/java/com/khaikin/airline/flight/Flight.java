package com.khaikin.airline.flight;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.booking.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String flightNumber;

    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    private FlightStatus flightStatus;

    private Long economyPrice;
    private Long businessPrice;
    private Integer economySeatBookedNumber = 0;
    private Integer businessSeatBookedNumber = 0;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

    @JsonIgnore
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    public Flight(LocalDateTime departureTime, String flightNumber, LocalDateTime arrivalTime,
                  FlightStatus flightStatus,
                  Airplane airplane, Airport departureAirport, Airport arrivalAirport) {
        this.departureTime = departureTime;
        this.flightNumber = flightNumber;
        this.arrivalTime = arrivalTime;
        this.flightStatus = flightStatus;
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

}
