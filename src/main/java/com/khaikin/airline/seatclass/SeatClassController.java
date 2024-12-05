//package com.khaikin.airline.seatclass;
//
//import com.khaikin.airline.seatclass.dto.SeatClassUpdateDto;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/v1/seat-classes")
//@RequiredArgsConstructor
//public class SeatClassController {
//    private final SeatClassService seatClassService;
//
//    @GetMapping
//    public List<SeatClass> getAllSeatClasses() {
//        return seatClassService.getAllSeatClasses();
//    }
//
//    @PostMapping
//    public SeatClass createSeatClass(@RequestBody SeatClass seatClass) {
//        return seatClassService.createSeatClass(seatClass);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<SeatClass> updateSeatClass(@PathVariable Integer id,
//                                                     @RequestBody SeatClassUpdateDto seatClassUpdateDto) {
//        Optional<SeatClass> updatedSeatClass = seatClassService.updateSeatClass(id, seatClassUpdateDto);
//        return updatedSeatClass.map(seatClass -> ResponseEntity.ok().body(seatClass))
//                .orElse(ResponseEntity.notFound().build());
//    }
//}
