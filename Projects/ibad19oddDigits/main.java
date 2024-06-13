// IBAD H
// Nov 21 2023
// 19 - Odd Digits

//package
package ibad19oddDigits;

//import Scanner for input
import java.util.Scanner;

//main class
public class main {

	// main method
	public static void main(String[] args) {
		// input variable
		Scanner in = new Scanner(System.in);

		// taking int input
		System.out.println("Please enter a number: ");
		int num = in.nextInt();

		// running function and outputting number of odd digits in inputted number
		System.out.println("The number of odd digits are: " + oddDigits(num));

	}

	// odd digits method takes int x and returns number of odd digits
	public static int oddDigits(int x) {

		// number of odd digits is initially 0
		int odds = 0;

		// if x isnt 0
		if (x != 0) {
			
			/*
			 * number of odds is set to the remainder of dividing x by 2, determining if the
			 * right most digit is odd or even (setting odds to 1 if its odd)
			 */
			odds = Math.abs(x % 2);

			/*
			 * running itself but with x / 10 (which basically takes away the right most
			 * digit) and adding its return to the odds variable
			 */
			odds += oddDigits(x / 10);
		}

		// returning number of odd digits
		return odds;

	}

	/*
	 * Basically the function checks whether the first digit is odd or even, adding
	 * 1 to the amount of odds if it is, and then recurses the same logic for every
	 * next digit until the last digit is divided by 10 which results in it running
	 * with a parameter of 0, thus breaking the loop.
	 */

}
