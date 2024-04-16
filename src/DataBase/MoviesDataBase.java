package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import MovieTicketBooking.Admin;
import MovieTicketBooking.Movie;

public class MoviesDataBase {

	public static void addNewMovie(Database database, Scanner sc, Admin admin) {
		
		System.out.println("Enter Movie Name: ");
		String name = sc.next();
		System.out.println("Enter Movie Language: ");
		String language = sc.next();
		System.out.println("Enter Movie Genre: ");
		String genre = sc.next();
		System.out.println("Enter Movie Running Time: ");
		int runningTime = sc.nextInt();
		System.out.println("Enter Movie Starring: ");
		String starring = sc.next();
		System.out.println("Enter Movie Rating: ");
		String rating = sc.next();
		int ID = getNextID(database);
		
		String insert = "INSERT INTO `movies`(`ID`, `Name`, `Language`, `Genre`, `Running Time`, `Starring`, `Rating`) VALUES ('"+ID+"','"+name+"',"
				+ "'"+language+"','"+genre+"','"+runningTime+"','"
						+ ""+starring+"','"+rating+"');";
		try {
			database.getStatement().execute(insert);
			System.out.println("Movie added sucessfully\n");
			admin.showList(database);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static ArrayList<Movie> getAllMovies(Database database) {
		ArrayList<Movie> movies = new ArrayList<>();
		String select = "SELECT * FROM `movies`;";
		try {
			ResultSet rs = database.getStatement().executeQuery(select);
			while (rs.next()) {
				Movie m = new Movie();
				m.setID(rs.getInt("ID"));
				m.setName(rs.getString("Name"));
				m.setLanguage(rs.getString("Language"));
				m.setGenre(rs.getString("Genre"));
				m.setRunningTime(rs.getInt("Running Time"));
				m.setStarring(rs.getString("Starring"));
				m.setRating(rs.getString("Rating"));
				movies.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return movies;
	}

	public static int getNextID(Database database) {
		int ID = 0;
		ArrayList<Movie> movies = getAllMovies(database);
		int size = movies.size();
		if (size != 0) {
			Movie lastMovie = movies.get(size - 1);
			ID = lastMovie.getID() + 1;
		}
		return ID;
	}

}