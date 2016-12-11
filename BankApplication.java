package BankTransactionApplication;

import java.util.Scanner;

//main app class to run for account application
public class BankApplication {
	public static void main(String[] args) {
		
		String transaction, accountType, choice = "y";
		double amount;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Welcome to the Account application\n");
		
		//creating instances of checking and savings account with default constructor that assigns initial balance of $1000
		CheckingAccount CheckingAcc = new CheckingAccount();
		SavingsAccount SavingsAcc = new SavingsAccount();
		System.out.print("Starting Balances\nChecking : ");
		CheckingAcc.displayBalance();
		System.out.print("Savings  : ");
		SavingsAcc.displayBalance();
		System.out.println("\nEnter the transactions for the month");
		
		while (choice.equalsIgnoreCase("y")) {
			
			//Validating the user entered data
			transaction = DataValidator.getUserChoice(sc, "\nWithdrawal or deposit? (w/d): ", "w" , "d");
			accountType = DataValidator.getUserChoice(sc, "Checking or savings? (c/s): ", "c" , "s");
			amount = DataValidator.getDouble(sc, "Amount? : ");
			
			//checking for only c/s and w/d user entries, since the other cases are handled in DataValidator 
			if (accountType.equalsIgnoreCase("c")) {
				if (transaction.equalsIgnoreCase("w")) {
					CheckingAcc.withdraw(amount);
				} else {
					CheckingAcc.deposit(amount);
				}
			} else {
				if (transaction.equalsIgnoreCase("w")) {
					SavingsAcc.withdraw(amount);
				} else {
					SavingsAcc.deposit(amount);
				}
			}
			choice = DataValidator.getUserChoice(sc, "\nContinue? (y/n) : ", "y" , "n");
		}
		
		System.out.print("\n\nMonthly Payments and Fees\nChecking fee: ");
		CheckingAcc.displayFee();
		System.out.print("Savings interest payment: ");
		SavingsAcc.displayInterestAmount();
		
		System.out.print("\nFinal Balances\nChecking: ");
		CheckingAcc.calculateFinalBalance();
		CheckingAcc.displayBalance();
		System.out.print("Savings:  ");
		SavingsAcc.calculateFinalBalance();
		SavingsAcc.displayBalance();		
		sc.close();
	}	
}