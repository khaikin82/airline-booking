package com.khaikin.airline.booking;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingDto {
    private Integer id;

    private String code;

    private String email;
    private String phoneNumber;

    private BookingStatus bookingStatus;

    private LocalDateTime reservationTime;
}
