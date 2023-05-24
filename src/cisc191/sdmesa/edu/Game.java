package cisc191.sdmesa.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.Writer;

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
 * https://www.geeksforgeeks.org/gfact-51-java-scanner-nextchar/#.
 * 
 * (No Listed Publisher)
 * "File Input and Output." Department of Computer Science. Accessed May 8, 2023.
 * https://www.cs.utexas.edu/~mitra/csSummer2009/cs303/lectures/fileIO.
 *  
 * Version/date: 
 * 
 */

public class Game 
{
	//Each game has a Board, and has two Players (the User and Computer)
	private Board gameBoard;
	private Player userPlayer;
	private Player computerPlayer;
	
	//Constructor that takes two players as parameters and creates a new board for the game
	public Game(Player newUserPlayer, Player newComputerPlayer) 
	{
		gameBoard = new Board();
		userPlayer = newUserPlayer;
		computerPlayer = newComputerPlayer;
	}

	//Method that reads the file and displays its contents to the user
	public static String displayStats(int gameCounter)
	{
		//Initialize String to hold the lines that will be returned
		String line = null;
		
		//Declare the Scanner object
		Scanner scnr = null;
		
		//Try to open the file and loop through printing out its contents
		try
		{
			//Create new File object using the "StatsFile" name
			File statsFile = new File ("StatsFile");
			
			//Create the Scanner object
			scnr = new Scanner(statsFile);

			while (scnr.hasNextLine()) 
			{
	            line = scnr.nextLine();
	        }
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
		return null;
	}
	
	//Method that holds the result of every game in a file and takes the winning Player as a parameter
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
			
			//If the "nobody" player was passed, the game was a draw. The "nobody" player is determined to be any player with negative wins
			if (winner.getWins() <= 0)
				pWriter.append("|Game " + (gameCount) + " This game was a Draw!|" + "\n");
			
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
