package cisc191.sdmesa.edu;

import javax.swing.JFrame; 
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

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
 * 	This class is used to create the view for the game
 * 	This class extends the JFrame class
 *	This class has several instance variables representing different panels and buttons that make up the user interface
 *	This class has an instance variable gameButtonArrayList that represents a list of game buttons
 *	This class has an instance variable model that represents the model of the game
 *	This class has a constructor that takes a GameModel argument and initializes the instance variables, sets up the panels and buttons, and adds them to the frame
 *	This class has several private methods that initialize and populate the different panels with their respective components
 *	This class has several getter methods to return the different panels and the list of game buttons
 * 
 */

//Every GameView is a JFrame
public class GameView extends JFrame
{
	//Instance Variables
	
	//Three main panels:
	//Every GameView has a menuPanel
	//Every GameView has a statsPanel
	//Every GameView has a gamePanel	
	private JPanel menuPanel;
	private JPanel statsPanel;
	private JPanel gamePanel;
	
	//Every GameView has a wordsPanel (panel that is on the statsPanel and is used to hold JLabels)
	private JPanel wordsPanel;
	
	//Every GameView has a playGameButton (button that is on the menuPanel and starts the game)
	private JButton playGameButton;
	
	//Every GameView has a displayStatsButton (button that is on the menuPanel and displays the statsPanel)
	private JButton displayStatsButton;
	
	//Every GameView has an exitGameButton (button on the menuPanel that closes the game)
	private JButton exitGameButton;
	
	//Every GameView has an exitStatsButton (button on the statsPanel that exits the statsPanel and displays the menuPanel)
	private JButton exitStatsButton;
	
	//Every GameView has a gameButtonArrayList (ArrayList of gameButton objects that is used to loop through them in a linear fashion in order to find a specific button)
	private ArrayList <GameButton> gameButtonArrayList;
	
	//Every GameView has a GameModel
	private GameModel model;
	
	//Constructor that takes in a model
	public GameView(GameModel model)
	{
		//Set the model instance variable equal to the passed model
		this.model = model;
		
		//Make sure the frame is closed when the X is pressed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		//Pack the JFrame
		pack();
		//Make the JFrame visible
		setVisible(true);
		//Set the title of the JFrame
		setTitle("Tic Tac Toe");
		//Set the layout of the JFrame to a CardLayout
		setLayout(new CardLayout());
		
		//Call private method to initialize menuPanel and add it to the frame
		makeMenuPanel();
		add(menuPanel);
		
		//Call private method to initialize gamePanel and add it to the frame
		makeGamePanel();
		add(gamePanel);
		
		//Call private method to initialize statsPanel and add it to the frame
		makeStatsPanel();
		add(statsPanel);
		
		//Make all the panels invisible except for the menuPanel
		menuPanel.setVisible(true);
		gamePanel.setVisible(false);
		statsPanel.setVisible(false);
	}
	
