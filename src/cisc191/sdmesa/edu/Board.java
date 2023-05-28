package cisc191.sdmesa.edu;

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
 * 	This class creates a 3x3 matrix of Shapes
 * 	This class has a method to check if a player has won or if the game was a draw
 * 	This class has a method that returns if the game was a draw
 * 	This class has methods to get and set Shapes at certain indexes
 * 	This class has a method to check if the player is one move away from winning and returns the coordinates required to block them
 *	Every Board a a 3x3 matrix of Shapes and an isDraw boolean
 * 
 */

public class Board 
{	
	//Instance variables
	
	//Every Board has a matrix of shapes
	private Shape[][] currentBoard;
	
	//Every Board has a boolean isDraw that checks if the game was a draw
	private boolean isDraw = false;
	
	//Constructor that fills the 3x3 Board with blankShapes
	public Board() 
	{
		//Initialize a "BLANK" Shape object that is used to fill in any empty squares
		Shape blankShape = new Shape("BLANK");
		
		//Initialize the Board to be a 3x3 matrix
		currentBoard = new Shape[3][3];
		
		//Loop through every index of the currentBoard and insert a "BLANK" Shape object in every square
		for(int i = 0; i < 3; i ++) 
			{
				for (int j = 0; j < 3; j++)
				{
					currentBoard[i][j] = blankShape;	
				}
			}
	}

	//Method that uses if statements to check if a player has won, or if the game was a draw
	public boolean checkBoard() 
	{
		//Initialize the boolean that will be returned
		boolean isGameOver = false;
		
		//Checks every winning combination and changes the isGameOver boolean accordingly
		if (currentBoard[0][0].getShapeName() == currentBoard[1][0].getShapeName() && currentBoard[0][0].getShapeName() == currentBoard[2][0].getShapeName() && currentBoard[0][0].getShapeName() != "BLANK")
			isGameOver = true;
		
		else if (currentBoard[0][1].getShapeName() == currentBoard[1][1].getShapeName() && currentBoard[0][1].getShapeName() == currentBoard[2][1].getShapeName() && currentBoard[0][1].getShapeName() != "BLANK")
			isGameOver = true;
		
		else if (currentBoard[0][2].getShapeName() == currentBoard[1][2].getShapeName() && currentBoard[0][2].getShapeName() == currentBoard[2][2].getShapeName() && currentBoard[0][2].getShapeName() != "BLANK")
			isGameOver = true;
		
		else if (currentBoard[0][0].getShapeName() == currentBoard[0][1].getShapeName() && currentBoard[0][0].getShapeName() == currentBoard[0][2].getShapeName() && currentBoard[0][0].getShapeName() != "BLANK")
			isGameOver = true;
		
		else if (currentBoard[1][0].getShapeName() == currentBoard[1][1].getShapeName() && currentBoard[1][0].getShapeName() == currentBoard[1][2].getShapeName() && currentBoard[1][0].getShapeName() != "BLANK")
			isGameOver = true;
		
		else if (currentBoard[2][0].getShapeName() == currentBoard[2][1].getShapeName() && currentBoard[2][0].getShapeName() == currentBoard[2][2].getShapeName() && currentBoard[2][0].getShapeName() != "BLANK")
			isGameOver = true;
		
		else if (currentBoard[0][0].getShapeName() == currentBoard[1][1].getShapeName() && currentBoard[0][0].getShapeName() == currentBoard[2][2].getShapeName() && currentBoard[0][0].getShapeName() != "BLANK")
			isGameOver = true;
		
		else if (currentBoard[0][2].getShapeName() == currentBoard[1][1].getShapeName() && currentBoard[0][2].getShapeName() == currentBoard[2][0].getShapeName() && currentBoard[1][1].getShapeName() != "BLANK")
			isGameOver = true;
		
		//This part checks that, if no player has won, if the whole board is filled up then returns that the game is over and it was a draw by setting both booleans to true
		else
		{
			//Loops through the entire Board
			for (int x = 0; x < 3; x++)
			{
				for (int y = 0; y < 3; y++)
				{
					//If any square is "BLANK", the game is not a draw (that would be impossible), and the loop is exited
					if (currentBoard[y][x].getShapeName().equals("BLANK"))
					{
						isGameOver = false;
						this.isDraw = false;
						x = 3;
						y = 3;
					}
					
					//If the square is not "BLANK", the game may be over and would therefore be a draw. If any of the other squares are found to be empty, both booleans are set to false and the loop is exited immediately
					else
					{
						isGameOver = true;
						this.isDraw = true;
					}
				}
			}	
		}
		
		//Returns the boolean
		return isGameOver;	
	}
	
