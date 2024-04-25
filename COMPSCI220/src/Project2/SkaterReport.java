package Project2;
import java.util.*;

/*
 * Author: Gunnar Yonker
 * File: SkaterReport.java
 * Description: Class that prints out the data collected in formatted tables, sorted by point values and declaring winners of each section along with 2017 USA Roster
 */

public class SkaterReport {

	private ArrayList<SkaterStructure> skaters;
	
	public SkaterReport() {
		super();
		this.skaters = new ArrayList<SkaterStructure>();
	}
	//getters and setters
	public ArrayList<SkaterStructure> getSkaters(){
		return skaters;
	}
	public void setSkaters(ArrayList<SkaterStructure> skaters) {
		this.skaters = skaters;
	}
	
	//Report method
	public void printReport() {
		for(int i=0; i<this.skaters.size(); i++) {
			for(int j=0; j<this.skaters.size()-i-1; j++) {
				double totpoints = this.skaters.get(j).getShort() + this.skaters.get(j).getLong();
				double totpointstwo = this.skaters.get(j+1).getShort() + this.skaters.get(j+1).getLong();
				//Sort into list based on total points
				if(totpoints < totpointstwo) {
					SkaterStructure holder = this.skaters.get(j+1);
					this.skaters.set(j+1, this.skaters.get(j));
					this.skaters.set(j, holder);
				}
			}
		}
		//Print out table with information in it
		System.out.println("Results from the US National Championship in Kansas city, MO");
		System.out.println("------------------------------------------------------------");
		System.out.printf("%-23s %-30s %-15s %-15s %-15s",
					"Skater Name", "Skater Club", "Short Points", "Long Points", "Total Points");
		System.out.println("");
		double total = 0;
		for(int i=0; i<skaters.size(); i++) {
			//Get total for each skater
			total = (this.skaters.get(i).getShort() + this.skaters.get(i).getLong());
			
			System.out.printf("%-23s %-30s %-15.2f %-15.2f %-15.2f",
					this.skaters.get(i).getName(), this.skaters.get(i).getClub(), this.skaters.get(i).getShort(), this.skaters.get(i).getLong(), total);
			System.out.println(" ");
		}
		//Winner of short and long program
		System.out.println(" ");
		System.out.println("Winner of Short Program: " + this.skaters.get(0).getName());
		System.out.println("Winner of Long Program: "+ this.skaters.get(0).getName());
		//Winner of the total competition, top 4
		System.out.println("");
		System.out.println("Winner of Competition(Podium Placements): ");
		//Find top 4
		for(int i=0; i<4; i++) {
			System.out.println(this.skaters.get(i).getName());
		}
		//Highest Artistic points
		SkaterStructure topart = this.skaters.get(0);
		for(int i=0; i<this.skaters.size(); i++) {
			if(this.skaters.get(i).getArt() > topart.getArt()) {
				topart = this.skaters.get(i);
			}
		}
		System.out.println("");
		System.out.println("Skater with Highest Artistic Points: " + topart.getName());
		//Highest Athletic Points
		SkaterStructure topath = this.skaters.get(0);
		for(int i=0; i<this.skaters.size(); i++) {
			if(this.skaters.get(i).getAth() > topath.getAth()) {
				topath = this.skaters.get(i);
			}
		}
		System.out.println("Skater with Highest Athletic Points: " + topath.getName());
		System.out.println("");
		//Top 5 that make the Men's USA Figure Skating Roster
		System.out.println("2017 USA Men's Figure Skating Team Roster");
		for(int i=0; i<5; i++) {
			System.out.println(this.skaters.get(i).getName());
		}
	}
}
