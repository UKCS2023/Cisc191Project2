package cisc191.sdmesa.edu;

import java.awt.event.ActionEvent;
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
 *	This class implements the ActionListener interface to handle clicks on the exitGameButton
 *	This class has an instance variable for the view
 *	This class's constructor takes in a view and initializes the instance variable
 *	This class's actionPerformed method is called when the exitGameButton is clicked. It displays a message, closes the file used to store the stats, and exits the program
 * 
 */

//Every ExitGameButtonListener is an ActionListener
public class ExitGameButtonListener implements ActionListener
{
	//Instance variable
	
	//Every ExitGameButtonListener has a view
	private GameView view;
	
	//Constructor that takes in a view and initializes the instance variable
	public ExitGameButtonListener(GameView view)
	{
		this.view = view;
	}
	
	//@Override the actionPerformed method
	//This method displays a message, closes the file we were using to store the stats, and exits the program
	public void actionPerformed(ActionEvent e)
	{
		//Create an Option Pane with a message thanking the user
		JOptionPane.showMessageDialog(view,"Thanks For Playing!", "Message", JOptionPane.OK_OPTION);
		//Close the file used
		Game.closeFile();
		//Exit the program
		System.exit(0);
	}
}