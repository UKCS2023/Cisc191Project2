package cisc191.sdmesa.edu;

import javax.swing.JButton;
import java.awt.*; 

public class GameButton extends JButton
{
	//Instance variables
	
	//Every FishingButton has a Row
	//Every FishingButton has a column
	private int buttonRow;
	private int buttonColumn;
	private boolean usedInLastGame;
	
	//Constructor
	public GameButton(int row, int column)
	{
		buttonRow = row;
		buttonColumn = column;
		usedInLastGame = false;
		setText("[]");
	}
	
	public int getRow()
	{
		return buttonRow;
	}
	
	public int getColumn()
	{
		return buttonColumn;
	}
	
	public boolean getUsedStatus()
	{
		return usedInLastGame;
	}
	
	public void changeUsedStatus()
	{
		usedInLastGame = true;
	}
	
	public void resetButton()
	{
		setText("[]");
		setBackground(null);
		setEnabled(true);
		usedInLastGame = false;
	}
}
