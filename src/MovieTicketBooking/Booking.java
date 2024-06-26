package MovieTicketBooking;

public class Booking {
	
	private int ID;
	private int seats;
	private Movie movie;
	private Show show;
	
	public Booking() {}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}
	
	public void print() {
		System.out.println(ID+"\t");
		System.out.println(seats+"\t");
		System.out.println(movie.getName()+"\t");
		System.out.println(show.getDate()+"\t");
		System.out.println(show.getTime()+"\n");
	}
	
}
