package com.khaikin.airline.booking;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {
        return bookingService.createBooking(booking);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Booking> updateBooking(@PathVariable Integer id, @RequestBody Booking updateBooking) {
        Booking updatedBooking = bookingService.updateBooking(id, updateBooking);
        return ResponseEntity.ok(updatedBooking);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Booking> updateBookingStatus(@PathVariable Integer id,
                                                       @RequestParam BookingStatus bookingStatus) {
        Booking updatedBooking = bookingService.updateBookingStatus(id, bookingStatus);
        return ResponseEntity.ok(updatedBooking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingById(@PathVariable Integer id) {
        bookingService.deleteBookingById(id);
        return ResponseEntity.noContent().build();
    }
}
