package com.khaikin.airline.passenger;

import lombok.Data;

@Data
public class PassengerNumberRequest {
    private Integer adults = 1;
    private Integer children = 0;
    private Integer infant = 0;
}
