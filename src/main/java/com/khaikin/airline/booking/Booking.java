package com.khaikin.airline.booking;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.khaikin.airline.flight.Flight;
import com.khaikin.airline.passenger.Passenger;
import com.khaikin.airline.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(unique = true)
    private String code;

    private String email;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @JsonBackReference("booking")
    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;


    @ManyToMany
    @JoinTable(
            name = "booking_passenger",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private List<Passenger> passengers = new ArrayList<>();


    private LocalDateTime reservationTime;
    private String status; // Example: Pending, CONFIRMED, CANCELLED, Completed


}
