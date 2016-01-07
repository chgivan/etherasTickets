package gr.etherasTickets.flight;

import java.util.List;

public interface CustomFlightRepository {
	public List<Flight> searchFlights(String searchText);
}
