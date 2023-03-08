package com.salt.flightFinderApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Itinerary {

    @Id
    @Column(name = "flight_id")
    private String flight_id;

    @JsonProperty("departureAt")
    @Column(name = "flight_departureAt")
    private String flight_departureAt;
    @JsonProperty("arrivalAt")
    @Column(name = "flight_arrivalAt")
    private String flight_arrivalAt;
    @JsonProperty("availableSeats")
    @Column(name = "flight_availableSeats")
    private int flight_availableSeats;
    @JsonProperty("prices")
    @Column(name = "flight_prices")
    @Embedded
    private Price flight_prices;
//    @ManyToOne
//    private Route route;
}
