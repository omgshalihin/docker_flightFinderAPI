package com.salt.flightFinderApi.repository;

import com.salt.flightFinderApi.dto.JointRoutesItinerariesDto;
import com.salt.flightFinderApi.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RouteRepository extends JpaRepository<Route, String> {

    @Query("SELECT new com.salt.flightFinderApi.dto.JointRoutesItinerariesDto(i.flight_id, i.flight_departureAt, i.flight_arrivalAt, i.flight_availableSeats, i.flight_prices, r.route_id, r.route_departureDestination, r.route_arrivalDestination) FROM Route r JOIN r.route_itineraries i")
    List<JointRoutesItinerariesDto> getJointRoutesAndItineraries();

    @Query("SELECT new com.salt.flightFinderApi.dto.JointRoutesItinerariesDto(i.flight_id, i.flight_departureAt, i.flight_arrivalAt, i.flight_availableSeats, i.flight_prices) FROM Route r JOIN r.route_itineraries i WHERE r.route_departureDestination ilike :from and r.route_arrivalDestination ilike :to")
    List<JointRoutesItinerariesDto> getAvailableFlightsBetween2Locations(@Param("from") String from, @Param("to") String to);

    @Query("SELECT new com.salt.flightFinderApi.dto.JointRoutesItinerariesDto(i.flight_id, i.flight_departureAt, i.flight_arrivalAt, i.flight_availableSeats, i.flight_prices) FROM Route r JOIN r.route_itineraries i WHERE r.route_departureDestination ilike :from AND r.route_arrivalDestination ilike :to AND i.flight_departureAt >= :departureTime AND i.flight_arrivalAt <= :arrivalTime")
    List<JointRoutesItinerariesDto> getAvailableFlightsBetween2LocationsAndDepartureDateAndTime(
            @Param("from") String from,
            @Param("to") String to,
            @Param("departureTime") Date departureTime,
            @Param("arrivalTime") Date arrivalTime);
}

