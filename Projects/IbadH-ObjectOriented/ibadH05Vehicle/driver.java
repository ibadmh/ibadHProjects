//IBAD HASSAN
//Oct 12 2023
//05 - Vehicle

package ibadH05Vehicle;

//driver class
public class driver {
	
	//main method
	public static void main(String[] args) {
		/*declaring vehicle and truck objects:
		 * Vehicle is a V8 Ford Mustang owned by John
		 * Truck is a V6 Ford F150 Raptor owned by Mitchell
		 * */
		Vehicle mustang = new Vehicle("Ford", "John", 8);
		Truck raptor = new Truck("Ford", "Mitchell", 6, 800, 3719);
		
		//Printing toString statements for both vehicles
		System.out.println(mustang);
		System.out.println(raptor);
	}

}
