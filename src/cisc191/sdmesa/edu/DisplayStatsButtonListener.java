package cisc191.sdmesa.edu;

import java.awt.event.ActionEvent;
import javax.swing.JLabel;
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
 * 	This class implements the ActionListener interface to handle clicks on the displayStatsButton
 *	This class has instance variables for the model and view
 *	This class's constructor takes in a view and model and initializes the instance variables
 *	This class has an actionPerformed method that is called when the displayStatsButton is clicked. It calls the displayStats method to add a new JLabel to the wordsPanel if the stats have not yet been updated and updates the visibility of the panels
 * 
 */

//Every DisplayStatsButtonListener is an ActionListener
public class DisplayStatsButtonListener implements ActionListener
{
	//Instance variables
	
	//Every PlayGameButtonListener has a model
	private	GameModel model;
	//Every PlayGameButtonListener has a view
	private GameView view;
	
	//Constructor that takes in a view and a model and initializes the instance variables accordingly
	public DisplayStatsButtonListener(GameView view, GameModel model)
	{
		this.view = view;
		this.model = model;
	}
	
	//@Override the actionPerformed method
	//This method calls the displayStats method to add a new JLabel to the wordsPanel if the stats have not yet been updated
	//This method makes the menuPanel invisible and the statsPanel visible
	public void actionPerformed(ActionEvent e)
	{
		//If the model's stats have not been updated yet, update them. Also make sure that at least one game has been played, since this prevents the program from trying to access an empty File
		if(!model.getStatsUpdated() && model.getGameCount() > 0)
		{
			//Initialize a new String that holds the most recent line added to the StatsFile. Get this line by using the displayStats method
			String lastLine = Game.returnLastGameResults(model.getGameCount() - 1);
			//Initialize a new JLabel with the lastLine String
            JLabel label = new JLabel(lastLine);
            //Add the the label to the wordsPanel
            view.getWordsPanel().add(label);
            //Set the statsUpdated boolean to true
            model.setStatsUpdated(true);
		}

		//Make the menuPanel invisible and make the statsPanel visible
		view.getMenuPanel().setVisible(false);
		view.getStatsPanel().setVisible(true);
	}
}