package application;

import java.util.Scanner;

import DataBase.Database;
import DataBase.UsersDatabase;
import MovieTicketBooking.User;
import MovieTicketBooking.Visitor;

public class Program {
	
	private static Scanner sc;
	private static Database dataBase;

	public static void main(String[] args) {
		
		dataBase = new Database();
		System.out.println("Welcome to Cinema Control System");
		System.out.println("1. Login");
		System.out.println("2. Create new account");
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		switch (i) {
		case 1:
			login();
			break;
		case 2:
			createNewAccount();
			break;
		default:
			System.out.println("Unvalid input!");
			break;
		}
	}

	private static void login() {
		System.out.println("Enter your email: ");
		String email = sc.next();
		System.out.println("Enter your password: ");
		String password = sc.next();
		if (UsersDatabase.login(email, password, dataBase)) {
			User user = UsersDatabase.getUser(email, password, dataBase);
			System.out.println("\nWelcome " + user.getFirstName()+" "+user.getLastName());
			user.showList(dataBase);
		}
		else {
			System.out.println("Incorrect email or password");
			login();
		}
	}

	private static void createNewAccount() {
		System.out.println("Enter your first name: ");
		String firstName = sc.next();
		System.out.println("Enter your last name: ");
		String lastName = sc.next();
		System.out.println("Enter your email: ");
		String email = sc.next();
		System.out.println("Enter your phone number: ");
		String phoneNumber = sc.next();
		System.out.println("Enter your password: ");
		String password = sc.next();
		System.out.println("Confirm password: ");
		String confirmPassword = sc.next();
		while (!password.equals(confirmPassword)) {
			System.out.println("Enter your password: ");
			password = sc.next();
			System.out.println("Confirm password: ");
			confirmPassword = sc.next();
		}
		while (UsersDatabase.isEmailUsed(email, dataBase)) {
			System.out.println("This email is already used!");
			System.out.println("Enter your email: ");
			email = sc.next();
		}
		Visitor visitor = new Visitor();
		visitor.setID(UsersDatabase.getNextVisitorID(dataBase));
		visitor.setFirstName(firstName);
		visitor.setLastName(lastName);
		visitor.setEmail(email);
		visitor.setPhoneNumber(phoneNumber);
		visitor.setPassword(password);
		UsersDatabase.addVisitor(visitor, dataBase);
		visitor.showList(dataBase);
	}

}
