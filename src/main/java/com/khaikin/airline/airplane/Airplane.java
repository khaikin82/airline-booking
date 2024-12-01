package com.khaikin.airline.airplane;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.khaikin.airline.flight.Flight;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
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
    private int capacity;

    @JsonManagedReference("airplane")
    @OneToMany(mappedBy = "airplane", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Flight> flights = new ArrayList<>();
}
