package com.khaikin.airline.passenger;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.khaikin.airline.booking.Booking;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Passenger {
    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(EnumType.STRING)
    private PassengerTitle passengerTitle; // MR, MRS, MS, DOCTOR, PROFESSOR


    private String firstname;
    private String lastname;

    @Enumerated(EnumType.STRING)
    private PassengerType passengerType; // ADULT, CHILD, INFANT

    private String dob;

    @JsonBackReference("passenger")
    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    public Passenger(PassengerTitle passengerTitle, String firstname, String lastname, PassengerType passengerType,
                     String dob) {
        this.passengerTitle = passengerTitle;
        this.firstname = firstname;
        this.lastname = lastname;
        this.passengerType = passengerType;
        this.dob = dob;
    }

    public Passenger(PassengerTitle passengerTitle, String firstname, String lastname, PassengerType passengerType,
                     String dob, Booking booking) {
        this.passengerTitle = passengerTitle;
        this.firstname = firstname;
        this.lastname = lastname;
        this.passengerType = passengerType;
        this.dob = dob;
        this.booking = booking;
    }
}
