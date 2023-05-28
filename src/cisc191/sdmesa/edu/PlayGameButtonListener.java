package cisc191.sdmesa.edu;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.*;

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
 * 	This class implements the ActionListener interface to handle clicks on the playGameButton
 *	This class has instance variables for the model and view
 *	This class's constructor takes in a view and model and initializes the instance variables
 *	This class's actionPerformed method is called when the playGameButton is clicked. It initializes a new Game object, resets all the GameButtons used in the last game, and prompts the user to enter their name if the player is not yet initialized. It also sets the player and computer’s pieces and updates the visibility of the panels. It also calls the returnLastGameResults method to add a new JLabel to the wordsPanel if the stats have not yet been updated
 * 
 */

//EveryPlayGameButtonListener is an ActionListener
public class PlayGameButtonListener implements ActionListener
{
	//Instance variables
	
	//Every PlayGameButtonListener has a model
	private	GameModel model;
	//Every PlayGameButtonListener has a view
	private GameView view;
	
	//Constructor that takes in a view and a model and initializes the instance variables accordingly
	public PlayGameButtonListener(GameView view, GameModel model)
	{
		this.view = view;
		this.model = model;
	}
	
	//@Override the actionPerformed method
	//This method is called when the user clicks on the playGameButton
	//It initializes a new Game object and resets all the GameButtons used in the last game
	//If the model's player is not yet initialized, it prompts the user to enter their name and creates a new User object using their name
	//This method also sets both the player and computer's pieces
	//This method also calls the returnLastGameResults method to add a new JLabel to the wordsPanel if the stats have not yet been updated
	//This method also sets the visibility so that the user can see the gamePanel
	public void actionPerformed(ActionEvent e)
	{
		//Initializes a new Game
		Game currentGame = new Game();
		
		//Sets the current game of the model to the currentGame we just initialized
		model.setCurrentGame(currentGame);
		
		//Now loop through the entire gameButtonArrayList utilizing the getUsedStatus method on every GameButton to check if they were used in the previous game. If they were, call the resetButton method to reset them
		for (int i = 0; i < 9; i ++)
		{
			//utilize the getUsedStatus method on every GameButton to check if they were used in the previous game
			if(view.getGameButtonArrayList().get(i).getUsedStatus())
			{
				//If the GameButton is found to be used, reset it
				view.getGameButtonArrayList().get(i).resetButton();
			}
		}
		
		//Make menuPanel invisible and make the gamePanel visible
		view.getMenuPanel().setVisible(false);
		view.getGamePanel().setVisible(true);
		
		//If the model's player is found to be null (not initialized yet), prompt the user to create a new User object by entering their name
		if (model.getPlayer() == null)
		{
			//Display an option pane which takes in a String input and sets that String equal to the player's choice. The String is set to "Player" by default
			//Initialize a String to the input from this optionPane
			String userName = JOptionPane.showInputDialog("Please Enter Your Name (Name is set to 'Player' by default)", "Player");
			
			//Now set the model's player to a new User object with the userName sent as the argument
			model.setPlayer(new User(userName));
		}
		
		//Set the player's piece to be X, and the computer's piece to be O
		model.setPlayerPiece(new Shape("X"));
		model.setComputerPiece(new Shape("O"));
		
		//If the model's stats have not been updated yet, update them. Also make sure that at least one game has been played, since this prevents the program from trying to access an empty File
		if(!model.getStatsUpdated() && model.getGameCount() > 0)
		{
			//Initialize a new String that holds the most recent line added to the StatsFile. Get this line by using the displayStats method
			String lastLine = Game.returnLastGameResults(model.getGameCount() - 1);
			//Initialize a new JLabel with the lastLine String
            JLabel label = new JLabel(lastLine);
            //Add the the label to the wordsPanel
            view.getWordsPanel().add(label);
		}
		
		//Set the statsUpdated to false
		model.setStatsUpdated(false);
		
		//Call the method to increment the game counter by 1
		model.setGameCount();
	}
}
