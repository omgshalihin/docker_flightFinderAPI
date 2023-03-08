package com.salt.flightFinderApi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Flight {

    @Id
    private String flightId;
    private String flightDepartureAt;
    private String flightArrivalAt;
    private int flightAvailableSeats;
    @Embedded
    private Price flightPrices;

}
