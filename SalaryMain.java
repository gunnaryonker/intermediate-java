import java.text.DecimalFormat;
import java.util.*;

/*
 * Author: Gunnar Yonker
 * Date: 7/1/2022
 * File: SalaryMain.java
 * Description: A main method that has a salary array and asks for 8 salary inputs, applies a bonus if salary is within range
 */

public class SalaryMain {
	public static void main(String args[]) {
		Scanner myScanner = new Scanner(System.in);
		
		//Object array and variables
		final int SALARY_COUNT = 8;
		int salaryNum[] = new int[SALARY_COUNT];
		double bonus[] = new double[SALARY_COUNT];
		
		//Ask user to input salary, must be between 0 and 15000
		for(int i=0; i<salaryNum.length; i++)
		{
			while(true) {
			System.out.println("Input Salary " + (i+1)+":");
			salaryNum[i] = myScanner.nextInt();
				if(salaryNum[i] > 15000 || salaryNum[i] <0)
				{
					System.out.println("Invalid entry, please try again.");
				}
				else if(salaryNum[i] > 8000)
				{
					bonus[i] = ((salaryNum[i]*0.08));
					break;
				}
				else if((salaryNum[i] <= 8000))
				{
					bonus[i] = ((salaryNum[i]*0.12));
					break;
		
				}
			}

		}
		
		//Decimal Formatting
		DecimalFormat df = new DecimalFormat ("0.00");
		
		for(int i=0; i<salaryNum.length; i++)
		{
		System.out.println("Salary "+(i+1)+": $"+df.format(salaryNum[i]));
		System.out.println("Bonus "+(i+1)+": $"+df.format(bonus[i]));
		}
		
		//Find max bonus and print it out
		double max = bonus[0];
		for(int i=0; i<bonus.length; i++)
		{
			if(bonus[i] > max)
			{
				max = bonus[i];
			}
		}
		System.out.println("Highest Bonus Value: $"+df.format(max));
	}
}
