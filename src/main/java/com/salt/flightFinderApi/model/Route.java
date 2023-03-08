package com.salt.flightFinderApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "routes")
public class Route {

    @Id
    @Column(name = "route_id")
    private String route_id;
    @JsonProperty("departureDestination")
    @Column(name = "route_departureDestination")
    private String route_departureDestination;
    @JsonProperty("arrivalDestination")
    @Column(name = "route_arrivalDestination")
    private String route_arrivalDestination;
    @JsonProperty("itineraries")
    @Column(name = "route_itineraries")
    @OneToMany(targetEntity = Itinerary.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "route_itinerary_fk", referencedColumnName = "route_id")
    private List<Itinerary> route_itineraries;

}


