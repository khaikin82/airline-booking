package com.khaikin.airline.airport;

import lombok.Data;

@Data
public class AirportDto {
    public Integer id;

    private String name;
    private String code;

    private String region;
    private String city;
}
