package com.khaikin.airline.booking;

import com.khaikin.airline.passenger.PassengerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.List;

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
