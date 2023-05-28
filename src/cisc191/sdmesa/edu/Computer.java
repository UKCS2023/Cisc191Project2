package cisc191.sdmesa.edu;
import java.util.Random;

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
 * 	Every Computer extends Player and implements the Placeable interface
 * 	Every Computer has an array of integers used to hold the coordinates of its answer
 * 	Every Computer has a method that returns the String "Computer"
 * 	Every Computer has a method that plays its move on the gameBoard
 * 	Every Computer has a method that checks if the chosen square is empty
 * 	Every Computer has a method that converts the computer's integer choice into a Shape object then returns it
 * 	Every Computer has a method that converts the computer’s choice into coordinates on the game board and returns them as an array of two integers
 * 	Every Computer has a method that returns the coordinates of the computer's chosen square
 * 
 */
 
//Every computer is a player that implements the Placeable interface
public class Computer extends Player implements Placeable 
{
	//Instance variable to hold the computer's choice of coordinates
	
	//Every Computer has coordinates where it will place its piece
	private int [] answerCoordinates;
	
	//Constructor
	public Computer() 
	{
		setWins(0);
		setShape(null);		
	}
	
	//Method that returns the name of the computer
	public String getName() 
	{	
		return "Computer";	
	}
	
	//Method that makes the computer play its move
	public void playMove (Board gameBoard) 
	{
		//Create a new random object and sets userChoice variable to a random number, 1 - 9 
		Random rand = new Random();
		int userChoice = rand.nextInt(9) + 1;
		
		//Creates array to hold the coordinates of the user's chosen square
		answerCoordinates = new int[2];
		
		//Create temporary shape to hold the shape in a given square (used for checking if a square is empty)
		Shape tempShape = new Shape("NOTBLANK");
		
		//While the shape is not placeable, loop until the computer randomly choose a square that is empty
		while (!checkIsPlaceable(tempShape)) 
		{	
			userChoice = rand.nextInt(9) + 1;
			
			tempShape = choiceToTemp(userChoice, gameBoard);
		}
		
		//If the checkIfPlayerIsAboutToWin method does not return 25 in the first spot of the array, that means that it returned the coordinates of the square on the board to block. Set the answerCoordinates equal to those coordinates and output a message
		if (gameBoard.checkIfPlayerIsAboutToWin(getShape())[0] != 25)
		{
			answerCoordinates[0] = gameBoard.checkIfPlayerIsAboutToWin(getShape())[0];
			answerCoordinates[1] = gameBoard.checkIfPlayerIsAboutToWin(getShape())[1];
		}
		
		//Else, randomly pick a move
		else 
		{
			//Use the private choiceToTemp method to translate the computer's single-digit input into a Shape
			tempShape = choiceToTemp(userChoice, gameBoard);
			
			//Use the choiceToCoordinates method to translate the computer's input into coordinates on the board
			answerCoordinates = choiceToCoordinates(userChoice);
		}
		
		
		//Use the setShape method in the Board class to set the empty square to the shape of the computer
		gameBoard.setShape(this.getShape(), answerCoordinates[0], answerCoordinates[1]);		
	}
	
	//Method that checks if the given square is placeable, and returns a boolean value
	public boolean checkIsPlaceable(Shape tempShape) 
	{
		//Initialize the isPlaceable boolean to false
		boolean isPlaceable = false;
		
		//If the Shape is a "BLANK" Shape, set the isPlaceable boolean to true
		if (tempShape.getShapeName().equals("BLANK"))
			isPlaceable = true;
		
		//Return the boolean
		return isPlaceable;
	}
	
	//Private method that converts the computer's choice into a Shape, then returns that Shape
	private Shape choiceToTemp(int userChoice, Board gameBoard) 
	{	
		//Initialize a tempShape
		Shape tempShape = new Shape("NOTBLANK");
		
		if (userChoice == 1)
			tempShape = gameBoard.getShape(0, 0);
		
		else if (userChoice == 2)
			tempShape = gameBoard.getShape(1, 0);
		
		else if (userChoice == 3)
			tempShape = gameBoard.getShape(2, 0);
		
		else if (userChoice == 4)
			tempShape = gameBoard.getShape(0, 1);
		
		else if (userChoice == 5)
			tempShape = gameBoard.getShape(1, 1);
		
		else if (userChoice == 6)
			tempShape = gameBoard.getShape(2, 1);
		
		else if (userChoice == 7)
			tempShape = gameBoard.getShape(0, 2);
		
		else if (userChoice == 8)
			tempShape = gameBoard.getShape(1, 2);
		
		else if (userChoice == 9)
			tempShape = gameBoard.getShape(2, 2);
		
		//Return the tempShape
		return tempShape;
	}
	
	//Private method that turns the computer's choice into coordinates in the square
	private int[] choiceToCoordinates(int userChoice) 
	{
		//Declare an array of integers to hold the coordinates
		int[] coordinates = new int[2];
		
		if (userChoice == 1)
		{
			coordinates[0] = (0);
			coordinates[1] = (0);
		}
		else if (userChoice == 2)
		{
			coordinates[0] = (1);
			coordinates[1] = (0);
		}
		else if (userChoice == 3)
		{
			coordinates[0] = (2);
			coordinates[1] = (0);
		}
		else if (userChoice == 4)
		{
			coordinates[0] = (0);
			coordinates[1] = (1);
		}
		else if (userChoice == 5)
		{
			coordinates[0] = (1);
			coordinates[1] = (1);
		}
		else if (userChoice == 6)
		{
			coordinates[0] = (2);
			coordinates[1] = (1);
		}
		else if (userChoice == 7)
		{
			coordinates[0] = (0);
			coordinates[1] = (2);
		}
		else if (userChoice == 8)
		{
			coordinates[0] = (1);
			coordinates[1] = (2);
		}
		else if (userChoice == 9)
		{
			coordinates[0] = (2);
			coordinates[1] = (2);
		}
		
		//Return the final coordinates
		return coordinates;
	}
	
	//Method that returns the coordinates of the Computer's choice
	public int[] getAnswerCoordinates()
	{
		return answerCoordinates;
	}	
}