	//Private method that populates the menu JPanel with 3 buttons and a title at the top
	private void makeMenuPanel()
	{
		//Initialize the menuPanel
		menuPanel = new JPanel();
		//Set the layout to a BorderLayout
		menuPanel.setLayout(new BorderLayout());
		
		//Initialize the menuLabel
		JLabel menuLabel = new JLabel();
		//Set the text of the menuLabel
		menuLabel.setText("Tic Tac Toe");
		//Set the font of the menuLabel
		menuLabel.setFont(new Font("Times Roman", Font.BOLD, 24));
		//Center the text of the menuLabel
		menuLabel.setHorizontalAlignment(JLabel.CENTER);
		//Add the menuLabel to the top (north) of the menuPanel
		menuPanel.add(menuLabel, BorderLayout.NORTH);
		
		//Initialize the playGameButton as a new JButton
		playGameButton = new JButton();
		//Set the text of the playGameButton
		playGameButton.setText("Play Game");
		//Add a new PlayGameButtonListener ActionListener to the playGameButton
		playGameButton.addActionListener(new PlayGameButtonListener(this, model));
		
		//Initialize the displayStatsButton
		displayStatsButton = new JButton();
		//Set the text of the displayStatsButton
		displayStatsButton.setText("Display Stats");
		//Add a new DisplayStatsButtonLister ActionListener to the displayStatsButton
		displayStatsButton.addActionListener(new DisplayStatsButtonListener(this, model));
		
		//Initialize the exitGameButton
		exitGameButton = new JButton();
		//Set the text of the exitGameButton
		exitGameButton.setText("Exit");
		//Add a new ExitGameButtonListener ActionListener to the exitGameButton
		exitGameButton.addActionListener(new ExitGameButtonListener(this));
		
		//Initialize the menuButtonsPanel which is used to hold the different buttons
		JPanel menuButtonsPanel = new JPanel();
		//Set the layout of the menuButtonsPanel to be 3x1
		menuButtonsPanel.setLayout(new GridLayout(3,1));
		
		//Add the buttons to the menuButtonsPanel
		menuButtonsPanel.add(playGameButton);
		menuButtonsPanel.add(displayStatsButton);
		menuButtonsPanel.add(exitGameButton);
		
		//Add the menuButtonsPanel to the center of the menuPanel
		menuPanel.add(menuButtonsPanel, BorderLayout.CENTER);
	}
	
	//Private method that populates the gamePanel with a 3x3 grid of GameButton objects
	private void makeGamePanel()
	{
		//Initialize gamePanel
		gamePanel = new JPanel();
		//Set layout of gamePanel to be a 3x3 GridLayout
		gamePanel.setLayout(new GridLayout(3,3));
		//Initialize the gameButtonArrayList
		gameButtonArrayList = new ArrayList<GameButton>();
		
		//Loop through the gridPanel adding FishingButtons
		for (int j = 0; j < 3 ; j++)
		{
			for (int i = 0; i < 3; i ++)
			{
				//initialize a new GameButton with its position coordinates as arguments
				GameButton button = new GameButton(i, j);
				//Add the button to the gridLayout
				gamePanel.add(button);
				//Add an Action Listener to each button
				button.addActionListener(new GameButtonListener(this, model, button));
				
				//Add the GameButton to the gameButtonArrayList
				gameButtonArrayList.add(button);
			}
		}	
	}
	
	//Private method that populates the statsPanel with a wordsPanel of JLabels and an exit button
	private void makeStatsPanel()
	{
		//Initialize the statsPanel
		statsPanel = new JPanel();
		//Set the layout of the statsPanel to a BorderLayout
		statsPanel.setLayout(new BorderLayout());
		
		//Initialize the wordsPanel
		wordsPanel = new JPanel();
		//Set the layout of the wordsPanel to a FlowLayout
		wordsPanel.setLayout(new FlowLayout());
		
		//Initialize the exitStatsButton
		exitStatsButton = new JButton();
		//Set the text of the exitStatsButton
		exitStatsButton.setText("Back to Menu");

		//Add a new ExitStatsButtonListener ActionListener to the exitStatsButton
		exitStatsButton.addActionListener(new ExitStatsButtonListener(this));
		
		//Add the wordsPanel to the center of the statsPanel
		statsPanel.add(wordsPanel, BorderLayout.CENTER);
		//Add the exitsStatsButton to the bottom of the statsPanel
		statsPanel.add(exitStatsButton, BorderLayout.SOUTH);
	}
	
	//Getter methods
	
	//Return the menuPanel
	public JPanel getMenuPanel()
	{
		return menuPanel;
	}
	
	//Return the gamePanel
	public JPanel getGamePanel()
	{
		return gamePanel;
	}
	
	//Return the statsPanel
	public JPanel getStatsPanel()
	{
		return statsPanel;
	}
	
	//Return the wordsPanel
	public JPanel getWordsPanel()
	{
		return wordsPanel;
	}
	
	//Return the gameButtonArrayList
	public ArrayList<GameButton> getGameButtonArrayList()
	{
		return gameButtonArrayList;
	}
}