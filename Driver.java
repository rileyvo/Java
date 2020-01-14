package JumpItGame;


import java.io.FileNotFoundException;
import JumpItGame.JumpIt.BadInputException;
/**
 * the main method class that runs and calls all of the methods
 * in JumpIt class
 * @author rileyvoigt
 *
 */
public class Driver {
	
	/**
	 * making a new JumpIt with a file called numbers and try to play and if the 
	 * starting input is not valid will catch and tell the user
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		JumpIt game4 = new JumpIt("src/JumpItGame/numbers");
		game4.printGame();
		System.out.println("Start Playing...");
		try {
			System.out.println("the cost is " + game4.play());
			System.out.println("");
		} catch (BadInputException e) {
			System.out.println("bad input: the first int must be 0");
		}
	}
}