import java.time.LocalDate;
import java.time.Period;

/*
 * Author: Gunnar Yonker
 * Date: 7/1/2022
 * File: Date.java
 * Description: A class that contains month, day, and year information. Also contains a displayDate and calculateAge function
 */
public class Date {
	private int birthMonth;
	private int birthDay;
	private int birthYear;
	private int futureMonth;
	private int futureDay;
	private int futureYear;
	public Date(int bMonth, int bDay, int bYear, int fMonth, int fDay, int fYear)
	{
		setMonth(bMonth);
		setDay(bDay);
		setYear(bYear);
		setFuturem(fMonth);
		setFutured(fDay);
		setFuturey(fYear);
	}
	
	//Define the methods
	//Make sure month is between 1 and 12, if not set to 1
	public int getMonth()
	{
		return birthMonth;
	}
	public void setMonth(int newMonth)
	{
		if(newMonth >= 1 && newMonth <= 12)
		{
			this.birthMonth = newMonth;
		}
		else
		{
			System.out.println("Invalid Month Input, Month Set to 1");
			this.birthMonth = 1;
		}
	}
	//Assume that day and year are entered correctly
	public void setDay(int newDay)
	{
		this.birthDay = newDay;
	}
	public int getDay()
	{
		return birthDay;
	}
	public void setYear(int newYear)
	{
		this.birthYear = newYear;
	}
	public int getYear()
	{
		return birthYear;
	}
	
	//Define methods of future date
	//Make sure month is between 1 and 12, if not set to 1
		public int getFuturem()
		{
			return futureMonth;
		}
		public void setFuturem(int monthf)
		{
			if(monthf >= 1 && monthf <= 12)
			{
				this.futureMonth = monthf;
			}
			else
			{
				System.out.println("Invalid Month Input, Month Set to 1");
				this.futureMonth = 1;
			}
		}
		//Assume that day and year are entered correctly
		public void setFutured(int dayf)
		{
			this.futureDay = dayf;
		}
		public int getFutured()
		{
			return futureDay;
		}
		public void setFuturey(int yearf)
		{
			this.futureYear = yearf;
		}
		public int getFuturey()
		{
			return futureYear;
		}
		
	
	//Create a function to displayDate, that displays like this month/day/year
	public void displayDate()
	{
		System.out.println(getMonth()+"/"+getDay()+"/"+getYear());
	}
	
	//Create a function to calculateAge with three parameters that indicate a future date, month day year
	//calculate ones age based on birthdate and also on future date
	
	public void calculateAge()
	{
		//Calculate current age based off of birthday
		//Declare the birthday entered
		LocalDate birthday = LocalDate.of(birthYear, birthMonth, birthDay);
		
		//Obtain the current date
		LocalDate currentDate = LocalDate.now();
		
		//Obtain the difference between the two dates
		Period difference = Period.between(birthday, currentDate);
		
		//Print out the age in years and days, no months
		System.out.printf("%d years %d months %d days old.", difference.getYears(), difference.getMonths(), difference.getDays());
	}
	
	public void displayFutureDate()
	{
		System.out.println(getFuturem()+"/"+getFutured()+"/"+getFuturey());
	}
	
	//I couldn't figure out a way to get future age in the same function and was running out of time, so I tried this as a fix with a new function for both display and calc
	public void calculateFutureAge()
	{
		//Calculate current age based off of birthday
		//Declare the birthday entered
		LocalDate birthday = LocalDate.of(birthYear, birthMonth, birthDay);
		
		//Obtain the current date
		LocalDate futureDate = LocalDate.of(futureYear, futureMonth, futureDay);
		
		//Obtain the difference between the two dates
		Period difference = Period.between(birthday, futureDate);
		
		//Print out the age in years and days, no months
		System.out.printf("%d years %d months %d days old.", difference.getYears(), difference.getMonths(), difference.getDays());
	}
}




import java.util.Scanner;

/*
 * Author: Gunnar Yonker
 * Date: 7/1/2022
 * File: AgeCalculation.java
 * Description: A main method that asks for users input of month, day, and year of one's birth date
 * then asks for a future date input and tells how many years old and days old they will be
 */
public class AgeCalculation {
	public static void main(String args[]) {
		Scanner myScanner = new Scanner(System.in);
				
		//initialize each object variable
		int bMonth = 0;
		int bDay = 0;
		int bYear = 0;
		int fMonth =1; int fDay =0; int fYear =0;
		
		//Ask for input of each variable
		System.out.println("Birthday Month(1-12): ");
		bMonth = myScanner.nextInt();
		System.out.println("Birthday Day(1-31): ");
		bDay = myScanner.nextInt();
		System.out.println("Birthday Year: ");
		bYear = myScanner.nextInt();
		
		//Create object using the input values
		Date birthday1 = new Date(bMonth, bDay, bYear, fMonth, fDay, fYear);
		
		//Call the displayDate function to show the information in the correct format
		System.out.println("");
		System.out.print("Your birthday is: ");
		birthday1.displayDate();

		//Ask for a future date and calculate current age and age on that future date
		System.out.println("Input a future month(1-12): ");
		fMonth = myScanner.nextInt();
		System.out.println("Input a future day(1-31): ");
		fDay = myScanner.nextInt();
		System.out.println("Input a future year: ");
		fYear = myScanner.nextInt();
		
		//Create object of future date input
		Date futureage1 = new Date(bMonth, bDay, bYear, fMonth, fDay, fYear);
		
		//Print out current age and age from future date
		System.out.print("You are currently ");
		birthday1.calculateAge();
		System.out.println(" ");
		System.out.print("On ");
		futureage1.displayFutureDate();
		System.out.print("You will be ");
		futureage1.calculateFutureAge();
		
	}
}

