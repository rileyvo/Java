package cp213;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Lab to test various exceptions.
 *
 * @author Masoomeh Rudafshani
 * @version 2018-10-12
 *
 */
public class Lab05 {
	
	public static void test_exceptions() {
		try {
		    // insert bad code here
		    int n = 0;
		    // ArithmeticException
		    n = 1 / 0;
		    System.out.println("n: " + n);
		    // NumberFormatException
		    n = Integer.parseInt("Schwarzenegger");
		    System.out.println("n: " + n);
		    // ArrayIndexOutOfBoundsException
		    final int[] values = new int[5];
		    values[6] = 0;
		    // NullPointerException
		    final String s = null;
		    final boolean result = s.equals("David");
		    System.out.println(result);
		    // IllegalStateException
		    final Scanner keyboard = new Scanner(System.in);
		    keyboard.close();
		    keyboard.next();
		    // FileNotFoundException
		    final Scanner file = new Scanner(new File("nonexistant.txt"));

		    while (file.hasNext()) {
			System.out.println(file.next());
		    }
		    file.close();

		} catch (final FileNotFoundException e) {
		    System.out.println(
			    "FileNotFoundException: file 'nonexistant.txt' does not exist");
		} catch (final IllegalStateException e) {
		    System.out.println(
			    "IllegalStateException: cannot use closed Scanner object");
		} catch (final NullPointerException e) {
		    System.out.println("NullPointerException: string cannot be null");
		} catch (final ArrayIndexOutOfBoundsException e) {
		    System.out.println(
			    "ArrayIndexOutOfBoundsException: index 6 is too large");
		} catch (final ArithmeticException e) {
		    System.out.println("ArithmeticException: Division by zero");
		} catch (final NumberFormatException e) {
		    System.out.println(
			    "NumberFormatException: Schwarzenegger is not a number");
		} catch (final Exception e) {
		    // generic exception/error catching
		    System.err.println("Caught Exception");
		    System.err.println("getMessage():" + e.getMessage());
		    System.err.println(
			    "getLocalizedMessage():" + e.getLocalizedMessage());
		    System.err.println("toString():" + e);
		    System.err.println("printStackTrace():");
		    e.printStackTrace();
		} finally {
		    // code to always be executed when try block ends
		    System.out.println();
		    System.out.println("End of program");
		}		
	}
	
	public static void test_badValueException( ) {
		 final int first = 1;
	        final int last = 100;
	        
	        Scanner keyboard = new Scanner(System.in);
	        int total = 0;

	        while( true ) {
	            System.out.print("Enter an integer from " + first + " to " + last + " (0 to stop): ");

	            try {
	                int x = keyboard.nextInt();

	                if( x == 0 ) {
	                    break;
	                } else if( x < first || x > last ) {
	                    // Explicitly throw an exception.
	                    throw new BadValueException( first, last );
	                } else {
	                    total += x;
	                }
	            } catch( BadValueException e ) {
	                System.err.println( e.toString() );
	            } catch( InputMismatchException e ) {
	                System.out.println("That is not an integer!");
	                keyboard.next(); // Get rid of offending value.
	            }
	        }
	        keyboard.close();
	        System.out.println("Total: " + total);
	}

    /**
     * @param args
     *            unused default parameter
     */
    public static void main(final String[] args) {

    	test_exceptions();
    	test_badValueException();
    }
}
