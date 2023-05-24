package cisc191.sdmesa.edu;

public class GameModel 
{
	//Instance Variables
	
	//Every GameModel has a Board
	//Every GameModel has a Game
	//Every GameModel has a player
	//Every GameModel has a computer
	//Every GameModel has a gameCount
	//Every GameModel has a "nobody" User that is used to count the number of draws
	private Board currentBoard;
	private Game currentGame;
	private User player;
	private Computer computer;
	private int gameCount;
	private User nobody = new User("nobody", 0);
	
	//Constructor
	public GameModel()
	{
		computer = new Computer();
		player = null;
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
	
	//Getter method that return the game count
	public int getGameCount()
	{
		return gameCount;
	}
	
	//Getter method that returns the "nobody" User who is used to count the number of draws
	public User getNobody()
	{
		return nobody;
	}
}
