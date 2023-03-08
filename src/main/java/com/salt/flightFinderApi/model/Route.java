package com.salt.flightFinderApi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Route {

    @Id
    private String routeId;
    private String routeDepartureDestination;
    private String routeArrivalDestination;
    @OneToMany(targetEntity = Flight.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "route_flight_fk", referencedColumnName = "routeId")
    private List<Flight> flights;


}
