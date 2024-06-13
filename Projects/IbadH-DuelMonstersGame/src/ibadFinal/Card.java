//NAME: IBAD HASSAN
//DATE: DEC 21 2022
//CS20 FINAL PROJECT
package ibadFinal;

//Card object class
public class Card {
//	Instance variables:
//	name string, attack and defence int, position and deck indicators (booleans)
	private String name;
	private int atk;
	private int def;
	private boolean atkPos;
	private boolean inDeck;

//	default contructor sets name to "name", atk and def to 1000 and sets "inDeck" to false meaning the card is 
//	not in a deck by default (these r set through the overloader)
	public Card() {
		this("name", 1000, 1000, false);
	}

//	card overloader with name, atk, def and inDeck parameters and setting those to the input parameters
	public Card(String name, int atk, int def, boolean inDeck) {
		this.setName(name);
		this.setAtk(atk);
		this.setDef(def);
		this.setInDeck(inDeck);
	}

//	Name getter returning name
	public String getName() {
		return name;
	}

//	Name setter setting name to name parameter
	public void setName(String name) {
		this.name = name;
	}

//	atk getter returning atk
	public int getAtk() {
		return atk;
	}

//	atk setter setting atk to atk parameter
	public void setAtk(int atk) {
		this.atk = atk;
	}

//	def getter returning def
	public int getDef() {
		return def;
	}

//	def setter setting def to def parameter
	public void setDef(int def) {
		this.def = def;
	}

//	isAtkPos getter returning if the card is in attack position (false meaning its in defence position)
	public boolean isAtkPos() {
		return atkPos;
	}

//	card place method, card is placed by giving it a position which is set by the parameter
	public void placeCard(boolean atkPos) {
		this.atkPos = atkPos;
	}


//	inDeck getter returning whether the card is in a deck or not
	public boolean isInDeck() {
		return inDeck;
	}

//	inDeck setter setting inDeck to inDeck parameter
	public void setInDeck(boolean inDeck) {
		this.inDeck = inDeck;
	}
	
//	toString overrider for when the obj is printed
	public String toString() {
		return this.getName() + " with " + this.getAtk() + " attack points and " + this.getDef() + " defence points";
	}
}
