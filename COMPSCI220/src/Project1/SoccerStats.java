package Project1;
import java.util.Arrays;
import java.util.Scanner;
/*
 * Author: Gunnar Yonker
 * Created: 7/7/2022
 * Modified: 7/9/2022
 * Description: A program to track the top 10 high school soccer players points after 10 regular season games that summarizes the total points by each player
 */

public class SoccerStats {
	//Create a scanner
	Scanner myScanner = new Scanner(System.in);		
	//Declare a data member Stats as a 2D array with 10 rows and 11 columns, each row is a player, each column is a game, last column is total points
	int[][] Stats = new int[10][11];
	//Constructor to initialize the 2D array to be zero
	public SoccerStats()
	{
	    for (i = 0; i < Stats.length; i++)
	    {
	        for (j = 0; j < Stats.length; j++)
	        {
	            Stats[i][j] = 0;
	        }
	    }
	}

	int i =0; int j =0;
	int pointScore = 0;
	
	//Main Method
	public static void main(String[] args) {
		SoccerStats season = new SoccerStats();
	//Call the getData function
		season.getData();
	//Call the report function
		season.report();
	}

	//Declare Two Methods
	//void getData()
	public void getData()
	{
		System.out.println("Soccer Stat Tracker");
		System.out.println("Enter Player Number(1-10), Game Number(1-10), and Points Scored(Any Integer)");
		System.out.println("Example input: 1 5 8");
		System.out.println(" ");
		while(true)
		{
			System.out.print("Stat Entry: ");
			String statentry = " ";
			statentry = myScanner.nextLine();
			String[] statSplit = statentry.split(" ");
			i = Integer.parseInt(statSplit[0]);
			j = Integer.parseInt(statSplit[1]);
			pointScore = Integer.parseInt(statSplit[2]);
			
			//Ensure that the player number, game number, and pointScore are correct inputs before storing data otherwise ask for re-entry
			if(i < 0 || j < 0 || i > 10 || j > 10 || pointScore < 0)
			{
				System.out.println("One or more entries was invalid, try again.");
				System.out.println(" ");
				continue;
			}
		
			Stats[i-1][j-1] = pointScore; //i and j are minus one because index is 0-9, but this allows the input on player number and game to be more clear with 1-10 since you can't really have a game zero
			
			System.out.print("Press Enter to add another stat, type 'Done' to print score report. ");
				String nextStat = myScanner.nextLine();
				if(nextStat.equals("Y") || nextStat.equals(""))
				{
					continue;//Continue with the while loop for entries
				}
				else if(nextStat.equals("Done"))
				{
					break;//exit the while loop and return to main method to print results
				}
		}
	}

	//void report()
	public void report()
	{
		int totPoints = 0;
		
		//Calculate the total points and put in column 11
		for(int i=0; i<Stats.length; i++)
		{
			totPoints = 0; //return total points to 0 before counting next players row of points
			for(int j =0; j<Stats.length; j++)
			{
				totPoints = totPoints + Stats[i][j];
			}
			Stats[i][10] = totPoints; //store the points in player row 11th column
		}
		//Formatted Table Header
		System.out.println(" ");
		System.out.println("Stat Report");
		System.out.println("---------------------------------------");
		System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s",
				"Game 1", "Game 2", "Game 3", "Game 4", "Game 5", "Game 6", "Game 7", "Game 8", "Game 9", "Game 10", "Total Points");
		System.out.println(" ");
		//Print out each 
		for(int i = 0; i < Stats.length; i++)
		{
		   for(int j = 0; j < Stats[0].length; j++)
		   {
		      System.out.printf("   %-8d", Stats[i][j]);
		   }
		   System.out.println();
		}
		//Find the max points scored by a player
		int max = Stats[0][10]; int playerMax =0;
        for(i = 1; i < Stats.length; i++) {
            if (Stats[i][10] > max)
            {
                max = Stats[i][10];
            	playerMax = i;//Return player row 0-9 index and when printing add 1 to make it player 1-10
            }
        }
		System.out.println("Player "+(playerMax+1)+ " has the highest number of points with "+max+" points.");
	}
}
