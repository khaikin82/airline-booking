package com.khaikin.airline.booking;

import com.khaikin.airline.booking.dto.SearchBookingRequest;

import java.util.List;

public interface BookingService {
    public List<Booking> getAllBookings();

    public Booking getBookingById(Integer id);

    public Booking createBooking(Booking booking);

    public Booking updateBooking(Integer id, Booking updateBooking);

    public Booking updateBookingStatus(Integer id, BookingStatus bookingStatus);

    public Booking searchBooking(SearchBookingRequest searchBookingRequest);

    public void deleteBookingById(Integer id);
}
