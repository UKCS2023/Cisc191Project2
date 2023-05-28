package cisc191.sdmesa.edu;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.*; 

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
 * 	This class implements the ActionListener interface to handle button clicks for the game
 *	This class has instance variables for the model, view, and button
 *	This class's constructor takes in a view, model, and button and initializes the instance variables
 *	This class's actionPerformed method is called when a GameButton is clicked. It updates the button’s state and prompts the computer to play its move. It also checks if the game is over and displays a message accordingly
 * 
 */

//Every GameButtonListener is an ActionListener
public class GameButtonListener implements ActionListener
{
	//Instance variables
	
	//Every GameButtonListener has a model
	private	GameModel model;
	//Every GameButtonListener has a view
	private GameView view;
	//Every GameButtonListener has a button
	private GameButton button;
	
	//Constructor that takes in a view, model, and a button and initializes the instance variables accordingly
	public GameButtonListener(GameView view, GameModel model, GameButton button)
	{
		this.view = view;
		this.model = model;
		this.button = button;
	}
	
	//@Override the actionPerformed method
	//This method is called when the user clicks on any GameButton object
	//It disables the button and updates its text and color
	//It also prompts the computer to play its move and updates the state of the button that the computer chose as well
	//It also checks, in between moves, if the game is over and displays a message that differs depending on which player won then calls the addStats method. It then displays the menuPanel and makes the gamePanel invisible
	public void actionPerformed(ActionEvent e)
	{
		//Initialize variables to hold the player and computer objects
		User player = model.getPlayer();
		Computer computer = model.getComputer();
		//Initialize variables to hold the player and computer Shapes
		Shape playerShape = player.getShape();
		Shape computerShape = computer.getShape();
		//Initialize variable to hold the gameBoard
		Board board = model.getBoard();
		
		//Initialize String to hold the message if the player wins
		String winningMessage =  "Game Over, " + player.getName() + " Wins!";
		
		//Disable the button so it cannot be clicked again
		button.setEnabled(false);
		//Change the color of the button to red
		button.setBackground(Color.RED);
		//Set the text of the button to the name of the Player's Shape
		button.setText(playerShape.getShapeName());
		//Change the used status of the button so that it can be reset before the next game
		button.changeUsedStatus();
		
		//Now place the place the Shape on the board in the same position that it is placed on the gamePanel by using the coordinates
		board.setShape(playerShape, button.getRow(), button.getColumn());
		
		//If the game is over (checked by calling the checkBoard method)
		if(board.checkBoard())
		{
			//If the game was a draw (checked by calling the checkIsDraw method)
			if (board.checkIsDraw())
			{
				//Display a message that tells the user that the game was a draw
				JOptionPane.showMessageDialog(view,"Draw Game!", "Message", JOptionPane.OK_OPTION);
				//Increment the wins for the numberOfDrawsUser down by 1 (the negative of the numberOfDrawsUser's wins is the number of draws total)
				model.getNumberOfDrawsUser().setWins(-1);
				//Call the public static method in the Game class that add the results of the game to the StatsFile
				Game.addStats(model.getNumberOfDrawsUser(), model.getGameCount());
			}
			//Else, (if the game is over after the player's turn but is not a draw meaning that the player won)
			else
			{
				//Display a message that tells the user that the player won the game using the message String we initialize earlier
				JOptionPane.showMessageDialog(view, winningMessage, "Message", JOptionPane.OK_OPTION);
				//Increment the player's wins by 1
				model.getPlayer().setWins(1);
				//Call the public static method in the Game class that add the results of the game to the StatsFile
				Game.addStats(model.getPlayer(), model.getGameCount());
			}
			
			//Now, since the game is over, make the menuPanel visible and the gamePanel invisible
			view.getMenuPanel().setVisible(true);
			view.getGamePanel().setVisible(false);
		}
		
		//Else, (if the game is not over after the player's turn)
		else
		{
			//Have the computer play its move by calling the playMove method and passing it the board object
			computer.playMove(board);
			//Declare the computerButton GameButton object that will be later set to the button on the board that corresponds to the square that the computer chose, and set it to null
			GameButton computerButton = null;
			
			//Now loop through the gameButtonArrayList until the row and column of the GameButton in the list equal the row and column that the computer chose and set the computerButton equal to that GameButton
			for (int i = 0; i < view.getGameButtonArrayList().size() ; i ++)
			{
				//If the first index of the answerCoordinates is the same as the row of a particular GameButton and the second index of the answerCoordinates is the same as the column of the GameButton object, set the computerButton to the GameButton
				if (computer.getAnswerCoordinates()[0] == view.getGameButtonArrayList().get(i).getRow() && computer.getAnswerCoordinates()[1] == view.getGameButtonArrayList().get(i).getColumn())
				{
					computerButton = view.getGameButtonArrayList().get(i);
				}
			}
			
			//Now disable the computer's chosen button
			computerButton.setEnabled(false);
			//Set the text color to cyan
			computerButton.setBackground(Color.CYAN);
			//Set the text to the name of the computer's Shape
			computerButton.setText(computerShape.getShapeName());
			//Change the used status of the button so that it can be reset before the next game
			computerButton.changeUsedStatus();
			
			//If the game is over (checked by calling the checkBoard method)
			if(board.checkBoard())
			{
				//If the game was a draw (checked by calling the checkIsDraw method)
				if (board.checkIsDraw())
				{
					//Display a message that tells the user that the game was a draw
					JOptionPane.showMessageDialog(view,"Draw Game!", "Message", JOptionPane.OK_OPTION);
					//Increment the wins for the numberOfDrawsUser down by 1 (the negative of the numberOfDrawsUser's wins is the number of draws total)
					model.getNumberOfDrawsUser().setWins(-1);
					//Call the public static method in the Game class that add the results of the game to the StatsFile
					Game.addStats(model.getNumberOfDrawsUser(), model.getGameCount());
				}
				//Else, (if the game is over after the computer's turn but is not a draw meaning that the computer won)
				else
				{
					//Display a message that tells the user that the computer won the game
					JOptionPane.showMessageDialog(view,"Game Over, Computer Wins!", "Message", JOptionPane.OK_OPTION);
					//Increment the computer's wins by 1
					computer.setWins(1);
					//Call the public static method in the Game class that add the results of the game to the StatsFile
					Game.addStats(computer, model.getGameCount());
				}
				
				//Now, since the game is over, make the menuPanel visible and the gamePanel invisible
				view.getMenuPanel().setVisible(true);
				view.getGamePanel().setVisible(false);
			}
		}
	}
}
