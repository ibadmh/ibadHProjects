//NAME: IBAD HASSAN
//DATE: DEC 21 2022
//CS20 FINAL PROJECT
package ibadFinal;

//Spell subclass of Card
public class Spell extends Card {

//	instance variables: effect string and inHand boolean indicator
	private String effect;
	private boolean inHand;

//	Spell constructor, setting default name to "spell", atk and def to 1000 and effect to "effect"
	public Spell() {
		this("spell", 1000, 1000, false, "effect", false);
	}

//	overloader: name, atk, def, inDeck, effect parameters and inHand parameters, setting those to 
//	the super class overloader and the setEffect() method and also the setInHand() method
	public Spell(String name, int atk, int def, boolean inDeck, String effect, boolean inHand) {
		super(name, atk, def, inDeck);
		this.setEffect(effect);
		this.setInHand(inHand);
	}

//	effect getter returning effect
	public String getEffect() {
		return this.effect;
	}

//	effect setter setting effect instance to effect parameter
	public void setEffect(String effect) {
		this.effect = effect;
	}


//	inHand getter returning inHand
	public boolean isInHand() {
		return inHand;
	}

//	inHand setter setting boolean inHand instance to inHand parameter
	public void setInHand(boolean inHand) {
		this.inHand = inHand;
	}

//	@override: toString overrider for when Spell is printed, returns super class string override, 
//	but adds the effect attribute description
	public String toString() {
		return super.toString() + " and the usable effect \"" + this.getEffect() + "\"";
	}
}
