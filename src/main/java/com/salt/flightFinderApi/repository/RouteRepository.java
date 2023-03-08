package com.salt.flightFinderApi.repository;

import com.salt.flightFinderApi.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, String> {
}
