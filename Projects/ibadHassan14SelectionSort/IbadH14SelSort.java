// Ibad H.
// Oct 27 2023
// Selection Sort

package ibadHassan14SelectionSort;

//importing arrays module
import java.util.Arrays;

//main class
public class IbadH14SelSort {

	// main method
	public static void main(String[] args) {

		// creating test integer and double arrays, the double array is an array of coin
		// values
		int ints[] = { 5, 7, 18, 13, 4, 2, 9, 20, 14, 1 };
		double coins[] = { 5.65, 7.34, 18.54, 13.43, 3.23, 1.23, 9.00, 20.99, 14.32, 1.09 };

		// running sorts for both
		ints = intSort(ints);
		coins = doubleSort(coins);

		// printing both arrays
		System.out.println(Arrays.toString(ints));
		System.out.println(Arrays.toString(coins));

	}

	// integer sort
	public static int[] intSort(int[] x) {
		// iterating through array
		for (int i = 0; i < x.length; i++) {
			// setting current iteration of the array element to the base max value
			int maxInd = i;
			// iterating through the remaining array to find a higher value
			for (int j = i + 1; j < x.length; j++) {
				if (x[maxInd] < x[j]) {
					maxInd = j;
				}
			}

			// setting the max to a temp placeholder (taking it out of the array)
			int temp = x[maxInd];
			// setting the original slot element to max (moving it to the empty slot)
			x[maxInd] = x[i];
			// replacing that new slot with the higher value
			x[i] = temp;

			/*
			 * basically the sort will start at the first element of the array, and go
			 * through the rest to find a higher value meaning it'll find the max value on
			 * the first cycle. Then it will take that max value and the original value and
			 * swap their positions. This'll repeat with every slot in the array until the
			 * end of the loop. if you have an array [2, 6, 3, 1] - 2 gets swapped with 6,
			 * then the 2 (in the second slot) gets swapped with 3, and now the last 2
			 * values already sorted so the program is finished.
			 */

		}

		return x;
	}

	// double sort
	public static double[] doubleSort(double[] x) {
		// iterating through array
		for (int i = 0; i < x.length; i++) {
			// setting current iteration of the array element to the base max value
			int maxInd = i;
			// iterating through the remaining array to find a higher value
			for (int j = i + 1; j < x.length; j++) {
				if (x[maxInd] < x[j]) {
					maxInd = j;
				}
			}

			// setting the max to a temp placeholder (taking it out of the array)
			double temp = x[maxInd];
			// setting the original slot element to max (moving it to the empty slot)
			x[maxInd] = x[i];
			// replacing that new slot with the higher value
			x[i] = temp;
		}

		return x;
	}
}