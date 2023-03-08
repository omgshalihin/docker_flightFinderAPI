-- (required) Choosing two locations and getting all available flights between these locations
select * from itineraries
inner join routes on routes.route_id = itineraries.route_itinerary_fk
where route_departure_destination ilike 'oslo' and route_arrival_destination ilike 'stockholm';

-- (required) Choosing flights depending on given times

-- (required) User should be able to book a flight
-- (required) Error checking for invalid bookings (Not enough seating, etc)
-- (required) Have flights with layovers. You should then connect existing flights with each other,
-- if a direct flight doesn't exist. For example; someone searches for Stockholm to Amsterdam.
-- You don’t have any direct flight in your db for this, but you do have flights for Stockholm -> Oslo and Oslo -> Amsterdam.
-- Then combine these two and present them as one flight, showing time for each flight and wait time between flights.