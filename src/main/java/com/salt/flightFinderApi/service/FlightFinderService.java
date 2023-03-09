package com.salt.flightFinderApi.service;

import com.salt.flightFinderApi.dto.JointRoutesItinerariesDto;
import com.salt.flightFinderApi.model.Itinerary;
import com.salt.flightFinderApi.model.Route;
import com.salt.flightFinderApi.repository.ItineraryRepository;
import com.salt.flightFinderApi.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FlightFinderService {

    private final RouteRepository routeRepository;
    private final ItineraryRepository itineraryRepository;

    public FlightFinderService(RouteRepository routeRepository, ItineraryRepository itineraryRepository) {
        this.routeRepository = routeRepository;
        this.itineraryRepository = itineraryRepository;
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public void save(List<Route> routes) {
        routeRepository.saveAll(routes);
    }

    public List<JointRoutesItinerariesDto> getJointRoutesAndItineraries() {
        return routeRepository.getJointRoutesAndItineraries();
    }


    public List<JointRoutesItinerariesDto> getAvailableFlightsBetween2Locations(String from, String to) {
        return routeRepository.getAvailableFlightsBetween2Locations(from, to);
    }

//    public List<JointRoutesItinerariesDto> getAvailableFlightsBetween2LocationsAndDepartureDate(String from, String to, String depart) {
//        return routeRepository.getAvailableFlightsBetween2LocationsAndDepartureDate(from, to, depart);
//    }

    public List<JointRoutesItinerariesDto> getAvailableFlightsBetween2LocationsAndDepartureDateAndTime(String from, String to, Date departureTime, Date arrivalTime) {
        return routeRepository.getAvailableFlightsBetween2LocationsAndDepartureDateAndTime(from, to, departureTime, arrivalTime);
    }
}
