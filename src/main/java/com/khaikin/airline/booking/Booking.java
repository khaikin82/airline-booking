package com.khaikin.airline.booking;

import com.khaikin.airline.flight.Flight;
import com.khaikin.airline.passenger.Passenger;
import com.khaikin.airline.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToMany
    @JoinTable(
            name = "booking_passenger",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_id"))
    private List<Passenger> passengers = new ArrayList<>();


    private Date reservationDate;
    private String status; // Example: Pending, CONFIRMED, CANCELLED, Completed


}
