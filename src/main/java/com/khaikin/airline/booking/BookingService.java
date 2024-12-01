package com.khaikin.airline.booking;

import java.util.List;

public interface BookingService {
    public List<Booking> getAllBookings();

    public Booking createBooking(Booking booking);
}
