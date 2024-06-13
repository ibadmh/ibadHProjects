//IBAD H.
//Nov 21 2023
//20 - Sum of Digits
package ibad20SumDigits;

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

		System.out.println("The summ of all digits is " + sum(num));
	}

	// sum function returns int and takes int
	public static int sum(int x) {

		// starting total is 0
		int total = 0;

		// if x is greater than 0
		if (x > 0) {

			// add the first digit of the number to the total by taking it through taking
			// the remainder of x / 10
			total = x % 10;

			// running itself with x / 10 (basically removing the first digit) and adding
			// the return to the total
			total += sum(x / 10);
		}

		// returning the total sum
		return total;

	}

	/*
	 * Basically the function takes a number, taking out the first digit and adding
	 * it to the total using the % operator and then running itself but without the
	 * digit it just added. This makes it so it adds the first digit and then
	 * recurses to add every next digit until it reaches the final digit where it
	 * runs itself with that number / 10 which is 0 and therefore exits the loop
	 */

}
