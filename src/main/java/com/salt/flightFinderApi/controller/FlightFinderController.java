package com.salt.flightFinderApi.controller;

import com.salt.flightFinderApi.dto.JointRoutesItinerariesDto;
import com.salt.flightFinderApi.model.Itinerary;
import com.salt.flightFinderApi.model.Route;
import com.salt.flightFinderApi.repository.RouteRepository;
import com.salt.flightFinderApi.service.FlightFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightFinderController {

    @Autowired
    private RouteRepository routeRepository;
    private final FlightFinderService flightFinderService;

    public FlightFinderController(FlightFinderService flightFinderService) {
        this.flightFinderService = flightFinderService;
    }

    @GetMapping("/lists")
    public List<Route> getAllRoutes() {
        return flightFinderService.getAllRoutes();
    }

    @GetMapping("/flights")
    public List<JointRoutesItinerariesDto> getJointRoutesAndItineraries() {
        return flightFinderService.getJointRoutesAndItineraries();
    }

    //    http://localhost:8080/api/flights?departure=oslo&arrival=stockholm
    @GetMapping("/flights/{from}/{to}")
    public List<JointRoutesItinerariesDto> getAvailableFlightsBetween2Locations(
            @PathVariable(name = "from") String from,
            @PathVariable(name = "to") String to) {
        return flightFinderService.getAvailableFlightsBetween2Locations(from, to);
    }

//    http://localhost:8080/api/flights/oslo/stockholm/2023-03-28 22:00:00/2023-04-01 02:00:00
    @GetMapping("/flights/{from}/{to}/{departureTime}/{arrivalTime}")
    public List<JointRoutesItinerariesDto> getAvailableFlightsBetween2LocationsAndDepartureDateAndTime(
            @PathVariable(name = "from") String from,
            @PathVariable(name = "to") String to,
            @PathVariable(name = "departureTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date departureTime,
            @PathVariable(name = "arrivalTime") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date arrivalTime
    ) {
        return flightFinderService.getAvailableFlightsBetween2LocationsAndDepartureDateAndTime(from, to, departureTime, arrivalTime);
    }

    @PatchMapping("/bookings/{flightId}")
    public Itinerary bookFlight (
            @PathVariable(name = "flightId") String flightId,
            @RequestParam(name = "seats") String seats
            ) {
        return flightFinderService.bookFlight(flightId, seats);
    }


}
