package com.salt.flightFinderApi.service;

import com.salt.flightFinderApi.model.Route;
import com.salt.flightFinderApi.repository.RouteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightFinderService {

    private final RouteRepository routeRepository;

    public FlightFinderService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    public void save(List<Route> routes) {
        routeRepository.saveAll(routes);
    }

}
