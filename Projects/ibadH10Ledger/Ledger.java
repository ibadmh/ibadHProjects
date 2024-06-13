//IBAD H
//Oct 19 2023
//Iterative Algorithms - Ledger

package ibadH10Ledger;

//ledger class
public class Ledger {

	// sales list array, amount of sales made (amount of values in the array that
	// aren't 0), maxSales (length of array)
	private double sale[];
	private int salesMade;
	private int maxSales;

	// ledger overloader allowing user to set array length upon instantiation
	Ledger(int max) {
		this.setMaxSales(max);
	}

	// number of sales method:
	public int getNumberOfSales() {
		/*
		 * cycles through array, setting no. of sales to the index when that slot in the
		 * array is 0, so when it reaches an empty slot, it counts all the slots up to
		 * that which is equal to the index of the array except for if its the last
		 * slot, because then its read the whole array therefore outputting the array
		 * length as the number of sales
		 */
		for (int i = 0; i < this.getMaxSales(); i++) {
			if (this.getSale(i) == 0) {
				this.setSalesMade(i);
				i = this.getMaxSales();
			} else {
				this.setSalesMade(i + 1);
			}
		}

		// returns the amt of sales made after iteration
		return this.salesMade;

	}

	// amt of sales setter
	public void setSalesMade(int salesMade) {
		this.salesMade = salesMade;
	}

	/*
	 * add sale method searches through array for an empty slot and adds the
	 * parameter value to that slot, if no empty slot is found then the method
	 * returns false, if not then it returns true
	 */
	public boolean addSale(double d) {
		for (int i = 0; i < this.getMaxSales(); i++) {
			if (this.getSale(i) == 0) {
				this.sale[i] = d;
				i = this.getMaxSales();
				return true;
			}

			if ((i + 1) == this.getMaxSales() && this.getSale(i) != 0) {
				return false;
			}
		}

		return true;

	}

	// maxSales getter
	public int getMaxSales() {
		return maxSales;
	}

	// maxSales setter also defines sale array as a double array of length
	// "maxSales"
	public void setMaxSales(int maxSales) {
		this.maxSales = maxSales;
		this.sale = new double[maxSales];
	}

	// sale array element getters (returns specified element)
	public double getSale(int i) {
		return sale[i];
	}

	// sale array getter (returns all elements)
	public double[] getAllSales() {
		return sale;
	}

	/*
	 * total sales method iterates through the array adding each element to a total
	 * and returns the total in the end
	 */
	public double getTotalSales() {
		double total = 0;
		for (double i : this.getAllSales()) {
			total += i;
			if (i == 0) {
				break;
			}
		}
		return total;
	}

	// average sale getter, takes total sales and divides by number of sales (NOT
	// maxSales)
	public double getAvgSale() {
		return this.getTotalSales() / this.getNumberOfSales();
	}

	/*
	 * CountAbove getter, takes parameter v and finds all elements above v, adding
	 * to a counter for every one found
	 */
	public int getCountAbove(int v) {
		int totalAbove = 0;
		for (double i : this.getAllSales()) {
			if (i > v) {
				totalAbove += 1;
			}
		}

		// returns amount of sales found above the threshold parameter
		return totalAbove;
	}

}
