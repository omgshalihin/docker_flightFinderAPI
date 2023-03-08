package com.salt.flightFinderApi.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Price {
    private String priceCurrency;
    private double priceAdult;
    private double priceChild;

}
