package MovieTicketBooking;

import java.util.ArrayList;

public class Movie {
	
	private int ID;
	private String Name;
	private String Language;
	private String Genre;
	private int RunningTime;
	private String Starring;
	private String Rating;
	private ArrayList<Show> shows;
	
	public Movie() {
		shows = new ArrayList<>();
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getLanguage() {
		return Language;
	}

	public void setLanguage(String language) {
		Language = language;
	}

	public String getGenre() {
		return Genre;
	}

	public void setGenre(String genre) {
		Genre = genre;
	}

	public int getRunningTime() {
		return RunningTime;
	}

	public void setRunningTime(int runningTime) {
		RunningTime = runningTime;
	}

	public String getStarring() {
		return Starring;
	}

	public void setStarring(String starring) {
		Starring = starring;
	}

	public String getRating() {
		return Rating;
	}

	public void setRating(String rating) {
		Rating = rating;
	}

	public ArrayList<Show> getShows() {
		return shows;
	}

	public void setShows(ArrayList<Show> shows) {
		this.shows = shows;
	}
	
	public void print() {
		System.out.println(ID+"\t");
		System.out.println(Name+"\t");
		System.out.println(Language+"\t\t");
		System.out.println(Genre+"\t");
		System.out.println(RunningTime+"Minutes\t");
		System.out.println(Starring+"\t\t");
		System.out.println(Rating+"\n");
	}
	
}
