//IBAD H
//Oct 11 2023
//Pay Calculator

package ibadH08PayCalc;

//hazard pay is a child class of the payCalc abstract
public class hazardPay extends payCalc {
	
	//hazard pay overloader, allowing user to set pay rate upon object instantiation
	hazardPay (double rate) {
		this.changeRate(rate);
	}
	
	//overriding getPay class to get the regular pay from the parent class and multiply by 1.5 to get the hazard pay
	public double getPay(double hours) {
		return(super.getPay(hours) * 1.5);
	}
	
}
