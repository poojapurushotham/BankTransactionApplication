package BankTransactionApplication;

import java.text.NumberFormat;

//Account class is a base class with 2 sub classes - Checking and Savings
public abstract class Account {
	
	protected double balance;
	final double initialBalance = 1000;
	//constructor
	public Account() {
		this.balance = initialBalance;
	}
	
	//prints balance in dollar format
	public void displayBalance() {
		System.out.println(NumberFormat.getCurrencyInstance().format(balance));
	}
	
	//adds to balance
	public void deposit(double amount) {
		balance = balance + amount;
	}
	
	//subtracts from balance
	public void withdraw(double amount) {
		if (balance - amount >= 0) {
			balance = balance - amount;
		} else {
			System.out.println("Insufficient balance in the account to withdraw " + NumberFormat.getCurrencyInstance().format(amount));
		}		
	}
	
	//calculate final balance after transaction for month
	public abstract void calculateFinalBalance();
	
}
