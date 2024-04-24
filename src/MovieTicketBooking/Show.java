package MovieTicketBooking;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Show {
	
	private int ID;
	private LocalDateTime showTime;
	private int capacity;
	private int availableSeats;
	private String place;
	
	public Show() {}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getDate() {
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		return showTime.format(dateFormatter);
	}
	
	public String getTime() {
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
		return showTime.format(timeFormatter);
	}
	
	public void print() {
		System.out.println(ID+"\t");
		System.out.println(getDate()+"\t");
		System.out.println(getTime()+"\t");
		System.out.println(capacity+"\t");
		System.out.println(availableSeats+"\t\t");
		System.out.println(place+"\n");
	}
	
}
