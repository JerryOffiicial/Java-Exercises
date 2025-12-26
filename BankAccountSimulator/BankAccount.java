package BankAccountSimulator;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
	private String accountNumber;
	private Customer customer;
	private double balance;
	private double dailyLimit = 10000;

	private List<String> transactionHistory = new ArrayList<>();// to create a resizable list in memory we use the
																// arrayList to the list

	public BankAccount(String accountNumber, Customer customer) {
		this.accountNumber = accountNumber;
		this.customer = customer;
		this.balance = 0.0;
	}

	// Deposit method
	public void deposit(double amount) {
		if (amount <= 0) {
			System.out.println("Deposit amount must me be positive.");
			return;
		}
		balance += amount;
		transactionHistory.add("Deposited: " + amount);
		System.out.println("Deposit successful. ");
	}

	// Withdraw method
	public void withdraw(double amount) throws InsufficientFundsException{
		if(amount <= 0) {
			System.out.println("Withdrawal amount must be positive.");
			return;
		}
		
		if(amount > dailyLimit) {
			System.out.println("Daily withdrawal limit exceeded.");
			return;
		}
		
		if(amount> balance) {
			throw new InsufficientFundsException("Insufficient balance!");
		}
		
		balance -= amount;
		transactionHistory.add("Withdrawn: "+amount);
		System.out.println("Withdrawal successful.");
	}

	// Balance check
	public void checkBalance() {
		System.out.println("Current Balance: " + balance);
	}

	// Transaction History
	public void showTransactionHistory() {
		System.out.println("Transaction History:");
		for (String transaction : transactionHistory) {
			System.out.println(transaction);
		}
	}
}

//Encapsulation
//Validation
//Custom exception
//List usage
