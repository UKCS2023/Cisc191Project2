package cisc191.sdmesa.edu;

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
 * 	This class is an abstract class that is extended for both the User and Computer classes
 * 	This class has a method that is used to return the number of wins
 * 	This class a method that is used to increment the player's wins by a given value
 * 	This class has a method to set the Shape of a player
 * 	This class has a method to get the Shape of a player
 * 	This class has an abstract method getName as well
 * 	Every player has a Shape and a number of wins
 * 	 
 */
 
public abstract class Player 
{	
	//Instance variables
	
	//Every Player has a Shape 
	//Ever Player has an integer to hold their number of wins
	private Shape playerShape;
	private int wins;
	
	//Method that returns win count of any player
	public int getWins() 
	{	
		return wins;	
	}
	
	//Method that increments player's wins by one
	public void setWins(int increment) 
	{	
		wins += increment;	
	}
	
	//Method that returns shape of the player
	public Shape getShape() 
	{	
		return playerShape;	
	}
	
	//Method that sets the shape of the player
	public void setShape(Shape newShape) 
	{	
		playerShape = newShape;	
	}
	
	//Abstract method
	
	//This method returns the name of the Player
	public abstract String getName();
}
