//package com.khaikin.airline.seat;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/seats")
//@RequiredArgsConstructor
//public class SeatController {
//    private final SeatService seatService;
//
//    @GetMapping
//    public List<Seat> getAllSeats() {
//        return seatService.getAllSeats();
//    }
//
//    @PostMapping
//    public Seat createSeat(@RequestBody Seat seat) {
//        return seatService.createSeat(seat);
//    }
//
//    @GetMapping("/check/{seatId}")
//    public boolean checkSeat(@PathVariable Long seatId) {
//        return seatService.checkSeatAvailable(seatId);
//    }
//}
