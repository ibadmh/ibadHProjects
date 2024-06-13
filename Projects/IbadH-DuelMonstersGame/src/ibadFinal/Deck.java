//NAME: IBAD HASSAN
//DATE: DEC 21 2022
//CS20 FINAL PROJECT
package ibadFinal;

//importing file handling classes needed for reading files and exception handling
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

//deck object class
public class Deck {

//	instance variable: cardList array of Card objects
	private Card[] cardList;

//	default constructor sets cardList to 15 monsters and 10 spells
	Deck() {
		this.buildDeck(15, 10);
	}

//	no overrider as the user is not meant to manipulate the deck details

//	build deck method with parameters for number of cards and spells:
	private void buildDeck(int cards, int spells) {

//		declaring cardList as a Card array of cards + spells number of cards (including spell subclasses)
		cardList = new Card[cards + spells];

//		try catch block for main code
		try {

//			opening buffered reader for monsterNames, spellNames, effects
			BufferedReader monsterNames = new BufferedReader(new FileReader("monsters.txt"));
			BufferedReader spellNames = new BufferedReader(new FileReader("spells.txt"));
			BufferedReader effects = new BufferedReader(new FileReader("effects.txt"));

//			cycling through array
			for (int i = 0; i < cardList.length; i++) {
//				generating a random atk between 1000 and 3500 that is rounded to nearest hundred and random 
//				def between 500 and 3000 that is also rounded to nearest hundred
				int atk = (int) Math.round((Math.random() * (35 - 10)) + 10) * 100;
				int def = (int) Math.round((Math.random() * (25 - 5)) + 5) * 100;

//				if the array index is less than the number of spells:
				if (i < spells) {
//					setting the cardList of index i to a randomly generated monster-spell card that is in the deck and not in hand
					cardList[i] = new Spell(spellNames.readLine(), atk, def, true, effects.readLine(), false);
//					the if statement allows the code to set up as many spells as the parameter asks for 
//					starting from index 0 to one less than the number of spells meaning the number of indexes that are a spell will be equal to the input parameters
				}

//				else (when the array has added the desired number of spells, it goes to else as the index is more than or equal to the spells parameter, 
//				meaning the rest of the array will be set to normal monster cards
				else {
//					setting cardList at index i to a randomly generated monster that is in the deck
					cardList[i] = new Card(monsterNames.readLine(), atk, def, true);
				}

			}
//			closing all buffered readers
			monsterNames.close();
			spellNames.close();
			effects.close();

//		catching fileNotFoundException
		} catch (FileNotFoundException e) {
			System.out.println(e);
//		catching any other general exception
		} catch (Exception e) {
			System.out.println(e);
		}

	}

//	draw method:
	public Card draw() {
//		generates an int value thatll be a random index for cardList array
		int randCard = (int) Math.round(Math.random() * (cardList.length - 1));
//		loop to regenerate index until the cardList element at that index has an inDeck instance of true
		while (!this.getCard(randCard).isInDeck()) {
			randCard = (int) Math.round(Math.random() * (cardList.length - 1));
		}
//		setting that cards inDeck to false (removing from deck)
		this.getCard(randCard).setInDeck(false);
//		returning the card
		return this.getCard(randCard);
	}

//	specific card getter that returns the cardList element at the index parameter inputted
	public Card getCard(int index) {
		return cardList[index];
	}

}
