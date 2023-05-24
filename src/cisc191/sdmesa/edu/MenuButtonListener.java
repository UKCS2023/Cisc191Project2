package cisc191.sdmesa.edu;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionEvent; 


public class MenuButtonListener implements ActionListener
{
	private	GameModel model;
	private GameView view;
	private boolean statsUpdated = false;
	
	public MenuButtonListener(GameView view, GameModel model)
	{
		this.view = view;
		this.model = model;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == view.getGameButton())
		{
			Game currentGame = new Game(model.getPlayer(), model.getComputer());
			
			model.setCurrentGame(currentGame);
			
			for (int i = 0; i < 9; i ++)
			{
				if(view.getGameButtonArray()[i].getUsedStatus())
				{
					view.getGameButtonArray()[i].resetButton();
				}
			}
			
			view.getStatsPanel().setVisible(false);
			view.getMenuPanel().setVisible(false);
			view.getGamePanel().setVisible(true);
			
			if (model.getPlayer() == null)
			{
				String userName = "Player";
				userName = JOptionPane.showInputDialog("Please Enter Your Name (Name is set to 'Player' by default)", "Player");
				
				model.setPlayer(new User(userName, 0));
			}
			
			model.setPlayerPiece(new Shape("X"));
			model.setComputerPiece(new Shape("O"));
			
			model.setGameCount();
			
			if(!statsUpdated)
			{
				String lastLine = Game.displayStats(model.getGameCount() - 1);
	            JLabel label = new JLabel(lastLine);
	            view.getWordsPanel().add(label);
	            statsUpdated = true;
			}
			
			statsUpdated = false;

		}		
		else if(e.getSource() == view.getStatsButton())
		{
			if(!statsUpdated)
			{
				String lastLine = Game.displayStats(model.getGameCount() - 1);
	            JLabel label = new JLabel(lastLine);
	            view.getWordsPanel().add(label);
	            statsUpdated = true;
			}
			
			view.getGamePanel().setVisible(false);
			view.getMenuPanel().setVisible(false);
			view.getStatsPanel().setVisible(true);
		}	
		else if(e.getSource() == view.getExitStatsButton())
		{
			view.getGamePanel().setVisible(false);
			view.getMenuPanel().setVisible(true);
			view.getStatsPanel().setVisible(false);
		}
		else
		{
			//Create an Option Pane with a message thanking the user
			JOptionPane.showMessageDialog(view,"Thanks For Playing!", "Message", JOptionPane.OK_OPTION);
			//Close the files used
			Game.closeFile();
			//Exit the program
			System.exit(0);
		}
	}
}
