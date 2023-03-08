package com.salt.flightFinderApi.repository;

import com.salt.flightFinderApi.model.Itinerary;
import org.springframework.data.repository.CrudRepository;

public interface ItineraryRepository extends CrudRepository<Itinerary, String> {
}
