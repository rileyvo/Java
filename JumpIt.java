
package JumpItGame;

import java.io.*;
import java.util.*;

/**
 * The game of JumpIt which is to find the lowest cost of jumps or moves to get the the end
 * @version 18-11-2018
 * @author rileyvoigt
 *
 */
public class JumpIt {
	private String fileName;
	private static final int MAX_SIZE = 15;
	int[] row = new int[MAX_SIZE];
	private int count = 0;
	String error = "";
	
	/**
	 * adds all of the numbers from the file to an array for the game
	 * @param theName
	 * @throws FileNotFoundException
	 */
	public JumpIt(String theName) throws FileNotFoundException {
		this.fileName = new String(theName);
		System.out.println("Opening the file " + theName + "...");
		File file = new File(theName);
		Scanner s = new Scanner(file);
		Scanner in = new Scanner(file);
		
		int count = 0;
		
		while(in.hasNext()) {
			try {
				int temp = Integer.parseInt(in.next());
				
			} catch(NumberFormatException ex) {
				in.next();
				
			}
			count++;
		}
		while(in.hasNext()) {
			if(in.hasNextInt()) {
				
			} else {
				System.out.println("The file contains an invalid input " + in.next() + ", and that input will be ignored");
			}
		}


		if (count > 15) {
			System.out.println("This file has more than 15 integers");
			System.out.println("Only the first 15 integers are considered");
			count = 15;
			System.out.println("The file has " + count + " integers");
		} else {
			System.out.println("The file has " + count + " integers");
		}

		row = new int[count];
		int i = 0;
		do {
			try {
				row[i] = Integer.parseInt(s.next());
				i++;
			} catch (NumberFormatException ex) {
				error += "Invalid Input: " + ex.getMessage() + "\n";
			}
		} while (i < count);
		
		in.close();
		s.close();

	}
	/**
	 * checks to see if the first integer in the file is valid or not 
	 * must be 0
	 * @return play(Array, int, int)
	 * @throws BadInputException
	 */
	public int play() throws BadInputException {
		if (row[0] != 0) {
			throw new BadInputException();
		}
		return play(row, 0, count);

	}

	/**
	 * calculates recursively the lowest cost of the game
	 * @param row
	 * @param current
	 * @param total
	 * @return lowest cost
	 * @throws BadInputException
	 */
	public static int play(int[] row, int current, int total) throws BadInputException {

		total += row[current];

		// If board is at the last position, stop recursion and end the method
		if (current == row.length - 1)
			return total;
		// If the board is at the second to last posittion, method can only recur once
		// to reach the goal by move 1
		else if (current == row.length - 2)
			return play(row, current + 1, total);
		// For any oer location, decision can be split in two jump to next or jump two
		// to next to adjacent. For these paths They can also be divided and so on
		else {
			int path1 = play(row, current + 1, total);
			int path2 = play(row, current + 2, total);

			// Use math library to return minimum of the paths
			return Math.min(path1, path2);
		}

	}
	/**
	 * prints out the array to the screen for viewing 
	 * also prints out invalid inputs that were skipped
	 */
	public void printGame() {
		System.out.print(error);
		for (int i = 0; i < row.length; i++)
			System.out.print(row[i] + " ");
		System.out.println();

	}

	/**
	 * the class for the BadInputException used in play method
	 * @author rileyvoigt
	 *
	 */
	public class BadInputException extends Exception {
		public BadInputException() {
			super("The first int should be 0");
		}
		/**
		 * writes the message to the screen to tell the user 
		 * what went wrong
		 * @param message
		 */
		public BadInputException(String message) {
			super(message);
		}
	}
	
	

}
