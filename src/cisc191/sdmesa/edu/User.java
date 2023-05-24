package cisc191.sdmesa.edu;

//Import the Scanner class
import java.util.Scanner;

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
 * https://www.geeksforgeeks.org/gfact-51-java-scanner-nextchar/#.
 * 
 * (No Listed Publisher)
 * "File Input and Output." Department of Computer Science. Accessed May 8, 2023.
 * https://www.cs.utexas.edu/~mitra/csSummer2009/cs303/lectures/fileIO.
 *  
 * Version/date: 
 * 
 */

//Every user is a player that implements the Placeable interface
public class User extends Player
{
	
	//Instance variable
	//Every User has a name
	private String name; 
	
	//Constructor
	public User() 
	{	
		setWins(0);
		setShape(null);
		name = null;	
	}
	
	//Constructor
	public User(String userName, int playerWins) 
	{		
		setWins(playerWins);
		setShape(null);
		name = userName;		
	}

	//Method that sets the name of the user
	public void setName(String newName) 
	{	
		name = newName;	
	}
	
	//Method that gets the name of the user
	public String getName() 
	{	
		return name;	
	}

}
