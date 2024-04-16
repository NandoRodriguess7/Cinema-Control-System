package MovieTicketBooking;

import java.util.Scanner;

import DataBase.Database;
import DataBase.MoviesDataBase;
import DataBase.UsersDatabase;

public class Admin extends User {
	
	private Scanner scanner;
	
	public Admin() {
		super();
		scanner = new Scanner(System.in);
	}

	@Override
	public void showList(Database database) {
		System.out.println("1. Add New Movie");
		System.out.println("2. Update Movie");
		System.out.println("3. Show Movies");
		System.out.println("4. Delete Movie");
		System.out.println("5. Add Show Time");
		System.out.println("6. Update Show Time");
		System.out.println("7. Show Show Times");
		System.out.println("8. Delete Show Time");
		System.out.println("9. Add New Admin");
		System.out.println("10. Quit");
		int i = scanner.nextInt();
		switch(i) {
		case 1:
			MoviesDataBase.addNewMovie(database, scanner, this);
			break;
			case 9:
				createNewAccount(database);
				break;
		}
	}
	
	private void createNewAccount(Database database) {
		System.out.println("Enter your first name: ");
		String firstName = scanner.next();
		System.out.println("Enter your last name: ");
		String lastName = scanner.next();
		System.out.println("Enter your email: ");
		String email = scanner.next();
		System.out.println("Enter your phone number: ");
		String phoneNumber = scanner.next();
		System.out.println("Enter your password: ");
		String password = scanner.next();
		System.out.println("Confirm password: ");
		String confirmPassword = scanner.next();
		while (!password.equals(confirmPassword)) {
			System.out.println("Enter your password: ");
			password = scanner.next();
			System.out.println("Confirm password: ");
			confirmPassword = scanner.next();
		}
		while (UsersDatabase.isEmailUsed(email, database)) {
			System.out.println("This email is already used!");
			System.out.println("Enter your email: ");
			email = scanner.next();
		}
		Admin admin = new Admin();
		admin.setID(UsersDatabase.getNextAdminID(database));
		admin.setFirstName(firstName);
		admin.setLastName(lastName);
		admin.setEmail(email);
		admin.setPhoneNumber(phoneNumber);
		admin.setPassword(password);
		UsersDatabase.addAdmin(admin, database);
		showList(database);
	}
	
}