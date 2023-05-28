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
 * 	This class is used to model the game and interacts with the view, controllers, as well as the rest of the program
 * 	This class has several instance variables which are used to hold different instances of objects throughout the program
 * 	This class has a constructor that initializes the computer, numberOfDrawsUser, and statsUpdated
 * 	This class also has setter and getter methods for each of these instance variables
 * 
 */

//This class models the game and is used to interact with the view and the controllers. This model also holds instances of other classes such as Game, User, and Computer, and provides getters and setters to access those instances.
public class GameModel 
{
	//Instance Variables

	//Every GameModel has a currentGame that holds the current game
	private Game currentGame;

	//Every GameModel has a player
	private User player;

	//Every GameModel has a computer
	private Computer computer;

	//Every GameModel has a gameCount
	private int gameCount;

	//Every GameModel has a numberOfDrawsUser User used to count the number of draws
	private User numberOfDrawsUser;

	//Every GameModel has a statsUpdated boolean that indicates whether the stats have been updated
	private boolean statsUpdated;
	
	//Constructor
	public GameModel()
	{
		//Initialize the computer
		computer = new Computer();
		//Set the player to null
		player = null;
		//Initialize the numberOfDrawsUser
		numberOfDrawsUser = new User("numberOfDraws");
		//Set the statsUpdated to false
		statsUpdated = false;
	}
	
	//Setter method for the game which is called whenever a new Game is made so that the currentGame is always set to the current game
	public void setGame(Game game)
	{
		currentGame = game;	
	}
	
	//Getter Method that returns the Player
	public User getPlayer()
	{
		return player;
	}
	
	//Getter method that returns the computer
	public Computer getComputer()
	{
		return computer;
	}
	
	//Setter method that sets the player
	public void setPlayer(User newPlayer)
	{
		player = newPlayer;
	}
	
	//Setter method that sets the player's piece
	public void setPlayerPiece(Shape givenShape)
	{
		player.setShape(givenShape);
	}
	
	//Setter method that sets the Computer's piece
	public void setComputerPiece(Shape givenShape)
	{
		computer.setShape(givenShape);
	}
	
	//Setter method that sets the current game
	public void setCurrentGame(Game givenGame)
	{
		currentGame = givenGame;
	}
	
	//getter method that returns the current game board
	public Board getBoard()
	{
		return currentGame.getBoard();
	}
	
	//Setter method that increments the game count by one
	public void setGameCount()
	{
		gameCount += 1;
	}
	
	//Getter method that returns the game count
	public int getGameCount()
	{
		return gameCount;
	}
	
	//Getter method that returns the "nobody" User who is used to count the number of draws
	public User getNumberOfDrawsUser()
	{
		return numberOfDrawsUser;
	}
	
	//Getter method that returns the statsUpdated boolean
	public boolean getStatsUpdated()
	{
		return statsUpdated;
	}
	
	//Setter method that sets the statsUpdated boolean to a passed boolean value
	public void setStatsUpdated(boolean passedBoolean)
	{
		statsUpdated = passedBoolean;
	}
}
