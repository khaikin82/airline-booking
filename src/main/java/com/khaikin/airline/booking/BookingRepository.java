package com.khaikin.airline.booking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    @Query("SELECT COUNT(b) FROM Booking b " +
            "WHERE (b.flight.id = :flightId " +
            "AND b.seatClass = :seatClass) " +
            "OR (b.returnFlight.id = :flightId " +
            "AND b.returnSeatClass = :seatClass) "
    )
    Integer countSeatBookedNumber(@Param("flightId") Integer flightId,
                                  @Param("seatClass") String seatClass
    );
}
