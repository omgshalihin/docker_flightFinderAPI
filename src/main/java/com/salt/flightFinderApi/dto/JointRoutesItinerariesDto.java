package com.salt.flightFinderApi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.salt.flightFinderApi.model.Price;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class JointRoutesItinerariesDto {

    private String flight_id;
    private Date flight_departureAt;
    private Date flight_arrivalAt;
    private int flight_availableSeats;
    private Price flight_prices;
    private String route_id;
    private String route_departureDestination;
    private String route_arrivalDestination;

    public JointRoutesItinerariesDto(String flight_id, Date flight_departureAt, Date flight_arrivalAt, int flight_availableSeats, Price flight_prices) {
        this.flight_id = flight_id;
        this.flight_departureAt = flight_departureAt;
        this.flight_arrivalAt = flight_arrivalAt;
        this.flight_availableSeats = flight_availableSeats;
        this.flight_prices = flight_prices;
    }
}
