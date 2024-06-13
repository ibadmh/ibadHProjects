//Name: IBAD H.
//Oct 10 2023
//02 Person Class

//main packagae
package ibadHassan02PersonClass;

//person object class
public class Person {
	
	//instance variables for the Names, Height and Weight of the Person
	private String firstName;
	private String lastName;
	private int height;
	private int weight;
	
	//default constructor
	public Person() {
		this("firstName", "lastName", 0, 0);
	}
	
	//setting overloader
	public Person(String firstName, String lastName, int height, int weight) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setHeight(height);
		this.setWeight(weight);
	}

	//Getters and Setters for all Instance Variables:
		public String getFirstName() {
			return firstName;
		}
	
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
	
		public String getLastName() {
			return lastName;
		}
	
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	
		public int getHeight() {
			return height;
		}
	
		public void setHeight(int height) {
			this.height = height;
		}
	
		public int getWeight() {
			return weight;
		}
	
		public void setWeight(int weight) {
			this.weight = weight;
		}
	
		
	//duplicate check method that returns true or false if 2 chosen instances are identical based on Full Name
	public boolean checkDupe(Person person1, Person person2) {
		//if first and last names of both are the same then return true, if not return false
		if (person1.getFirstName().equalsIgnoreCase(person2.getFirstName()) && person1.getLastName().equalsIgnoreCase(person2.getLastName())) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}
