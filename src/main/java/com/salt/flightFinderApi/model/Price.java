package com.salt.flightFinderApi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Price {
    @JsonProperty("currency")
    @Column(name = "price_currency")
    private String price_currency;
    @JsonProperty("adult")
    @Column(name = "price_adult")
    private double price_adult;
    @JsonProperty("child")
    @Column(name = "price_child")
    private double price_child;

}
