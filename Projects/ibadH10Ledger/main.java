//IBAD H
//Oct 19 2023
//Iterative Algorithms - Ledger

package ibadH10Ledger;

import java.util.Arrays;
import java.util.Scanner;

//main class to test ledgeer class
public class main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("Please enter the length of the Ledger (minimum 5)");

		// Ledger instance named x of length inputted by the user
		Ledger x = new Ledger(in.nextInt());

		if (x.getMaxSales() < 5) {
			x.setMaxSales(5);
			System.out.println("The inputted length is invalid so the Ledger" + " has been set to default length of 5");
		}

		/*
		 * iterating through array (but only filling 5 slots) and adding sales that are
		 * multiples of 2.5
		 */
		for (int i = 0; i < 5; i++) {
			x.addSale((i * 2.5) + 10);
		}

		/*
		 * checking sale adder limit with if shorthand to output success or failure to
		 * add the value
		 */
		System.out.println("Enter entry of amount 65... "
				+ ((x.addSale(65)) ? "New entry successfully added" : "No more slots available for requested entry."));

		/*
		 * printing all sales array, number of sales in array (10 in this case), sum of
		 * all sales, avg sale value, and amount of sales above 20
		 */
		System.out.println("\nLedger: " + Arrays.toString(x.getAllSales()));
		System.out.println("Sales made: " + x.getNumberOfSales());
		System.out.println("Total revenue" + x.getTotalSales());
		System.out.println("Average Sale value: " + x.getAvgSale());
		System.out.println("Sales above 20: " + x.getCountAbove(20));
	}

}
