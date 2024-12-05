//package com.khaikin.airline.seat;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//public class SeatServiceImpl implements SeatService {
//    private final SeatRepository seatRepository;
//
//    @Override
//    public List<Seat> getAllSeats() {
//        return seatRepository.findAll();
//    }
//
//    @Override
//    public Seat createSeat(Seat seat) {
//        return seatRepository.save(seat);
//    }
//
//    @Override
//    public boolean checkSeatAvailable(Seat seat) {
//        return seatRepository.findByIsAvailable(seat);
//    }
//
//    @Override
//    public boolean checkSeatAvailable(Long seatId) {
//        Optional<Seat> seat = seatRepository.findById(seatId);
//        return seat.map(Seat::isAvailable).orElse(false);
//    }
//}
