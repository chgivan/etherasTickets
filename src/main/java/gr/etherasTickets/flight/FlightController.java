package gr.etherasTickets.flight;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


@RestController
@RequestMapping("/flights")
public class FlightController {
	
	@Autowired
	private FlightRepository repository;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Flight>> getFlights(
			@RequestParam(name="to" , required=false) String searchquery,
			@RequestParam(name="limit" , required=false , defaultValue="20") int limit,
			@RequestParam(name="offset" , required=false , defaultValue="0") int offset
	){
		return  new ResponseEntity(repository.searchFlights(searchquery), HttpStatus.OK);
	}
	
	
	private String createSearchQuery(String query){
		return String.format("{'to':'%s'}", query);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Flight> createFlight(@RequestParam(name="to" , required=false , defaultValue="N/A") String to){
		Flight f = new Flight();
		f.setTo(to);
		f = repository.save(f);
		return new ResponseEntity(f, HttpStatus.OK);
	}
	
	
}
