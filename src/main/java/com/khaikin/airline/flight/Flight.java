package com.khaikin.airline.flight;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.khaikin.airline.airplane.Airplane;
import com.khaikin.airline.airport.Airport;
import com.khaikin.airline.booking.Booking;
import com.khaikin.airline.seatclass.SeatClass;
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
    private String status;


    @JsonManagedReference("seatClass")
    @OneToMany(mappedBy = "flight", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<SeatClass> seatClasses;

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

    @JsonManagedReference("booking")
    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL)
    private List<Booking> bookings;

}
