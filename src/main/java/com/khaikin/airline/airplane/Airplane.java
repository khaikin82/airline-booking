package com.khaikin.airline.airplane;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.khaikin.airline.flight.Flight;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Airplane {
    @Id
    @GeneratedValue
    private Integer id;

    // meaningful code to identify airplane
    @Column(unique = true)
    private String code;

    private String model;
    private String manufacturer;

    private Integer economySeatNumber;
    private Integer businessSeatNumber;

    private Boolean isActive = true;

    @JsonIgnore
    @OneToMany(mappedBy = "airplane", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Flight> flights = new ArrayList<>();

    public Airplane(String code, String model, String manufacturer, Integer economySeatNumber,
                    Integer businessSeatNumber) {
        this.code = code;
        this.model = model;
        this.manufacturer = manufacturer;
        this.economySeatNumber = economySeatNumber;
        this.businessSeatNumber = businessSeatNumber;
    }

    public Airplane(String code, String model, String manufacturer, Integer economySeatNumber,
                    Integer businessSeatNumber,
                    Boolean isActive) {
        this.code = code;
        this.model = model;
        this.manufacturer = manufacturer;
        this.economySeatNumber = economySeatNumber;
        this.businessSeatNumber = businessSeatNumber;
        this.isActive = isActive;
    }
}
