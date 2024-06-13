//IBAD H
//Oct 11 2023
//Pay Calculator


package ibadH08PayCalc;

//importing java util libraries
import java.util.*;

//main class
public class main {

	//main method
	public static void main(String[] args) {
		
		//x and y pay variables,
		regPay reg = new regPay(0);
		hazardPay hazard = new hazardPay(0);
		
		Scanner in = new Scanner(System.in);
		
		double hours, rate, payR, payH;
		
		System.out.println("Please enter hourly pay rate:");
		
		rate = in.nextDouble();	
		reg.changeRate(rate);
		hazard.changeRate(rate);
		
		System.out.println("Please enter hours worked:");
		
		hours = in.nextDouble();
		
		payR = reg.getPay(hours);
		payH = hazard.getPay(hours);
		
		System.out.println("Your regular pay is: " + payR + "\n Your hazard pay is: " + payH);
		
		
	}

}
