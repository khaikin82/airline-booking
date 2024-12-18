package com.khaikin.airline.booking;

import com.khaikin.airline.booking.dto.SearchBookingRequest;
import com.khaikin.airline.exception.ResourceNotFoundException;
import com.khaikin.airline.flight.FlightRepository;
import com.khaikin.airline.flight.FlightService;
import com.khaikin.airline.passenger.Passenger;
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
    private final FlightRepository flightRepository;
    private final FlightService flightService;

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
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
    public Booking createBooking(Booking booking) {
        booking.setReservationTime(LocalDateTime.now());
        if (!booking.getIsRoundTrip()) {
            booking.setReturnFlight(null);
        }
//        if (booking.getFlight().getId()??
        Booking savedBooking = booking;
        while (true) {
            try {
                booking.setCode(generateRandomString(6));
                savedBooking = bookingRepository.save(booking);
                break;
            } catch (Exception ignored) {

            }
        }

        updateSeatBookedNumber(savedBooking);

        return savedBooking;
    }

    @Override
    public Booking updateBooking(Integer id, Booking updateBooking) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();

            Integer flightId = booking.getFlight().getId();
            String seatClass = booking.getSeatClass();
            Integer returnFlightId = null;
            String returnSeatClass = null;

            if (booking.getIsRoundTrip() && booking.getReturnFlight() != null) {
                returnFlightId = booking.getReturnFlight().getId();
                returnSeatClass = booking.getReturnSeatClass();
            }

            booking.setEmail(updateBooking.getEmail());
            booking.setPhoneNumber(updateBooking.getPhoneNumber());
            booking.setFlight(updateBooking.getFlight());
            booking.setSeatClass(updateBooking.getSeatClass());
            booking.setPrice(updateBooking.getPrice());
            booking.setBookingStatus(updateBooking.getBookingStatus());
            booking.setUser(updateBooking.getUser());

//            booking.setPassengers(updateBooking.getPassengers());

            booking.setIsRoundTrip(updateBooking.getIsRoundTrip());

            if (!booking.getIsRoundTrip()) {
                booking.setReturnFlight(null);
            } else {
                booking.setReturnSeatClass(updateBooking.getReturnSeatClass());
                booking.setReturnFlight(updateBooking.getReturnFlight());
            }

            Booking savedBooking = bookingRepository.save(booking);


            Integer count = bookingRepository.countSeatBookedNumber(flightId, seatClass);
            flightService.updateSeatBookedNumber(flightId, seatClass, count);
            if (returnFlightId != null && returnSeatClass != null) {
                Integer returnCount = bookingRepository.countSeatBookedNumber(returnFlightId, returnSeatClass);
                flightService.updateSeatBookedNumber(returnFlightId, returnSeatClass, returnCount);
            }

            updateSeatBookedNumber(savedBooking);
            return savedBooking;
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

    @Override
    public Booking searchBooking(SearchBookingRequest searchBookingRequest) {
        Optional<Booking> bookingOptional = bookingRepository.findByCode(searchBookingRequest.getCode());
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            boolean flag = false;
            for (Passenger passenger : booking.getPassengers()) {
                if (passenger.getLastname().equals(searchBookingRequest.getLastname())) {
                    flag = true;
                    break;
                }
            }
            if (flag) return booking;
        }
        throw new ResourceNotFoundException("Booking not found");
    }

    @Override
    public void deleteBookingById(Integer id) {
        Optional<Booking> bookingOptional = bookingRepository.findById(id);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();

            Integer flightId = booking.getFlight().getId();
            String seatClass = booking.getSeatClass();
            Integer returnFlightId = null;
            String returnSeatClass = null;

            if (booking.getIsRoundTrip() && booking.getReturnFlight() != null) {
                returnFlightId = booking.getReturnFlight().getId();
                returnSeatClass = booking.getReturnSeatClass();
            }

            bookingRepository.deleteById(id);

            Integer count = bookingRepository.countSeatBookedNumber(flightId, seatClass);
            flightService.updateSeatBookedNumber(flightId, seatClass, count);

            if (returnFlightId != null && returnSeatClass != null) {
                Integer returnCount = bookingRepository.countSeatBookedNumber(returnFlightId, returnSeatClass);
                flightService.updateSeatBookedNumber(returnFlightId, returnSeatClass, returnCount);
            }
        } else {
            throw new ResourceNotFoundException("Booking not found with id: " + id);
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

    private void updateSeatBookedNumber(Booking booking) {
        Integer flightId = booking.getFlight().getId();
        String seatClass = booking.getSeatClass();
        Integer count = bookingRepository.countSeatBookedNumber(flightId, seatClass);
        flightService.updateSeatBookedNumber(flightId, seatClass, count);

        if (booking.getIsRoundTrip() && booking.getReturnFlight() != null) {
            Integer returnFlightId = booking.getReturnFlight().getId();
            String returnSeatClass = booking.getReturnSeatClass();
            Integer returnCount = bookingRepository.countSeatBookedNumber(returnFlightId, returnSeatClass);
            flightService.updateSeatBookedNumber(returnFlightId, returnSeatClass, returnCount);
        }
    }
}
