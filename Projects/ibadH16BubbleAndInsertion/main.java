//IBAD H
//1.11.2023
//Insertion and Bubble Sort

package ibadH16BubbleAndInsertion;

import java.util.Arrays;
import java.util.Scanner;

//main class
public class main {

	// bubble sort method
	public static double[] bubble(double[] x) {

		// iterating backwards through the array 1 less times than the amount of
		// elements in the array
		for (int i = x.length - 1; i > 0; i--) {

			// iterating forward until the value of i is reached
			for (int j = 0; j < i; j++) {

				// setting current min index to j
				double min = j;
				if (x[j + 1] < x[j]) {
					// if the array element next to the one at j is smaller, then swap the 2
					min = x[j + 1];
					x[j + 1] = x[j];
					x[j] = min;
				}

			}

			/*
			 * Basically everytime the inner loop finishes iterating through the array the
			 * max value of the array will be at the end, that is why the outer loop
			 * decreases in value because the max value has been sorted to the last position
			 * therefore the inner loop doesn't need to iterate to that point anymore. This
			 * cycle continues until the next value is position in its respecitve slot until
			 * the outer loop reaches a value where the inner loop only looks at the first 2
			 * values, sorting the final 2 unsorted elements in the array
			 */

		}

		// returning the sorted array
		return x;

	}

	public static double[] insertion(double[] x) {

		// outer loop iterating through the array downwards
		for (int i = x.length; i > 0; i--) {

			// inner loop
			for (int j = 1; j < i; j++) {

				// setting assumed minimum to index of j
				double min = j;

				// if the element next to index j is bigger than swap the 2 elements
				if (x[j - 1] > x[j]) {
					min = x[j - 1];
					x[j - 1] = x[j];
					x[j] = min;
				}

			}

		}

		/*
		 * Insertion sort essentiall works the same way as Bubble Sort but in the
		 * opposite direction so the array will start at the second index and check the
		 * element left of it and sort the 2, this will continue through the array once
		 * meaning at the end of the first iteration of the outer loop, the maximum
		 * value will be in the correct location. This process continues with the outer
		 * loop iterating to one index less since the max values in the indexes beyond
		 * that already are sorted.
		 */

		//return the sorted array
		return x;

	}

	// main test method
	public static void main(String[] args) {
		
		//array for a temperature for everyday of the week and scanner input variable
		double[] temps = new double[7];
		Scanner in = new Scanner(System.in);

		//take 7 temp inputs
		System.out.println("Please enter the temperature values for the week: ");

		//make array with inputs
		for (int i = 0; i < temps.length; i++) {
			temps[i] = in.nextDouble();
		}

		//sort using both types of sorts
		System.out.println("Bubble Sort: " + Arrays.toString(bubble(temps)));
		System.out.println("Insertion Sort: " + Arrays.toString(insertion(temps)));
	}

}
