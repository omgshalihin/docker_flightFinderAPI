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

        if (routeRepository.getAvailableFlightsBetween2Locations(from, to).size() == 0) {
            return routeRepository.getAvailableFlightsBetween2LocationsWithLayovers(from, to);

        } else {
            return routeRepository.getAvailableFlightsBetween2Locations(from, to);
        }
    }

    public List<JointRoutesItinerariesDto> getAvailableFlightsBetween2LocationsAndDepartureDateAndTime(String from, String to, Date departureTime, Date arrivalTime) {
        return routeRepository.getAvailableFlightsBetween2LocationsAndDepartureDateAndTime(from, to, departureTime, arrivalTime);
    }

    public Itinerary bookFlight(String flightId, String seats) {

        Itinerary itinerary = itineraryRepository.findById(flightId).get();

        if (itinerary.getFlight_availableSeats() < Integer.parseInt(seats)) {
            itinerary.setFlight_availableSeats(itinerary.getFlight_availableSeats());
            throw new IllegalArgumentException("Not enough seating");
        } else {
            itinerary.setFlight_availableSeats(itinerary.getFlight_availableSeats() - Integer.parseInt(seats));
        }
        return itineraryRepository.save(itinerary);


    }
}
