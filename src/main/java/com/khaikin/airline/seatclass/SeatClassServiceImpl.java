package com.khaikin.airline.seatclass;

import com.khaikin.airline.seatclass.dto.SeatClassUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SeatClassServiceImpl implements SeatClassService {
    private final SeatClassRepository seatClassRepository;

    @Override
    public List<SeatClass> getAllSeatClasses() {
        return seatClassRepository.findAll();
    }

    @Override
    public SeatClass createSeatClass(SeatClass seatClass) {
        return seatClassRepository.save(seatClass);
    }

    @Override
    public Optional<SeatClass> updateSeatClass(Integer id, SeatClassUpdateDto seatClassUpdateDto) {
        return seatClassRepository.findById(id).map(seatClass -> {
            if (seatClassUpdateDto.getPrice() != null) {
                seatClass.setPrice(seatClassUpdateDto.getPrice());
            }
            if (seatClassUpdateDto.getSeatClassType() != null) {
                seatClass.setSeatClassType(seatClassUpdateDto.getSeatClassType());
            }
            return seatClassRepository.save(seatClass);
        });
    }


}
