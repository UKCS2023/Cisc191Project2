package cisc191.sdmesa.edu;

import javax.swing.JButton;

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
 * 	Every GameButton extends JButton and therefore is a JButton
 * 	This class has a constructor that takes in a row and column and initializes the instance variables
 * 	This class also has a boolean to hold whether the button was used in the previous game
 * 	This class has method to return the row and column of the button
 * 	This class also has methods to change and return the usedStatus
 * 	This class also has a method to reset the button 
 * 	 
 * 
 */

//Every GameButton is a button
public class GameButton extends JButton
{
	//Instance variables
	
	//Every GameButton has a Row
	private int buttonRow;
	//Every GameButton has a column
	private int buttonColumn;
	//Every GameButton has a boolean that is used to check whether or not that specific button was used in the last game
	private boolean usedInLastGame;
	
	//Constructor that takes in a row and column
	public GameButton(int row, int column)
	{
		//Initialize the buttonRow and buttonColumn instance variables with the given values
		buttonRow = row;
		buttonColumn = column;
		//Set the usedInLastGame to false
		usedInLastGame = false;
		//Set the text of the button
		setText("[]");
	}
	
	//Method that returns the row of the button
	public int getRow()
	{
		return buttonRow;
	}
	
	//Method that returns the column of the button
	public int getColumn()
	{
		return buttonColumn;
	}
	
	//Method that returns the usedInLastGame boolean of the button
	public boolean getUsedStatus()
	{
		return usedInLastGame;
	}
	
	//Method that sets the usedInLastGame boolean to true
	public void changeUsedStatus()
	{
		usedInLastGame = true;
	}
	
	//Method that "resets" the button (puts it in the same state that it started in)
	public void resetButton()
	{
		//Sets the text of the button
		setText("[]");
		//Removes the background color of the button
		setBackground(null);
		//Sets the button to enabled
		setEnabled(true);
		//Changes the boolean value of usedInLastGame
		usedInLastGame = false;
	}
}
