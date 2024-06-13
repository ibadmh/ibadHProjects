//IBAD H
//Oct 11 2023
//Pay Calculator

package ibadH08PayCalc;

//regPay is a child class of payCalc abstract
public class regPay extends payCalc {
	
	//adding overloader that allows user to set a rate upon instantiation
	regPay (double rate) {
		this.changeRate(rate);
	}
}
