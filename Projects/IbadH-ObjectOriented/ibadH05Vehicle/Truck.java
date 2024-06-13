//IBAD HASSAN
//Oct 12 2023
//05 - Vehicle

package ibadH05Vehicle;

//Truck subclass of Vehicle (inherits fields and methods)
public class Truck extends Vehicle {
	
	//load capacity and tow capacity fields (both in kg)
	private double loadCap, towCap;
	
	//truck default constructor setting strings to N/A and ints to 0
	Truck() {
		this("N/A", "N/A", 0, 0, 0);
	}
	
	//Truck overloader, takes superclass overloader and adds loadCap and towCap parameters
	Truck(String maker, String owner, int cylinders, double load, double tow) {
		super(maker, owner, cylinders);
		this.setLoadCap(load);
		this.setTowCap(tow);
	}

	//setters and getters for load and tow capacity:
		public double getLoadCap() {
			return loadCap;
		}
	
		public void setLoadCap(double loadCap) {
			this.loadCap = loadCap;
		}
	
		public double getTowCap() {
			return towCap;
		}
	
		public void setTowCap(double towCap) {
			this.towCap = towCap;
		}
	
	/*to string override, when object is printed it outputs 
	vehicle details, with the inclusion of load and tow capacities for trucks*/
	public String toString() {
		return this.getOwner() + " owns a " + this.getManufacturer() + " Truck with " + this.getCylinders() + 
				" cylinders. That can carry up to " + this.getLoadCap() + "kg and tows up to " + this.getTowCap() + "kg!";
	}
}
