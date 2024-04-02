package MovieTicketBooking;

import java.util.ArrayList;

public class Visitor extends User {
	
	private ArrayList<Booking> bookings;
	
	public Visitor() {
		super();
	}
	
	public ArrayList<Booking> getBooking(){
		return bookings;
	}
	
	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public void showList() {
		System.out.println("1. View Movies");
		System.out.println("2. Book Tickets");
		System.out.println("3. Cancel Tickets");
		System.out.println("4. Quit");
	}
	
}