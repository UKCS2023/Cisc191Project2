package cisc191.sdmesa.edu;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.*;
import java.awt.*; 

public class GameButtonListener implements ActionListener
{
	private	GameModel model;
	private GameView view;
	private GameButton button;
	
	public GameButtonListener(GameView view, GameModel model, GameButton button)
	{
		this.view = view;
		this.model = model;
		this.button = button;
	}
	
	public void actionPerformed(ActionEvent e)
	{
		Shape playerShape = model.getPlayer().getShape();
		Shape computerShape = model.getComputer().getShape();
		String winningMessage =  "Game Over, " + model.getPlayer().getName() + " Wins!";
		
		button.setEnabled(false);
		button.setBackground(Color.RED);
		button.setText(playerShape.getShapeName());
		button.changeUsedStatus();

		model.getBoard().setShape(playerShape, button.getRow(), button.getColumn());
		
		if(model.getBoard().checkBoard())
		{
			if (model.getBoard().checkIsDraw())
			{
				JOptionPane.showMessageDialog(view,"Draw Game!", "Message", JOptionPane.OK_OPTION);
				model.getNobody().setWins(-1);
				Game.addStats(model.getNobody(), model.getGameCount());
			}
			else
			{
				JOptionPane.showMessageDialog(view, winningMessage, "Message", JOptionPane.OK_OPTION);
				model.getPlayer().setWins(1);
				Game.addStats(model.getPlayer(), model.getGameCount());
			}
			
			view.getMenuPanel().setVisible(true);
			view.getGamePanel().setVisible(false);
		}
		
		else
		{
			model.getComputer().playMove(model.getBoard());
			GameButton computerButton = null;
			
				for (int i = 0; i < 9; i ++)
				{
					if (model.getComputer().getAnswerCoordinates()[0] == view.getGameButtonArray()[i].getRow() && model.getComputer().getAnswerCoordinates()[1] == view.getGameButtonArray()[i].getColumn())
					{
						computerButton = view.getGameButtonArray()[i];
					}
				}
				
				computerButton.setEnabled(false);
				computerButton.setBackground(Color.CYAN);
				computerButton.setText(computerShape.getShapeName());
				computerButton.changeUsedStatus();
				
			
			if(model.getBoard().checkBoard())
			{
				if (model.getBoard().checkIsDraw())
				{
					JOptionPane.showMessageDialog(view,"Draw Game!", "Message", JOptionPane.OK_OPTION);
					model.getNobody().setWins(-1);
					Game.addStats(model.getNobody(), model.getGameCount());
				}
				else
				{
					JOptionPane.showMessageDialog(view,"Game Over, Computer Wins!", "Message", JOptionPane.OK_OPTION);
					model.getComputer().setWins(1);
					Game.addStats(model.getComputer(), model.getGameCount());
				}
				
				view.getMenuPanel().setVisible(true);
				view.getGamePanel().setVisible(false);
			}
		}
	}
}
