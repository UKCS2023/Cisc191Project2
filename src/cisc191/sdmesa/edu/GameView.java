package cisc191.sdmesa.edu;

import javax.swing.JFrame;  
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Every GameView is a JFrame
public class GameView extends JFrame
{
	//Instance Variables
	
	//Every GameView has a menuPanel
	//Every GameView has a statsPanel
	//Every GameView has a gamePanel
	
	//Uses https://www.geeksforgeeks.org/java-awt-cardlayout-class/
	
	private JPanel menuPanel;
	private JPanel statsPanel;
	private JPanel gamePanel;
	private JPanel wordsPanel;
	
	private JButton gameButton;
	private JButton statsButton;
	private JButton exitButton;
	
	private JButton exitStatsButton;
	
	private GameButton [] gameButtonArray;
	
	//Every GameView has a GameModel
	private GameModel model;
	


	//Constructor
	public GameView(GameModel model)
	{
		this.model = model;
		
		//Pack the JFrame
		pack();
		//Make the JFrame visible
		setVisible(true);
		//Set the title of the JFrame
		setTitle("Tic Tac Toe");
		//Set the layout to a CardLayout
		setLayout(new CardLayout());
		
		//Call private method to make gamePanel and add it to the frame
		makeGamePanel();
		add(gamePanel);
		
		//Call private method to make menuPanel and add it to the frame
		makeMenuPanel();
		add(menuPanel);
		
		//Call private method to make statsPanel and add it to the frame
		makeStatsPanel();
		add(statsPanel);
		
		//Make all the panels invisible except for the menu
		menuPanel.setVisible(true);
		gamePanel.setVisible(false);
		statsPanel.setVisible(false);
	}
	
	//Private method that populates the menu JPanel with 3 buttons and a title at the top
	private void makeMenuPanel()
	{
		menuPanel = new JPanel();
		menuPanel.setLayout(new BorderLayout());
		gamePanel.setBackground(Color.WHITE);
		
		JLabel label = new JLabel();
		label.setText("Tic Tac Toe");
		label.setFont(new Font("Times Roman", Font.BOLD, 24));
		label.setHorizontalAlignment(JLabel.CENTER);
		menuPanel.add(label, BorderLayout.NORTH);
		
		MenuButtonListener listener = new MenuButtonListener(this, model);
		
		gameButton = new JButton();
		gameButton.setText("Play Game");
		gameButton.addActionListener(listener);
		
		statsButton = new JButton();
		statsButton.setText("Display Stats");
		statsButton.addActionListener(listener);
		
		exitButton = new JButton();
		exitButton.setText("Exit");
		exitButton.addActionListener(listener);
		
		JPanel menuButtonsPanel = new JPanel();
		menuButtonsPanel.setLayout(new GridLayout(3,1));
		
		menuButtonsPanel.add(gameButton);
		menuButtonsPanel.add(statsButton);
		menuButtonsPanel.add(exitButton);
		
		menuPanel.add(menuButtonsPanel, BorderLayout.CENTER);
	}
	
	private void makeGamePanel()
	{
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3,3));
		gameButtonArray = new GameButton [9];
		int k = 0;
		
		//Loop through the gridPanel adding FishingButtons
		for (int j = 0; j < 3 ; j++)
		{
			for (int i = 0; i < 3; i ++)
			{
				//Create a new FishingButton with it's position and text that should be displayed as arguments
				GameButton button = new GameButton(i, j);
				//Add the button to the gridLayout
				gamePanel.add(button);
				//Add an Action Listener to each button
				button.addActionListener(new GameButtonListener(this, model, button));
				
				gameButtonArray[k] = button;
				k++;
			}
		}
		
	}
	
	private void makeStatsPanel()
	{
		statsPanel = new JPanel();
		statsPanel.setLayout(new BorderLayout());
		wordsPanel = new JPanel();
		
		wordsPanel.setLayout(new FlowLayout());
		exitStatsButton = new JButton();
		
		exitStatsButton.addActionListener(new MenuButtonListener(this, model));
		
		statsPanel.add(wordsPanel, BorderLayout.CENTER);
		statsPanel.add(exitStatsButton, BorderLayout.SOUTH);
		exitStatsButton.setText("Back to Menu");
	}
	
	protected JButton getGameButton ()
	{
		return gameButton;
	}
	
	protected JButton getExitButton ()
	{
		return exitButton;
	}
	
	protected JButton getStatsButton ()
	{
		return statsButton;
	}
	
	protected JButton getExitStatsButton ()
	{
		return exitStatsButton;
	}
	
	protected JPanel getMenuPanel()
	{
		return menuPanel;
	}
	
	protected JPanel getGamePanel()
	{
		return gamePanel;
	}
	
	protected JPanel getStatsPanel()
	{
		return statsPanel;
	}
	
	protected GameButton[] getGameButtonArray()
	{
		return gameButtonArray;
	}
	
	protected JPanel getWordsPanel()
	{
		return wordsPanel;
	}
	
}
