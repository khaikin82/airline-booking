package com.khaikin.airline.booking;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private String seatClass;
    private String returnSeatClass;

    private Integer price;

    private Boolean isRoundTrip = false;

    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus = BookingStatus.PENDING;

    private LocalDateTime reservationTime;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "return_flight_id")
    private Flight returnFlight;

    @JsonManagedReference("passenger")
    @OneToMany(mappedBy = "booking", cascade = CascadeType.ALL)
    private List<Passenger> passengers = new ArrayList<>();

    public Booking(String email, String phoneNumber, Flight flight) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.flight = flight;
    }

    public Booking(String email, String phoneNumber, Flight flight, List<Passenger> passengers) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.flight = flight;
        this.passengers = passengers;
    }

    public Booking(String email, String phoneNumber, Flight flight, String seatType, Integer price) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.flight = flight;
        this.seatClass = seatType;
        this.price = price;
    }

    public Booking(String email, String phoneNumber, String seatClass, String returnSeatClass, Integer price,
                   Boolean isRoundTrip, Flight flight, Flight returnFlight) {
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.seatClass = seatClass;
        this.returnSeatClass = returnSeatClass;
        this.price = price;
        this.isRoundTrip = isRoundTrip;
        this.flight = flight;
        this.returnFlight = returnFlight;
    }
}
