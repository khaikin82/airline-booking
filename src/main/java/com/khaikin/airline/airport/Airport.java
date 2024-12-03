package com.khaikin.airline.airport;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    private String area;
    private String city;


    @JsonManagedReference("departure")
    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departureFlights;


    @JsonManagedReference("arrival")
    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivalFlights;

    public Airport(String name, String code, String area, String city) {
        this.name = name;
        this.code = code;
        this.area = area;
        this.city = city;
    }

    ;

}
