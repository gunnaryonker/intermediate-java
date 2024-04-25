package Project2;
import java.util.*;
import java.io.FileNotFoundException;

/*
 * Author: Gunnar Yonker
 * File: USAFigureSkatingTeam.java
 * Created: 7/17/2022
 * Modified: 8/10/2022
 * Description: A program that reads from the fsdata.txt file and prints out the skater stats in descending total point order, then prints the winner for short, long, and competition. Along with highest points and the top 5
 * skaters that will be on the 2017 USA Mens Figure Skating Team
 * **Added in a user prompt to select which project to print out
 */

public class USAFigureSkatingTeam {
	//Main class which calls to other classes
	public static void main(String args[]) throws FileNotFoundException {
		Scanner myScanner = new Scanner(System.in);		
		//While loop to ensure right number entered
		while(true){
			//Ask user if project 2 or 3 is being run
			System.out.print("Project 2 or 3?(Enter 2 or 3):");
			int projectnum = 0;
			projectnum = myScanner.nextInt();

			if(projectnum == 2) {
				//Call to the fileread class and read the text file to get information
				FileRead readfile = new FileRead();
				readfile.fileread();
				//Create the skaters arraylist from SkaterStructure
				ArrayList<SkaterStructure> skaters = readfile.getSkaters();
				//Call to the print class
				SkaterReport results = new SkaterReport();
				results.setSkaters(skaters);
				//Call SkaterReport print function
				results.printReport();
				break;
			}
			else if(projectnum == 3) {
				//Error Checking for fsdataNew.txt
				System.out.println("");
				ErrorCheck test = new ErrorCheck();
				test.errorCheck();
				break;
			}
			else {
				System.out.println("Invalid Entry, try again");
				continue;
			}
		}
	}
}
