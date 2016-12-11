package BankTransactionApplication;

import java.text.NumberFormat;

public class CheckingAccount extends Account {
	
	private static double fee;
	
	private boolean chargeFee;
	
	public CheckingAccount() {}
	
	//print fee in dollar format
	public void displayFee() {
		System.out.println(NumberFormat.getCurrencyInstance().format(fee));
	}
	
	//set fee as $1 
	private void setChargeFee() {
		chargeFee = true;
		fee = 1;
	}
	
	//charge fee only if money is withdrawn, not for unsuccessful transaction or zero withdrawal
	@Override
	public void withdraw(double amount) {
		if (balance - amount > 0) {
			if (amount > 0) {
				setChargeFee();
			}
		balance = balance-amount;
		} else if (balance - amount >= 0) { //indicate to customer to withdraw, leaving the service fee
			System.out.println("Service fee of $1.00 is applicable. Insufficient balance in the account to withdraw " + NumberFormat.getCurrencyInstance().format(amount));
		} else { 							//indicate to customer to withdraw amount left in the account
			System.out.println("Insufficient balance in the account to withdraw " + NumberFormat.getCurrencyInstance().format(amount));
		}
	}
	
	//charge fee if money is deposited
	@Override
	public void deposit(double amount) {
		if (amount > 0) {
			setChargeFee();
		}
		balance = balance + amount;
	}

	//charge fee
	@Override
	public void calculateFinalBalance() {
		if (chargeFee) {
			balance = balance - 1;
		}
	}
}