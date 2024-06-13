//IBAD H
//Oct 11 2023
//Pay Calculator

package ibadH08PayCalc;

//parent abstract payCalc class
public abstract class payCalc {

	//pay rate instance variable
	private double payRate;

	//pay rate getter
	public double getPayRate() {
		return payRate;
	}

	//pay calculator, takes hours input parameter and multiplies by pay rate to get total pay
	public double getPay(double hours) {
		return (this.getPayRate() * hours);
	}
	
	//rate changer, essentially a setter for payRate
	public void changeRate(double newRate) {
		this.payRate = newRate;
	}
	
	
	
}
