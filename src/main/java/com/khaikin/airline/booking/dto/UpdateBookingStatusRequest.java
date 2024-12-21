package com.khaikin.airline.booking.dto;

import com.khaikin.airline.booking.BookingStatus;
import lombok.Data;

@Data
public class UpdateBookingStatusRequest {
    private Integer id;
    private BookingStatus bookingStatus;
}
