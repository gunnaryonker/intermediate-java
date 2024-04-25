package Project2;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

/*
 * Author: Gunnar Yonker
 * File: ErrorCheck.java
 * Description: Class file that reads the new fsdataNew.txt file and then checks the format of each skater, printing out errors associated with invalid formats according to the Project 3 instructions
 */

public class ErrorCheck {
	
	
	public void errorCheck() throws FileNotFoundException {
		try {
		Scanner inFR = new Scanner(new File("fsdataNew.txt"));
		//Create new objects
		SkaterStructure skater = new SkaterStructure();
		System.out.println("Invalid Data Entry Codes Report from fsdataNew.txt:");
		System.out.println("---------------------------------------------------");
		System.out.printf("%-20s %-20s", "Skater's Name", "Error Code");
		
		//Read
		while(inFR.hasNext()) {
			String errors = "";
			String infoline = inFR.nextLine();
			String [] temp = infoline.trim().split("\\s+");
			skater.setName(temp[0] + " " + temp [1]);
			//Club name
			String skaterclub = infoline.substring(21,47).trim();
			String [] clubname = skaterclub.trim().split(" ");
			int index = clubname.length - 1;
			//Split Skater Names
			String[] name = skater.getName().split(" ");
			String firstname = name[0];
			String lastname = name[name.length-1];
			//Check for error A, first name did not start with uppercase
			if(!firstname.isEmpty()){
				if(!Character.isUpperCase(firstname.charAt(0))) {
					errors += "A";
				}
			}
			//Check for error B, last name did not start with uppercase
			if(!lastname.isEmpty()){
				if(!Character.isUpperCase(lastname.charAt(0))) {
					if(!errors.isEmpty()) {
						errors += ",B";
					}
					else {
						errors += "B";
					}
				}
			}
			//Check for error C, Long program point format is invalid
			if(clubname[index].equals("FSC") ) {
				skater.setClub(skaterclub);
				//Parse the point components
				String shortstring = infoline.substring(47,53).trim();
				String longstring = infoline.substring(54,61).trim();
				double shortpoints = (Double.parseDouble(shortstring));
				double longpoints = (Double.parseDouble(longstring));
				if(Math.floor(longpoints) <0 || Math.floor(longpoints) > 999) {
					if(!errors.isEmpty()) {
						errors += ",C";	
					}
					else {
						errors += "C";
					}
				}
				else if(BigDecimal.valueOf(longpoints).scale()>=3) {
					if(!errors.isEmpty()) {
						errors += ",C";	
					}
					else {
						errors += "C";
					}
				}
				//Check for error D, short program point format is valid
				if(Math.floor(shortpoints) <0 || Math.floor(shortpoints) > 999) {
					if(!errors.isEmpty()) {
						errors += ",D";	
					}
					else {
						errors += "D";
					}
				}
				else if(BigDecimal.valueOf(shortpoints).scale()>=3) {
					if(!errors.isEmpty()) {
						errors += ",D";	
					}
					else {
						errors += "D";
					}
				}
				//Check for Error E, Executed program point format is valid
				String programstring = infoline.substring(62,69).trim();
				String executedstring = infoline.substring(69,75).trim();
				double programpoints = (Double.parseDouble(programstring));
				double executedpoints = (Double.parseDouble(executedstring));
				if(Math.floor(executedpoints) <0 || Math.floor(executedpoints) > 999) {
					if(!errors.isEmpty()) {
						errors += ",E";	
					}
					else {
						errors += "E";
					}
				}
				else if(BigDecimal.valueOf(executedpoints).scale()>=3) {
					if(!errors.isEmpty()) {
						errors += ",E";	
					}
					else {
						errors += "E";
					}
				}
				//Check for error F, program points format is invalid
				if(Math.floor(programpoints) <0 || Math.floor(programpoints) > 999) {
					if(!errors.isEmpty()) {
						errors += ",F";	
					}
					else {
						errors += "F";
					}
				}
				else if(BigDecimal.valueOf(programpoints).scale()>=3) {
					if(!errors.isEmpty()) {
						errors += ",F";	
					}
					else {
						errors += "F";
					}
				}
				//Check for error G, Total of executed element and program component is not smaller than long program point
				if(programpoints + executedpoints > longpoints) {
					if(!errors.isEmpty()) {
						errors += ",G";	
					}
					else {
						errors += "G";
					}
				}
				//Print out error codes, if any
				if(!errors.isEmpty()) {
					System.out.printf("\n%-20s %-20s", skater.getName(), errors);
				}
			}
			else if(!infoline.contains("FSC") || !clubname[index].equals("FSC") ) {
				//Check for error G, Total of executed element and program component is not smaller than long program point
				if(!errors.isEmpty()) {//Club ERROR reported when the club name either does not contain FSC or does not have FSC at the end of name. This makes it an invalid format
					errors += ",Club ERROR";	
				}
				else {
					errors += "Club ERROR";
				}
				//Print out error codes, if any
				if(!errors.isEmpty()) {
					System.out.printf("\n%-20s %-20s", skater.getName(), errors);
				}
			}
	}//End of while
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
			System.exit(0);
		}

	}	
}
