package cisc191.sdmesa.edu;

import java.awt.event.*;
import java.awt.event.ActionEvent; 

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
 * 	This class implements the ActionListener interface to handle clicks on the exitStatsButton
 *	This class has an instance variable for the view
 *	This class has a constructor that takes in a view and initializes the instance variable
 *	This class has an actionPerformed method that is called when the exitStatsButton is clicked. It updates the visibility of the panels
 * 
 */

//Every ExitStatsButtonListener is an ActionListener
public class ExitStatsButtonListener implements ActionListener
{
	//Instance variable
	
	//Every ExitStatsButtonListener has a view
	private GameView view;

	//Constructor that takes in a view and initializes the view instance variable
	public ExitStatsButtonListener(GameView view)
	{
		this.view = view;
	}
	
	//@Override the actionPerformed method
	//This method makes the menuPanel visible and the statsPanel invisible
	public void actionPerformed(ActionEvent e)
	{
		view.getMenuPanel().setVisible(true);
		view.getStatsPanel().setVisible(false);
	}
}
