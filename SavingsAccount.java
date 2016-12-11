package BankTransactionApplication;

import java.text.NumberFormat;
//SavingsAccount is a 
public class SavingsAccount extends Account {
	//monthly interest
	private static final double interest = 0.01;
	
	public SavingsAccount() {}
	
	//prints interest amount in dollar format
	public void displayInterestAmount() {
		System.out.println(NumberFormat.getCurrencyInstance().format(balance * interest));
	}
	
	//calculate balance after adding interest 
	@Override
	public void calculateFinalBalance() {
		balance = balance + balance * interest;
		
	}

}