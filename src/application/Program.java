package application;

import java.util.Scanner;

public class Program {
	
	private static Scanner sc;

	public static void main(String[] args) {

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
	}

}
