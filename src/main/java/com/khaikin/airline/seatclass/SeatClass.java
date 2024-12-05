//package com.khaikin.airline.seatclass;
//
//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.khaikin.airline.flight.Flight;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(uniqueConstraints =
//        {@UniqueConstraint(name = "UniqueTypeAndFlight", columnNames = {"seatClassType", "flight_id"})})
//public class SeatClass {
//    @Id
//    @GeneratedValue
//    private Integer id;
//
//    @Enumerated(EnumType.STRING)
//    private SeatClassType seatClassType;
//
//    private Long price;
//    private Integer totalNumber;
//    private Integer bookedNumber;
//
//    @JsonBackReference("seatClass")
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "flight_id")
//    private Flight flight;
//
//    public SeatClass(SeatClassType seatClassType, Long price, Integer totalNumber, Integer bookedNumber,
//                     Flight flight) {
//        this.seatClassType = seatClassType;
//        this.price = price;
//        this.totalNumber = totalNumber;
//        this.bookedNumber = bookedNumber;
//        this.flight = flight;
//    }
//}
