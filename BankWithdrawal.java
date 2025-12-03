package java_exercises;

import java.util.Scanner;

class InsufficientBalanceException extends Exception {
	InsufficientBalanceException(String message) {
		super(message);
	}
}

class BankAccount {
	double balance;

	BankAccount(double balance) {
		this.balance = balance;
	}

	void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > balance) {
			throw new InsufficientBalanceException("withdrawal failed! Balance is too low.");
		}
		balance -= amount;
		System.out.println("LKR." + amount + " Withdrawal successful! Remaining balance: " + balance);
	}
}

public class BankWithdrawal {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the Withdrawal Amount:");
		double amount = scan.nextInt();

		BankAccount ba = new BankAccount(3500);

		try {
			ba.withdraw(amount);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}

		System.out.println("Program ended!");

	}

}
