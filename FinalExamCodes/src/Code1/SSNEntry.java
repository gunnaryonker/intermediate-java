package Code1;

import java.util.Scanner;

public class SSNEntry {
	public static void main(String args[]) {
		Scanner myScanner = new Scanner(System.in);
		String userssn = "";
		
		//Prompt user to enter SSN
		System.out.println("Enter your Social Security Number(Ex: 123-12-1234): ");
		userssn = myScanner.nextLine();
		
		//Check if user correctly entered their ssn
		//First remove any extra spaces in entry and replace with no space
		userssn = userssn.replaceAll("\\s", "");
		//Check if first 3 characters are digits, and make sure length is 11 after trimming
			if( (userssn.length() == 11) &&
			(Character.isDigit(userssn.charAt(0))) &&
			(Character.isDigit(userssn.charAt(1))) &&
			(Character.isDigit(userssn.charAt(2))) &&
			//Check that next character is a dash not another number
			(userssn.charAt(3) == '-') &&
			//Check next 2 character should be digits as well
			(Character.isDigit(userssn.charAt(4))) &&
			(Character.isDigit(userssn.charAt(5))) &&
			//Check for next dash
			(userssn.charAt(6) == '-') &&
			(Character.isDigit(userssn.charAt(7))) &&
			(Character.isDigit(userssn.charAt(8))) &&
			(Character.isDigit(userssn.charAt(9))) &&
			(Character.isDigit(userssn.charAt(10)))) {
				//Print out that the ssn is a valid entry
				System.out.println(userssn + " is a valid SSN.");
			}
			else {
				//Print out that the ssn is a invalid entry
				System.out.println(userssn + " is an invalid SSN.");
			}
	}
}
