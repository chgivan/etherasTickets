package gr.etherasTickets.flight;

import org.springframework.data.annotation.Id;

public class Flight {
	@Id
	private String id;
	
	private String to;

	
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}
}
