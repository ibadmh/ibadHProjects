//Name: IBAD H.
//Oct 10 2023
//02 Person Class

//main package
package ibadHassan02PersonClass;

//importing all java utility classes
import java.util.*;

//main class
public class main {

	//main method
	public static void main(String[] args) {
		//Scanner input variable
		Scanner keyIn = new Scanner(System.in);
	
		//Person entries, Entry 1 is an example object, Entry 2 is the user's input
		Person Entry1 = new Person("John", "Smith", 192, 90);
		Person Entry2 = new Person();
		
		//introducing system and requesting input
		System.out.println("Welcome to the Java Person Book! Please enter the First Name, Last Name, Height "
				+ "(in cm), and Weight (in kg) in that order by pressing \"ENTER\" after each attribute:");
		
		//setting First Name, Last Name, height and weight to the user inputs
		Entry2.setFirstName(keyIn.nextLine());
		Entry2.setLastName(keyIn.nextLine());
		Entry2.setHeight(keyIn.nextInt());
		Entry2.setWeight(keyIn.nextInt());
		
		//Checking if the entered input is a duplicate of the example object
		boolean checkDupe = Entry1.checkDupe(Entry1, Entry2);
		
		//if it is a duplicate then inform the user, if not then thank them for the entry and exit program.
		if (checkDupe) {
			System.out.println("Sorry, this entry already exists.");
		} else {
			System.out.println("Thank you for your entry.");
		}
		
		
	
	} 

}
