package Project4;
import java.util.*;
import java.io.FileNotFoundException;

/*
 * Author: Gunnar Yonker
 * File: USAFigureSkatingTeam.java
 * Created: 8/13/2022
 * Description: A program that reads from the fdataNewFile.txt and gathers the information on each skater such as name, club, all point amounts and total points, gender, age, height, and state. Then
 * it prints out the formatting for the youngest skater in mens and ladies events, height range for men and ladies, and then the states that the skaters are from with no duplicate states.
 */

public class USAFigureSkatingTeam {
	//Main class which calls to other classes
	public static void main(String args[]) throws FileNotFoundException {
		
		FileRead readfile = new FileRead();
		readfile.fileread();
		ArrayList<Skater> skaters = readfile.getSkaters();
		FileReport results = new FileReport();
		//Call SkaterReport print function
		results.setSkaters(skaters);
		results.fullPrint();
		
	}
}
