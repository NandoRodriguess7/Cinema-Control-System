package MovieTicketBooking;

import java.util.ArrayList;
import java.util.Scanner;

import DataBase.Database;
import DataBase.MoviesDataBase;

public class Visitor extends User {

	private ArrayList<Booking> bookings;

	public Visitor() {
		super();
	}

	public ArrayList<Booking> getBooking() {
		return bookings;
	}

	public void setBookings(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public void showList(Database database) {
		System.out.println("1. View Movies");
		System.out.println("2. View Movie Show Time");
		System.out.println("3. Book Tickets");
		System.out.println("4. Cancel Tickets");
		System.out.println("5. Quit");
		
		Scanner s = new Scanner(System.in);
		int i = s.nextInt();
		switch (i) {
			case 1:
				MoviesDataBase.showMovies(database);
				break;
			case 2:
				MoviesDataBase.showShowTimes(database, s);
				break;
		}
		
	}

}