package java_exercises;

import java.util.Scanner;

class Account {
	String name;
	double balance;

	Account(String name, double balance) {
		this.name = name;
		this.balance = balance;
	}

	void deposit(double amount) {
		balance += amount;
		System.out.println("LKR " + amount + " deposited successfully");
	}

	void withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Insufficient balance!");
		}else {
			balance -= amount;
			System.out.println("Withrawal successful, please take your cash.");
		}
	}

	void balanceCheck() {
		System.out.println("Your current balance is: " + balance);
	}
}

//---------Saving Account-------------
class SavingAccount extends Account {
	double interestRate = 0.02;

	SavingAccount(String name, double balance) {
		super(name, balance);
	}

	void addInterest() {
		double interest = balance * interestRate;
		balance += interest;
		System.out.println("Interest added: " + interest);
	}
}

//---------Current Account-----------
class CurrentAccount extends Account {
	double overdraftLimit = 500;

	CurrentAccount(String name, double balance) {
		super(name, balance);
	}

	void withdraw(double amount) {
		if (amount > balance + overdraftLimit) {
			System.out.println("Overdraft limit exceeded!");
		} else {
			balance -= amount;
			System.out.println("Withdrawn using overdraft feature: " + amount);
		}
	}

}

public class BankAccountSimulator {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("Choose account type: ");
		System.out.println("1. Saving Account");
		System.out.println("2. Current Account");
		int type = scan.nextInt();
		scan.nextLine();

		System.out.println("\nAccount Create");
		System.out.println("Enter your name: ");
		String name = scan.nextLine();

		System.out.println("Enter initial balance: ");
		double balance = scan.nextDouble();

		Account account;

		if (type == 1) {
			account = new SavingAccount(name, balance);
		} else {
			account = new CurrentAccount(name, balance);
		}

		while (true) {
			System.out.println("\n--- Menu ---");
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Show Balance");
			if (account instanceof SavingAccount) {
				System.out.println("4. Add Interest");
				System.out.println("5. Exit");
			} else {
				System.out.println("4. Exit");
			}

			System.out.println("Choose: ");
			int choice = scan.nextInt();

			if (account instanceof SavingAccount) {
				switch (choice) {
				case 1:
					System.out.println("Enter the Amount: ");
					double dAmount = scan.nextDouble();
					account.deposit(dAmount); // account.deposit(scan.nextDouble());
					break;
				case 2:
					System.out.println("Enter the Amount: ");
					double wAmount = scan.nextDouble();
					account.withdraw(wAmount);
					break;
				case 3:
					account.balanceCheck();
					break;
				case 4:
					((SavingAccount) account).addInterest();
					break;
				case 5:
					System.out.println("Exiting...");
					System.out.println("Program ended.");
					return;
				default:
					System.out.println("Invalid choice!");
					break;
				}

			} else {
				switch (choice) {
				case 1:
					System.out.println("Enter the amount: ");
					account.deposit(scan.nextDouble());//account.deposit(dAmount);
					break;
				case 2:
					System.out.println("Enter the amount");
					account.withdraw(scan.nextDouble());
					break;
				case 3:
					account.balanceCheck();
					break;
				case 4:
					System.out.println("Exiting...");
					System.out.println("Program ended.");
					return;
				default:
					System.out.println("Invalid choice!");
					break;
				}
			}
		}

	}
}
