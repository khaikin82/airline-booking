package com.khaikin.airline.airport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaikin.airline.flight.Flight;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Airport {
    @Id
    @GeneratedValue
    public Integer id;

    private String name;
    private String code;

    private String region;
    private String city;

    private String description;
    private String imageUrl;

    private Boolean isActive = true;

    @JsonIgnore
    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departureFlights;


    @JsonIgnore
    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivalFlights;

    public Airport(String name, String code, String region, String city) {
        this.name = name;
        this.code = code;
        this.region = region;
        this.city = city;
    }

    public Airport(String name, String code, String region, String city, Boolean isActive) {
        this.name = name;
        this.code = code;
        this.region = region;
        this.city = city;
        this.isActive = isActive;
    }

    public Airport(String name, String code, String region, String city, String description) {
        this.name = name;
        this.code = code;
        this.region = region;
        this.city = city;
        this.description = description;
    }

    public Airport(String name, String code, String region, String city, String description, String imageUrl) {
        this.name = name;
        this.code = code;
        this.region = region;
        this.city = city;
        this.description = description;
        this.imageUrl = imageUrl;
    }
}
