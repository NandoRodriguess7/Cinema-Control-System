package DataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import MovieTicketBooking.User;
import MovieTicketBooking.Visitor;

public class UsersDatabase {

	public static boolean isEmailUsed(String email, Database database) {
		boolean isUsed = false;
		try {
			ResultSet rs = database.getStatement()
					.executeQuery("SELECT `ID`, `firstName`, " + "`lastName`, `email`, `phoneNumber`, `password` "
							+ "FROM `visitors` WHERE `email` = '" + email + "';");
			isUsed = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isUsed;
	}

	public static ArrayList<Visitor> getAllVisitors(Database database) {
		ArrayList<Visitor> visitors = new ArrayList<>();
		try {
			ResultSet rs = database.getStatement().executeQuery("SELECT * FROM `visitors`;");
			while (rs.next()) {
				Visitor visitor = new Visitor();
				visitor.setID(rs.getInt("ID"));
				visitor.setFirstName(rs.getString("firstName"));
				visitor.setLastName(rs.getString("firstName"));
				visitor.setEmail(rs.getString("email"));
				visitor.setPhoneNumber(rs.getString("phoneNumber"));
				visitor.setPassword(rs.getString("password"));
				visitors.add(visitor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visitors;
	}

	public static int getNextVisitorID(Database database) {
		int ID = 0;
		ArrayList<Visitor> visitors = getAllVisitors(database);
		if (visitors.size() != 0) {
			int lastRow = visitors.size() - 1;
			Visitor lastVisitor = visitors.get(lastRow);
			ID = lastVisitor.getID() + 1;
		}
		return ID;
	}

	public static void addVisitor(Visitor v, Database database) {
		String insert = "INSERT INTO `visitors`(`ID`, `firstName`, `lastName`, `email`,"
				+ " `phoneNumber`, `password`) VALUES ('" + v.getID() + "','" + v.getFirstName() + ",'"
				+ v.getLastName() + "','" + v.getEmail() + "','" + v.getPhoneNumber() + "','" + v.getPassword() + "')";
		try {
			database.getStatement().execute(insert);
			System.out.println("User created successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static boolean login(String email, String password, Database database) {
		boolean login = false;
			ArrayList<User> users = new ArrayList<>();
			users.addAll(getAllVisitors(database));
			for (User u : users) {
				if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
					login = true;
					break;
				}
			}
		return login;
	}

	public static Visitor login(String email, Database database) {
		Visitor visitor = new Visitor();
		try {
			ResultSet rs = database.getStatement()
					.executeQuery("SELECT `ID`, `firstName`, " + "`lastName`, `email`, `phoneNumber`, `password` "
							+ "FROM `visitors` WHERE `email` = '" + email + "';");
			while (rs.next()) {
				if (rs.getString("email").equals(email)) {
					visitor.setID(rs.getInt("ID"));
					visitor.setFirstName(rs.getString("firstName"));
					visitor.setLastName(rs.getString("firstName"));
					visitor.setEmail(rs.getString("email"));
					visitor.setPhoneNumber(rs.getString("phoneNumber"));
					visitor.setPassword(rs.getString("password"));
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visitor;
	}

	public static User getUser(String email, String password, Database database) {
		ArrayList<User> users = new ArrayList<>();
		users.addAll(getAllVisitors(database));
		User user = new Visitor();
		for (User u : users) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				user = u;
				break;
			}
		}
		return user;
	}

}
