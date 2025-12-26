package BankAccountSimulator;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Enter customer name: ");
		String name = scan.nextLine();

		Customer customer = new Customer(name);
		BankAccount account = new BankAccount("ACC123", customer);

		try {
			account.deposit(5000);
			account.withdraw(2000);
			account.checkBalance();
			account.withdraw(10000); // will throw exception
		} catch (InsufficientFundsException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
		account.showTransactionHistory();
		scan.close();
	}

}
