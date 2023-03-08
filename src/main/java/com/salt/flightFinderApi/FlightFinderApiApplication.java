package com.salt.flightFinderApi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salt.flightFinderApi.model.Route;
import com.salt.flightFinderApi.service.FlightFinderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class FlightFinderApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightFinderApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(FlightFinderService flightFinderService) {
		return args -> {
			// read json and write to db
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<List<Route>> typeReference = new TypeReference<>(){};
			InputStream inputStream = TypeReference.class.getResourceAsStream("/json/data.json");
			try {
				List<Route> routes = mapper.readValue(inputStream,typeReference);
				flightFinderService.save(routes);
				System.out.println("Routes Saved!");
			} catch (IOException e){
				System.out.println("Unable to save routes: " + e.getMessage());
			}
		};
	}

}
