//IBAD H.
//October 23 2023
// 13 Arraylists Program

//main package
package ibadHassan13ArraylistsProgram;

//importing arraylist class and Scanner class
import java.util.ArrayList;
import java.util.Scanner;

//main class
public class main {

	// main method
	public static void main(String[] args) {

		// main array list of integer values
		ArrayList<Integer> x = new ArrayList<Integer>();
		//creating input variabel
		Scanner in = new Scanner(System.in);
		
		//getting 5 array values from user
		System.out.println("Please enter 5 values for the graph");
		for(int i = 0; i < 5; i++) {
			x.add(in.nextInt());
		}
		

		// getting max value
		int max = 0;
		for (int i : x) {

			// if its the first value then set max to i
			if (x.indexOf(i) == 0) {
				max = i;
				// if i is greater than max then set new max to the current element
			} else if (i > max) {
				max = i;
			}

		}

		// print out array
		System.out.println(x);

		// bar graph printer
		for (int i : x) {

			// get amount of asterix for each element relative to the largest element which
			// has 40 asterix
			int amt = (int)(Math.round(((double) i / (double) max) * 40));

			// print out the amt of asterix for each element
			for (int j = 1; j <= amt; j++) {
				System.out.print("*");
			}

			// create new line for next bar
			System.out.print("\n");

		}

	}

}
