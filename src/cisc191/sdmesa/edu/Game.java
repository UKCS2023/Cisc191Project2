package cisc191.sdmesa.edu;

import java.io.File; 
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Lead Author(s): Umar Khan
 * @author 
 * @author 
 * <<add additional lead authors here, with a full first and last name>>
 * 
 * Other contributors:
 * <<add additional contributors (mentors, tutors, friends) here, with contact information>>
 * 
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 
 * Ots, Indrek. "Java's While and Do-While Loops in Five Minutes — SitePoint." SitePoint – Learn HTML, CSS, JavaScript, PHP, UX & Responsive Design. Last modified April 26, 2017. 
 * https://www.sitepoint.com/javas-while-and-do-while-loops-tutorial/#:~:text=the%20for%20loop.-,Do%2DWhile%20Loop,always%2
 * 
 * (No Listed Publisher)
 * "Java.util.Random Class in Java." GeeksforGeeks. Last modified May 7, 2019. 
 * https://www.geeksforgeeks.org/java-util-random-class-java/.
 * 
 * (No Listed Publisher)
 * "Scanner and NextChar() in Java." GeeksforGeeks. Last modified April 11, 2023. 
 *  https://www.geeksforgeeks.org/gfact-51-java-scanner-nextchar/#.
 * 
 * (No Listed Publisher)
 * "File Input and Output." Department of Computer Science. Accessed May 8, 2023.
 *  https://www.cs.utexas.edu/~mitra/csSummer2009/cs303/lectures/fileIO.
 *  
 *  Aggarwal, Shivi. "Java AWT | CardLayout Class." GeeksforGeeks. Last modified August 17, 2021. 
 *  https://www.geeksforgeeks.org/java-awt-cardlayout-class/#.
 *  
 * Responsibilities of class:
 * 	This class creates a new Board object in its constructor
 * 	This class has a method that is used to add a line of stats to a file. This method takes in the player who won as well as the gameCount and appends a message to the StatsFile
 * 	This class also has a method that is used to return the last line in the file
 * 	This class also has a method that is used to delete the file which is used at the very end of the program
 * 	This class also has a method that is used to return the Board object which is initialized in the parameter
 * 	Every Game has a gameBoard
 * 
 */

public class Game 
{
	//Instance variable
	
	//Each game has a Board
	private Board gameBoard;
	
	//Constructor that creates a new board for the game
	public Game() 
	{
		gameBoard = new Board();
	}

	//Method that reads the file and returns the most recent line to the user
	public static String returnLastGameResults(int gameCounter)
	{
		//Initialize String to hold the line that will be returned
		String line = null;
		
		//Declare the Scanner object
		Scanner scnr = null;
		
		//Try to open the file and loop through it while setting the String equal to the last line of it
		try
		{
			//Create new File object using the "StatsFile" name
			File statsFile = new File ("StatsFile");
			
			//Create the Scanner object
			scnr = new Scanner(statsFile);
			
			//Loop through each line of the file
			while (scnr.hasNextLine()) 
			{
				//Set the line String equal to the current line of the file
	            line = scnr.nextLine();
	        }
			
			//Return the line (which should contain the last line of the File)
			return line;
		}
		//Catch any exceptions and print out the message
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}  
		//Use a finally block to close the scanner that way it is always closed
		finally 
		{
			//If the Scanner exists, close it
			if (scnr != null)
				scnr.close();		
		}
		//Return null if an exception occurred while reading the file
		return null;
	}
	
	//Method that appends the result of every game in a file and takes the winning Player as well as the gameCount as parameters
	public static void addStats(Player winner, int gameCount)
	{	
		//Declare the FileWriter and PrintWriter objects
		FileWriter writer = null;
		PrintWriter pWriter = null;
		
		//Tries to open the file and append a message based on the Player sent
		try
		{
			//Create a new file object
			File statsFile = new File ("StatsFile");
			
			//Create a new FileWriter
			writer = new FileWriter (statsFile, true);
			
			//Create our printWriter object
			pWriter = new PrintWriter(writer);
			
			//If the passed player has negative wins, the game was a draw. The "numberOfDraws" player is determined to be any player with negative wins and is exclusively used to count the number of draws
			if (winner.getWins() <= 0)
				pWriter.append("|Game " + (gameCount) + " This game was a Draw! Current draws: " + -1 * winner.getWins() + " |" +  "\n");
			
			//If a player actually won, append this message to the end of the file
			else
				pWriter.append("|Game " + (gameCount) + " " + winner.getName() + " Wins, current wins: " + winner.getWins() + "|" + "\n");
		}
		//Catch any exceptions in the process and print out the message
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		} 
		//Close the PrintWriter in the finally block so that it is always closed
		finally 
		{
			//If the pWriter exists, close it
	    	if (pWriter != null)
		    	pWriter.close();	
		}
	}
	
	//This method deletes the file and is only called right before exiting the program entirely. This is so that the same file name can be reused the next time the program is ran
	public static void closeFile() 
	{	
		File statsFile = new File ("StatsFile");
		
		statsFile.deleteOnExit();	
	}
	
	//Method that returns the Board that is being used for the current game
	public Board getBoard()
	{
		return gameBoard;
	}
}
