package com.salt.flightFinderApi.controller;

import com.salt.flightFinderApi.model.Route;
import com.salt.flightFinderApi.service.FlightFinderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightFinderController {
    private final FlightFinderService flightFinderService;

    public FlightFinderController(FlightFinderService flightFinderService) {
        this.flightFinderService = flightFinderService;
    }
    @GetMapping("/routes")
    public List<Route> getAllRoutes() {
        return flightFinderService.getAllRoutes();
    }
}
