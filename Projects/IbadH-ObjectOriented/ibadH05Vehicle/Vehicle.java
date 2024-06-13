//IBAD HASSAN
//Oct 12 2023
//05 - Vehicle

package ibadH05Vehicle;

//Vehicle super class
public class Vehicle {
	
	//manufacturer, owner and no. of cylinders fields
	private String manufacturer, owner;
	private int cylinders;
	
	//overloader with parameters for all 3 fields
	Vehicle(String maker, String owner, int cylinders) {
		this.setCylinders(cylinders);
		this.setManufacturer(maker);
		this.setOwner(owner);
	}
	
	//default contructor setting all strings to N/A and ints to 0
	Vehicle() {
		this("N/A", "N/A", 0);
	}
	
	//setters and getters for all fields
		public String getManufacturer() {
			return manufacturer;
		}
	
		public void setManufacturer(String manufacturer) {
			this.manufacturer = manufacturer;
		}
	
		public String getOwner() {
			return owner;
		}
	
		public void setOwner(String owner) {
			this.owner = owner;
		}
	
		public int getCylinders() {
			return cylinders;
		}
	
		public void setCylinders(int cylinders) {
			this.cylinders = cylinders;
		}
		
	//toString overriders, outputs vehicle details in a sentence
	public String toString() {
		return this.getOwner() + " owns a " + this.getManufacturer()
		+ " with " + this.getCylinders() + " cylinders";
	}
		
}

