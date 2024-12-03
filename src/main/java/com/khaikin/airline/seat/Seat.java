package com.khaikin.airline.seat;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Seat {
    @Id
    @GeneratedValue
    private Long id;

    private String code;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    private Long price;

    private boolean isAvailable;

//    @JsonBackReference("seat")
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "flight_id")
//    private Flight flight;

    public Seat(String code, SeatType seatType, Long price, boolean isAvailable) {
        this.code = code;
        this.seatType = seatType;
        this.price = price;
        this.isAvailable = isAvailable;
    }
}
