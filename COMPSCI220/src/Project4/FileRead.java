package Project4;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Author: Gunnar Yonker
 * File: FileRead.java
 * Description: Class that opens the file fdataNewData.txt and reads the data to create profiles for the skaters
 */

public class FileRead {
	FileInputStream fileread = null;
	Scanner inFR = null;
	
	//Variable Array for Skater info
	private ArrayList<Skater> skaters;
	
	public FileRead() {
		super();
		this.skaters = new ArrayList<Skater>();
	}
	
	public void fileread() throws FileNotFoundException {
		
		//Read
		try {
			Scanner inFR = new Scanner(new File("fdataNewFile.txt"));
			//Create new objects
			Skater skater = new Skater();
			System.out.println("Project 4 reading from fdataNewFile.txt");
			System.out.println("---------------------------------------");
			System.out.printf("");
			//Read
			while(inFR.hasNextLine()) {
				String infoline = inFR.nextLine();
				String [] temp = infoline.trim().split("\\s+");
				skater.setName(temp[0] + " " + temp [1]);
				//Read and set gender
				String gender = infoline.substring(76,77).trim();
				if(gender.equals("M")) {
					gender = "M";
					skater.setGender(gender);
				}
				else if(gender.equals("L")) {
					gender = "F";
					skater.setGender(gender);
				}
				//Read and set age
				String age = infoline.substring(79,81).trim();
				skater.setAge(Integer.parseInt(age));

				//Read and set club
				skater.setClub(infoline.substring(21,46).trim());
				
				//Read and set long program points
				String longpoints = infoline.substring(54,61).trim();
				skater.setLong(Double.parseDouble(longpoints));
				
				//Read and set short program points
				String shortpoints = infoline.substring(47,53).trim();
				skater.setShort(Double.parseDouble(shortpoints));
				
				//Read and set art program points
				String artpoints = infoline.substring(62,69).trim();
				skater.setArtistic(Double.parseDouble(artpoints));
				
				//Read and set athletic program points
				String athpoints = infoline.substring(69,75).trim();
				skater.setAthleticism(Double.parseDouble(athpoints));
				
				//Set total points
				skater.setTotal(Double.parseDouble(shortpoints)+Double.parseDouble(longpoints));
				
				//Read and set height
				String height = infoline.substring(83,88).trim();
				skater.setHeight(height);
				
				//Read and set state
				String state = infoline.substring(90,92).trim();
				skater.setState(state);

				//add skater to skaters list
				this.skaters.add(skater);
				skater = new Skater();
			}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
			System.exit(0);
		}
	}
		
		public ArrayList<Skater> getSkaters(){
			return skaters;
		}
		
		public void setSkaters(ArrayList<Skater> skaters) {
			this.skaters = skaters;
		}
	}
