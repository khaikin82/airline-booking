package com.khaikin.airline.flight;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airport.Airport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
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
    private String status;

    @JsonBackReference("airplane")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;


    @JsonBackReference("departure")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "departure_airport_id")
    private Airport departureAirport;

    @JsonBackReference("arrival")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "arrival_airport_id")
    private Airport arrivalAirport;

//    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Reservation> reservations;
}
