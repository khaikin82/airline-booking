package com.khaikin.airline.seatclass.dto;

import com.khaikin.airline.seatclass.SeatClassType;
import lombok.Data;

@Data
public class SeatClassUpdateDto {
    private SeatClassType seatClassType;
    private Long price;
    private Integer totalNumber;
}
