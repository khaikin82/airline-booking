package com.khaikin.airline.airplane;

import lombok.Data;

@Data
public class AirplaneDto {
    private Integer id;

    // meaningful code to identify airplane
    private String code;

    private String model;
    private String manufacturer;
    private int capacity;
}
