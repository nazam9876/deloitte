package com.del.client;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.del.exception.PaymentException;
import com.del.service.PaymentService;
import com.del.service.PaymentServiceImplementation;

public class PaymentClient {

	private PaymentService pService;

	public PaymentClient() {

		pService = new PaymentServiceImplementation();

		Scanner scan = new Scanner(System.in);
		int choice = 0;
		System.out.println("Welcome to Payment System\n");
		System.out.println("Enter login(Mobile number)");
		String login = scan.nextLine();
		//String login="9843981033";
		System.out.println("\nEnter password");
		String password = scan.nextLine();
		//String password="LiteYaga";
		boolean loginSuccess = pService.authenticate(login, password);

		if (loginSuccess) {

			System.out.println("\nWelcome user: " + login);
			double bal = pService.getBalance();
			if (bal < 0) {
				System.out.println("Your Pending Amount is: Rs " + -bal);
			} else {
				System.out.println("Your Balance Credit is: Rs " + bal);
			}

			while (true) {
				choice = getChoice(scan);
				switch (choice) {

				case 1:
					System.out.print("Enter the amount you want to pay : ");
					double amount = 0;
					try {
						amount = scan.nextDouble();
						pService.payAmount(amount);
						System.out.println("\nPayment of Rs " + amount + " Made");
					} catch (PaymentException ee) {
						System.out.println(ee.getMessage());
					} catch (InputMismatchException e2) {
						System.out.println("\n******Enter numbers only******");
						scan.nextLine();// consume the keyboard input
					}

				case 2:
					System.out.println("\nChecking Pending amount...");
					double balance = pService.getBalance();
					if (balance < 0) {
						System.out.println("\nUser : " + login + "\nYour Pending Amount is : Rs " + -balance + " debit");
					} else {
						System.out.println("\nUser :" + login + "\nYour Balance is : Rs " + balance + " credit");
					}
					break;

				case 3:
					System.out.println("Exiting the Program");
					scan.close();
					System.exit(0);
					break;

				default:
					System.out.println("******Please Select a Correct choice******");
					break;

				}
			}
		}else {
			System.out.println("\n****Wrong Username Password Combination****");
		}

		scan.close();

	}

	private int getChoice(Scanner scan) {

		int choice = 0;
		System.out.println("\n---------MOBILE PAYMENT SYSTEM---------");
		System.out.println("1. Pay Amount");
		System.out.println("2. Check Pending Amount");
		System.out.println("3. Exit");
		System.out.print("\nEnter Choice: ");
		try {
			choice = scan.nextInt();
			
			
		} catch (InputMismatchException e1) {
			System.out.println("******Input is not a number******");
			scan.nextLine();

		}

		return choice;

	}

	public static void main(String[] args) {

		new PaymentClient();
	}

}
