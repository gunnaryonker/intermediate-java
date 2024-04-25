package Project2;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Author: Gunnar Yonker
 * File: FileRead.java
 * Description: Class that opens the file fsdata.txt and reads the data to create profiles for the skaters
 */

public class FileRead {
	FileInputStream fileread = null;
	Scanner inFR = null;
	
	//Variable Array for Skater info
	private ArrayList<SkaterStructure> skaters;
	
	public FileRead() {
		super();
		this.skaters = new ArrayList<SkaterStructure>();
	}
	
	public void fileread() throws FileNotFoundException {
		try {
		Scanner inFR = new Scanner(new File("fsdata.txt"));
		
		//Create new objects
		SkaterStructure skater = new SkaterStructure();
		
		//Read
		while(inFR.hasNext()) {
			String infoline = inFR.nextLine();
			String [] temp = infoline.trim().split("\\s+");
			skater.setName(temp[0] + " " + temp [1]);
			//Add the skater clubs
			//Add the short program points, need to parse from string to double to use to calculate total points
			if(temp[3].equals("FSC")) {
				skater.setClub(temp[2] + " " + temp[3]);
				//index 4 is short, index 5 long, index 6 program, index 7 execute
				skater.setShort(Double.parseDouble(temp[4]));
				skater.setLong(Double.parseDouble(temp[5]));
				skater.setArt(Double.parseDouble(temp[6]));
				skater.setAth(Double.parseDouble(temp[7]));
				this.skaters.add(skater);
				skater = new SkaterStructure();
			}
			else if(temp[4].equals("FSC")) {
				skater.setClub(temp[2] + " " + temp[3] + " " + temp[4]);
				skater.setShort(Double.parseDouble(temp[5]));
				skater.setLong(Double.parseDouble(temp[6]));
				skater.setArt(Double.parseDouble(temp[7]));
				skater.setAth(Double.parseDouble(temp[8]));
				this.skaters.add(skater);
				skater = new SkaterStructure();
			}
			else if(temp[5].equals("FSC")) {
				skater.setClub(temp[2] + " " + temp[3] + " " + temp[4] + " " + temp[5]);
				skater.setShort(Double.parseDouble(temp[6]));
				skater.setLong(Double.parseDouble(temp[7]));
				skater.setArt(Double.parseDouble(temp[8]));
				skater.setAth(Double.parseDouble(temp[9]));
				this.skaters.add(skater);
				skater = new SkaterStructure();
			}
		}
		}
		catch(FileNotFoundException e){
			System.out.println("File not found.");
			System.exit(0);
		}

			}	
		public ArrayList<SkaterStructure> getSkaters(){
			return skaters;
		}
		
		public void setSkaters(ArrayList<SkaterStructure> skaters) {
			this.skaters = skaters;
		}
}
