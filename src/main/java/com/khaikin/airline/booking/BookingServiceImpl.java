package com.khaikin.airline.booking;

import com.khaikin.airline.exception.ResourceNotFoundException;
import com.khaikin.airline.passenger.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final PassengerRepository passengerRepository;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking createBooking(Booking booking) {
        booking.setReservationTime(LocalDateTime.now());
        Booking savedBooking = booking;
        while (true) {
            try {
                booking.setCode(generateRandomString(6));
                savedBooking = bookingRepository.save(booking);
                break;
            } catch (Exception ignored) {

            }
        }

        return savedBooking;
    }

    @Override
    public Booking getBookingById(Integer id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            return booking.get();
        } else {
            throw new ResourceNotFoundException("Booking not found");
        }
    }

    @Override
    public void deleteBookingById(Integer id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isPresent()) {
            bookingRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Booking not found with id: " + id);
        }
    }

    @Override
    public Booking updateBooking(Integer id, Booking updateBooking) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setEmail(updateBooking.getEmail());
            booking.setPhoneNumber(updateBooking.getPhoneNumber());
            booking.setFlight(updateBooking.getFlight());
            booking.setPassengers(updateBooking.getPassengers());
            booking.setBookingStatus(updateBooking.getBookingStatus());
            booking.setUser(updateBooking.getUser());
            return bookingRepository.save(booking);
        } else {
            throw new ResourceNotFoundException("Booking not found");
        }
    }

    @Override
    public Booking updateBookingStatus(Integer id, BookingStatus bookingStatus) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            booking.setBookingStatus(bookingStatus);
            return bookingRepository.save(booking);
        } else {
            throw new ResourceNotFoundException("Booking not found");
        }
    }

    private String generateRandomString(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        final SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}
