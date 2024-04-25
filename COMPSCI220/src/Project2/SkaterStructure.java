package Project2;

/*
 * Author: Gunnar Yonker
 * File: SkaterStructure.java
 * Description: Class file with the constructor, getters and setters for the skater information objects
 */

public class SkaterStructure {
	//Declare variables
	private String name;
	private String club;
	private double shortprogram;
	private double longprogram;
	private double artpoints;
	private double executedelement;
	
	public SkaterStructure() {
		super();
	}
	//Constructor for skater objects
	public SkaterStructure(String name, String club, double shortprogram, double longprogram, double artpoints, double executedelement) {
		super();
		this.name = name;
		this.club = club;
		this.shortprogram = shortprogram;
		this.longprogram = longprogram;
		this.artpoints = artpoints;
		this.executedelement = executedelement;
	}
	//getters and setters for variables
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	public double getShort() {
		return shortprogram;
	}
	public void setShort(double shortprogram) {
		this.shortprogram = shortprogram;
	}
	public double getLong() {
		return longprogram;
	}
	public void setLong(double longprogram) {
		this.longprogram = longprogram;
	}
	public double getArt() {
		return artpoints;
	}
	public void setArt(double artpoints) {
		this.artpoints = artpoints;
	}
	public double getAth() {
		return executedelement;
	}
	public void setAth(double executedelement) {
		this.executedelement = executedelement;
	}		
}