	//Method that returns the isDraw boolean
	public boolean checkIsDraw() 
	{
		return isDraw;
	}
	
	//Method that returns the shape at a certain point on the Board
	public Shape getShape(int y, int x) 
	{	
		return (currentBoard[x][y]);	
	}
	
	//Method that sets the Shape at a certain point on a Board
	public void setShape(Shape newShape, int y, int x) 
	{	
		currentBoard[x][y] = newShape;	
	}
	
	//Method that is called every time the computer has to play a move and checks if the player is one move away from winning and returns the required coordinates to block them
	public int[] checkIfPlayerIsAboutToWin(Shape computerShape) 
	{	
		//Create shapes to hold the opponents shape, and one for the temp shape
		Shape opposingPlayerShape;
		Shape tempShape;
		
		//String to hold the name of the opponents shape
		String tempShapeName;
		
		//Counters that are used when checking rows and columns
		int trueOrFalseCounter = 0;
		int otherTrueOrFalseCounter = 0;
		int newTrueOrFalseCounter = 0;
		
		//Initialize array to hold the coordinates
		int[] coordinates = new int[2];
		
		//These coordinates are set to arbitrary numbers much larger than the dimensions of the Board. If these coordinates are returned unchanged, this basically tells the computer class that the player is NOT one move away from winning and continues without needing to block
		coordinates[0] = 25;
		coordinates[1] = 25;
		
		//Declare other arrays that are used to temporarily store coordinates, these arrays are not returned
		int[] tempCoordinates = new int[2];
		int[] otherTempCoordinates = new int[2];
		
		//Create the opposingPlayerShape object based on the Computer's Shape (It is set to the opposite Shape)
		if (computerShape.getShapeName().equals("X"))
			opposingPlayerShape = new Shape("O");
		
		else
			opposingPlayerShape = new Shape("X");
		
		//Loop through checking if a square contains either the Player's Shape or is "BLANK". If the square contains a Player's Shape, add 2 to the counter, and if it is empty, add 1. Only if the counter equals exactly 5 does the computer need to block. So the counter is reset to 0 every time the column or row is incremented. If the counter is found to equal exactly 5, the coordinates are stored then later returned and the Computer places its Shape there to block.
		for(int y = 0; y < 3; y++)
		{	
			//Initialize the counters
			trueOrFalseCounter = 0;
			otherTrueOrFalseCounter = 0;
			
			//This for loop is user for checking both the rows and columns of the Board
			for(int x = 0; x < 3; x++)
			{	
				//Set the tempShape to whichever shape the for loops are currently on
				tempShape = this.getShape(x, y);
				
				//String to hold the name of our temporary Shape
				tempShapeName = tempShape.getShapeName();
				
				//If the name of the tempShape is the same as the name of the Player's Shape, increment the trueOrFalseCounter by 2
				if(tempShapeName.equals(opposingPlayerShape.getShapeName()))
				{
					trueOrFalseCounter += 2;
				}
				//Else if the name of the tempShape is "BLANK", hold those temporary coordinates and increment the trueOrFalseCounter
				else if (tempShapeName.equals("BLANK"))
				{
					tempCoordinates[0] = x;
					tempCoordinates[1] = y;
					trueOrFalseCounter++;
				}
				
				//If the trueOrFalseCounter is equal to exactly 5, that means that the Computer needs to block so the tempCoordinates are transferred into the coordinates array that will be returned and the for loop is exited
				if (trueOrFalseCounter == 5)
				{
					coordinates[0] = tempCoordinates[0];
					coordinates[1] = tempCoordinates[1];
					
					x = 3;
					y = 3;
				}
				
				//If the trueOrFalseCounter does not equal 5, continue checking the rows of the Board
				else
				{
					//Set the tempShape to whichever shape the for loops are currently on
					tempShape = this.getShape(y, x);
					
					//String to hold the name of our temporary Shape
					tempShapeName = tempShape.getShapeName();
					
					//If the name of the tempShape is the same as the name of the Player's Shape, increment the trueOrFalseCounter by 2
					if(tempShapeName.equals(opposingPlayerShape.getShapeName()))
					{
						otherTrueOrFalseCounter += 2;
					}
					//Else if the name of the tempShape is "BLANK", hold those temporary coordinates and increment the otherTrueOrFalseCounter
					else if (tempShapeName.equals("BLANK"))
					{
						otherTempCoordinates[0] = y;
						otherTempCoordinates[1] = x;
						otherTrueOrFalseCounter++;
					}
					//If the otherTrueOrFalseCounter is equal to exactly 5, that means that the Computer needs to block so the otherTempCoordinates are transferred into the coordinates array that will be returned and the for loop is exited
					if (otherTrueOrFalseCounter == 5)
					{
						coordinates[0] = otherTempCoordinates[0];
						coordinates[1] = otherTempCoordinates[1];
						
						x = 3;
						y = 3;
					}
				}
			}
			
			//The previous two for loops check both the rows and columns simultaneously, this one checks the diagonal from the top left to bottom right and works in the exact same way
			
			//If neither of the previous counters equal 5, continue checking the diagonal
			if (trueOrFalseCounter != 5 && otherTrueOrFalseCounter != 5)
			{
				//Set the tempCoordinates array to 0
				tempCoordinates[0] = 0;
				tempCoordinates[1] = 0;
				
				//Counter used for this diagonal
				newTrueOrFalseCounter = 0;
				
				//Loop through the diagonal of the Board using a for loop
				for(int i = 0; i < 3; i++)
				{
					//Set the tempShape to whichever shape the for loop is currently on
					tempShape = this.getShape(i, i);
					
					//String to hold the name of our temporary Shape
					tempShapeName = tempShape.getShapeName();
					
					//If the name of the tempShape is the same as the name of the Player's Shape, increment the newTrueOrFalseCounter by 2
					if(tempShapeName.equals(opposingPlayerShape.getShapeName()))
					{
						newTrueOrFalseCounter += 2;
					}
					//Else if the name of the tempShape is "BLANK", hold those temporary coordinates and increment the newTrueOrFalseCounter
					else if (tempShapeName.equals("BLANK"))
					{
						tempCoordinates[0] = i;
						tempCoordinates[1] = i;
						newTrueOrFalseCounter++;
					}
					//If the newTrueOrFalseCounter is equal to exactly 5, that means that the Computer needs to block so the tempCoordinates are transferred into the coordinates array that will be returned and the for loop is exited
					if (newTrueOrFalseCounter == 5)
					{
						coordinates[0] = tempCoordinates[0];
						coordinates[1] = tempCoordinates[1];
						
						i = 3;
					}
				}
			}
			
			//Finally, if none of the previous checks worked, check the top right to bottom left diagonal
			if (trueOrFalseCounter != 5 && otherTrueOrFalseCounter != 5 && newTrueOrFalseCounter != 5)
			{
				//Set the tempCoordinates array to 0
				tempCoordinates[0] = 0;
				tempCoordinates[1] = 0;
				
				//Set the counter used for this diagonal to 0
				trueOrFalseCounter = 0;
				
				//Initialize a variable to hold the horizontal index of the array
				int k = 2;
				
				//Loop through the array
				for(int j = 0; j < 3; j++)
				{	
					//Set the tempShape to whichever shape the for loop is currently on
					tempShape = this.getShape(k, j);
					
					//String to hold the name of our temporary Shape
					tempShapeName = tempShape.getShapeName();
					
					//If the name of the tempShape is the same as the name of the Player's Shape, increment the trueOrFalseCounter by 2
					if(tempShapeName.equals(opposingPlayerShape.getShapeName()))
					{
						trueOrFalseCounter += 2;
					}
					//Else if the name of the tempShape is "BLANK", hold those temporary coordinates and increment the trueOrFalseCounter
					else if (tempShapeName.equals("BLANK"))
					{
						tempCoordinates[0] = k;
						tempCoordinates[1] = j;
						trueOrFalseCounter++;
					}
					
					//If the trueOrFalseCounter is equal to exactly 5, that means that the Computer needs to block so the tempCoordinates are transferred into the coordinates array that will be returned and the for loop is exited
					if (trueOrFalseCounter == 5)
					{
						coordinates[0] = tempCoordinates[0];
						coordinates[1] = tempCoordinates[1];
						j = 3;
					}
					
					//Increment the horizontal counter down by one
					k--;
				}	
			}
		}
		
		//Return the array containing the coordinates
		return coordinates;
	}
}
