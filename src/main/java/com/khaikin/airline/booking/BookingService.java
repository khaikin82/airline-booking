package com.khaikin.airline.booking;

import java.util.List;

public interface BookingService {
    public List<Booking> getAllBookings();

    public Booking createBooking(Booking booking);

    public void deleteBookingById(Integer id);

    public Booking updateBooking(Integer id, Booking updateBooking);

    public Booking updateBookingStatus(Integer id, BookingStatus bookingStatus);
}
