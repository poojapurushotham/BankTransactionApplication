package BankTransactionApplication;

import java.util.Scanner;

//class to validate the data entered by user
public class DataValidator {

	//validates double data
	public static double getDouble(Scanner sc, String prompt) {
        double d = 0.0;
        boolean isValid = false;
        while (isValid == false) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                if (d >= 0) {
                	isValid = true;
                } else {
                	System.out.println("Error! Enter positive value. Try again.");
                }
            } else {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }
	
	//validates String data for entered choices
	public static String getUserChoice(Scanner sc, String prompt, String choice1, String choice2) {
		String ch = null;
		boolean isValid = false;
		while (isValid == false) {
			System.out.print(prompt);
			if (sc.hasNext(choice1.toLowerCase()) || sc.hasNext(choice2.toLowerCase()) || sc.hasNext(choice1.toUpperCase()) || sc.hasNext(choice2.toUpperCase())) {
				ch = sc.next();
				isValid = true;
			} else {
				System.out.println("Error! Invalid choice. Try again with '" + choice1 + "' or '" + choice2 + "'");
			}
			sc.nextLine();
		}
		return ch;
	}	
}