//NAME: IBAD HASSAN
//DATE: DEC 21 2022
//CS20 FINAL PROJECT
package ibadFinal;

import java.util.Scanner;

public abstract class main {
//	Declaring variables: Deck object, Enemy and player hands which is a arrays of 3 Spell objects
	public static Deck deck = new Deck();
	public static Spell[] playerHand = new Spell[3];
	public static Spell[] enemyHand = new Spell[3];
//	Declaring player and enemy HP and setting both to 3000, declaring all atk and def bonuses.
	/*
	 * The bonus variables are needed as the program cannot change the actual card
	 * objacts atk or def and return it to the original after since its a randomized
	 * number and isn't stored anywhere else. So it's better to add on to the attack
	 * through variables
	 */
	public static int playerHP = 3000, enemyHP = 3000, atkBonus = 0, enemyAtkBonus = 0, defBonus = 0, enemyDefBonus = 0;

	public static void main(String[] args) {

		/*
		 * Initializing local main method variables: playerDraw and enemyDraw slots,
		 * player input called store, Scanner class and indicator whether its the first
		 * loop of the game
		 */
		Card playerDraw, enemyDraw;
		String store;
		Scanner in = new Scanner(System.in);
		boolean firstCycleFin = false;
//		spellsUsed into for the number of spells a player can use per turn (max 2)
		int spellsUsed = 0;
//		battleDiff int to measure the difference in points that will be inflicted on either player
		int battleDiff;

		System.out.println("Would you like to read the tutorial? (yes or no)");

		store = in.nextLine();

		if (store.equals("yes")) {
			System.out.println(
					"\nTutorial: This game is a simple card game which has two types of cards, monsters and monster-spells. "
					+ "\nBoth cards have specific attack points, defence points, and a position they can be played in, but monster-spells "
					+ "\nalso have an effect property which is a special effect a player can use by storing that card in their hand. "
					+ "\nEach turn, both players will draw a card and if it is a monster-spell, they can store it in their hand and "
					+ "\ndraw a new card to play. The hand can hold a max of 3 monster-spells. If the player draws a monster card or "
					+ "\nchooses to play the monster-spell as a regular monster then they will choose a position to play the card in "
					+ "\n(atk or def) which will alter its behaviour in battle. An attack positon card will play offensively and "
					+ "\nattack the opponents monster, whereas a defence position card will be defensive and shield itself in the "
					+ "\nbattle. After both players have summoned their cards, they will proceed to the battle phase where the "
					+ "\nplayers will have the option to play a spell from their hand (if there are any) and then proceed to "
					+ "\nthe two monsters battling. The outcome of the battle will have a winner and depending on the mosnters "
					+ "\npositions, the losing player will take damage to their lifepoints (which they have 3000 of at the start). "
					+ "\nThen the turn will end and all played cards will be shuffled into the deck. A new turn will play and "
					+ "\nproceed through these draw and battle phases until one player's lifepoints reach 0! Thank you for "
					+ "\nplaying and Enjoy the game!");
		}
		
		
		System.out.println("\n!!GAME START!!");
//		main loop while either player has HP remaining.
		while (playerHP > 0 && enemyHP > 0) {

//			If the player has gone through the first cycle of the game loop, it'll print "NEXT TURN"
			System.out.println((firstCycleFin ? "\nNEXT TURN\n" : ""));

//			drawing a card and setting it to playerDraw and also printing out what the player drew
			playerDraw = deck.draw();
			System.out.println("You drew: " + playerDraw);

//			while the card drawn is a monster-spell card:
			while (playerDraw instanceof Spell) {
//				asking the player if they want to put the card in their hand and redraw
				System.out.println("\nYou drew a spell monster, would you like to store it in your hand?");
				store = in.nextLine();

//				loop to ensure correct input
				while (!store.equals("yes") && !store.equals("no")) {
					System.out.println("\nPlease enter a valid input (yes OR no)");
					store = in.nextLine();
				}

//				if the player says yes:
				if (store.equals("yes")) {
//					iterating through the playerHand array and placing the Spell card in the first empty slot found
					for (int i = 0; i < playerHand.length; i++) {
//						if the slot at index i is empty
						if (playerHand[i] == null) {
							/*
							 * that slot is the playerDraw card converted into type spell, it has to be
							 * converted here because playerDraw is type card and playerHand is type spell,
							 * so it needs to be converted into its more specific class since spell can't
							 * accept type Card while Card can accept type Spell (since its a subclass of
							 * Card)
							 */
							playerHand[i] = (Spell) playerDraw;
//							setting the "inHand" property of playerHand at index i to true since that card is now in hand
							playerHand[i].setInHand(true);
//							clearing the playerHand variable by setting it to null
							playerDraw = null;
//							printing that the card has been stored and the player will now draw again
							System.out
									.println("\nYour spell has been stored in your hand. You will now draw a new card");
//							breaking out of the for loop
							break;
						}
					}

//					if playerDraw isn't null, meaning the card wasn't able to be stored in the hand (meaning the hand is full):
					if (playerDraw != null) {
//						print that the playerHand is full so the card must be played
						System.out.println("\nSorry, your hand is full. You must play the card.");
//						breaking out of the while loop for if the player wants to store the spell in the hand
						break;
					} else {
//						if playerDraw does equal null, then draw a new card and print what card the player drew. If this is another spell, 
//						the loop will repeat again allowing the player to store another card in their hand
						playerDraw = deck.draw();
						System.out.println("\nYou drew: " + playerDraw);
					}

				} else {
//					if player says no to storing the spell then break the while loop
					break;
				}

			}

//			Start of battle phase: asking the player which position they'd like to play their card in (attack or defence)
			System.out.println("\nWould you like to play the card in Attack or Defence mode (atk OR def)");
			store = null;
			store = in.nextLine();

//			valid input loop to ensure a correct input
			while (!store.equals("atk") && !store.equals("def")) {
				System.out.println("\nPlease enter a valid input (atk OR def)");
				store = in.nextLine();
			}

//			if user enters def, use the placeCard method for the playerDraw Card and set atkPos to false
			if (store.equals("def")) {
				playerDraw.placeCard(false);
//			else, use the placeCard method for the playerDraw Card and set atkPos to true
			} else {
				playerDraw.placeCard(true);
			}

//			Printing the summoned Card and what position it is in (attack if atkPos true, defence if atkPos false)
			System.out.println("\nSummoned: " + playerDraw.getName() + " in "
					+ ((playerDraw.isAtkPos()) ? "Attack Position" : "Defence position"));

//			drawing enemy card, and calling the enemyDrawPhase() method with enemyDraw parameter, 
//			and declaring its return variable to enemyDraw
			enemyDraw = deck.draw();
			enemyDraw = enemyDrawPhase(enemyDraw);

//			starting battle phase:
			System.out.println("\nBATTLE PHASE: ");

//			while there is atleast a singular card in playerHand and less than 2 spells have been used
			while (playerHand[0] != null || playerHand[1] != null || playerHand[2] != null && spellsUsed < 2) {

//				setting store input to null (to reset it)
				store = null;
//				asking for whether user wants to use the spells in their hand this turn
				System.out.println("You have spell cards in your hand, would you like to use them?");
				store = in.nextLine();

//				input validation loop
				while (!store.equals("yes") && !store.equals("no")) {
					System.out.println("\nPlease enter a valid input (yes OR no)");
					store = in.nextLine();
				}

//				if user says yes
				if (store.equals("yes")) {
//					asking what monster-spell they'd like to activate
					System.out.println("Please choose which monster-spell you would like to activate: ");

//					iterating through and printing each card in hand
					for (int i = 0; i < playerHand.length; i++) {
//						printing in a list if the playerHand at index i isn't null (meaning a card is in that slot)
						if (playerHand[i] != null) {
							System.out.println((i + 1) + ".) " + playerHand[i].getName() + " with the effect \""
									+ playerHand[i].getEffect() + "\"");
						}
					}

//					taking input for which spell the user wants to use
					System.out.println("Enter the number for the desired effect as listed above: ");
					int spellChoice = in.nextInt();

//					loop for taking in valid input to ensure that the input isn't pointing to an empty slot in the playerHand array
					while (playerHand[spellChoice - 1] == null) {
						System.out.println("\nPlease enter a valid input (1, 2, 3)");
						spellChoice = in.nextInt();
					}

//					activating useEffect() method with player input spellChoice, true as the player used a spell, and both enemy and 
//					player cards drawn as parameters
					useEffect(playerHand[spellChoice - 1], true, playerDraw, enemyDraw);

//					setting the spellChoice slot to null as that card has now been used
					playerHand[spellChoice - 1] = null;
//					increasing spells used
					spellsUsed++;
				} else {
//					if player says no to using spells than break the loop
					break;
				}

			}

			spellsUsed = 0;

//			running enemySpellUse method with player and enemy drawn cards as parameters
			enemySpellUse(playerDraw, enemyDraw);

//			starting main battle
			System.out.println("Both monsters will now battle!");

//			if both cards are in atk position:
			if (enemyDraw.isAtkPos() && playerDraw.isAtkPos()) {
//				the battle difference is playerDraw's atk + playerAtkBonus (0 by default unless otherwise altered) 
//				subracted by the enemyDraw's atk points plus enemyAtkBonus (also 0 by default)
				battleDiff = (playerDraw.getAtk() + atkBonus) - (enemyDraw.getAtk() + enemyAtkBonus);

//				if battleDiff is less than 0 (meaning the enemy had more overall atk points and won the battle)
				if (battleDiff < 0) {
//					add the negative BattleDiff to playerHP (lowering it)
					playerHP += battleDiff;

//					if playerHP is less than 0 then set it to 0
					if (playerHP < 0) {
						playerHP = 0;
					}

//					print that the player lost and how much damage they received
					System.out.println("The enemy's " + enemyDraw.getName() + " destroyed your monster an dealt "
							+ Math.abs(battleDiff) + " damage to your HP! You now have " + playerHP + " HP remaining.");

//				else if battleDiff is more than 0 (meaning the player won the battle)
				} else if (battleDiff > 0) {
//					minus battleDiff from enemyHP
					enemyHP -= battleDiff;
//					if enemyHP is below 0 after, set it to 0
					if (enemyHP < 0) {
						enemyHP = 0;
					}
//					print that the player won and how much damage the enemy received
					System.out.println("Your " + playerDraw.getName() + " destroyed the enemy's monster and dealth "
							+ battleDiff + " damage to the enemy! They now have " + enemyHP + " HP remaining");
				} else {
//					if battleDiff was 0 print that both monsters destroyed each other and no damage was inflicted
					System.out.println(
							"Both monsters destoryed each other due to having the same attack points! Neither player takes damage.");
				}

//			if enemyDraw is in defence position and playerDraw is in attack
			} else if (!enemyDraw.isAtkPos() && playerDraw.isAtkPos()) {
//				the battle difference is playerDraw's atk + playerAtkBonus (0 by default unless otherwise altered) 
//				subracted by the enemyDraw's def points plus enemyDefBonus (also 0 by default)
				battleDiff = (playerDraw.getAtk() + atkBonus) - (enemyDraw.getDef() + enemyDefBonus);

//				if battleDiff is less than 0 (meaning the enemy had more overall def points and won the battle)
				if (battleDiff < 0) {

//					add the negative BattleDiff to playerHP (lowering it)
					playerHP += battleDiff;

//					if playerHP is less than 0 then set it to 0
					if (playerHP < 0) {
						playerHP = 0;
					}

//					print that the player lost and how much damage they received
					System.out.println("Your monster was unable to destroy the enemy's " + enemyDraw.getName()
							+ ". This dealt you " + battleDiff
							+ " damage since the enemy's mosnter was in defence position. You now have " + playerHP
							+ "HP remaining.");

//				else if battleDiff is more than 0 (meaning the player won the battle)
				} else if (battleDiff > 0) {
//					print that the player won but the enemy's monster lived and the enemy avoided dmg
					System.out.println("Your monster destroyed the enemy's " + enemyDraw.getName()
							+ ", but couldn't deal damage since it was in defence mode.");
				} else {
//					print that the your monster was destroyed but the enemy's lived because it was 
//					in defence mode. Neither players took dmg.
					System.out.println(
							"Your monster was destroyed since both monsters had the same points, but the enemy's was in defence position! Neither player takes damage.");
				}
//			else if playerDraw is in defence while enemyDraw is in attack
			} else if (!playerDraw.isAtkPos() && enemyDraw.isAtkPos()) {
//				the battle difference is playerDraw's def + playerDefBonus (0 by default unless otherwise altered) 
//				subracted by the enemyDraw's atk points plus enemyAtkBonus (also 0 by default)
				battleDiff = (playerDraw.getDef() + defBonus) - (enemyDraw.getAtk() + enemyAtkBonus);

//				if battleDiff is less than 0 (player lost the battle)
				if (battleDiff < 0) {
//					no damage taken since playerDraw is in defence, but print that the player 
//					lost but the monster survived with no damage taken
					System.out.println("Your monster lost the battle, but survived as it was in defence mode");

//					else if battleDiff is more than 0 (meaning the player won the battle)	
				} else if (battleDiff > 0) {
//					minus battleDiff form enemyHP	
					enemyHP -= battleDiff;
//					if enemyHP is below 0 after, set it to 0
					if (enemyHP < 0) {
						enemyHP = 0;
					}
//					print that the player won and their monster survived while dealing damage to the opponenet since its monster was too weak
					System.out.println(
							"Your monster survived and destroyed the other monster as it's attack was too weak! The enemy took "
									+ battleDiff + " damage and now has " + enemyHP + "HP remaining.");
				} else {
//					if both have the same points, then print that the enemy's 
//					monster gets destroyed, but the player's survives since its in defence mode
					System.out.println(
							"The enemy's monster was destroyed since both monsters had the same points, but the yours was in defence position! Neither player takes damage.");
				}
			} else {
//				if both monsters are in defence position, they automatically get destroyed and no one takes damage
				System.out.println(
						"Since both monsters are in defence position, no battle occurs and both are returned to the deck.");

			}

//			set all bonuses to 0 (reset)
			enemyAtkBonus = 0;
			atkBonus = 0;
			enemyDefBonus = 0;
			defBonus = 0;

//			set enemyDraw and playerDraw to inDeck and set the variables to null. 
//			This means the cards are returned to the deck and the draw variables are reset
			enemyDraw.setInDeck(true);
			playerDraw.setInDeck(true);
			playerDraw = null;
			enemyDraw = null;

//			set firstCycleFin to true meaning the first cycle has been finished (if this was false), if it was true then nothing changes
			firstCycleFin = true;

		}

//		print the battle concludes
		System.out.println("\nTHE BATTLE HAS ENDED.\n");

//		if playerHP is less than or equal to 0, then print that the player LOST
		if (playerHP <= 0) {
			System.out.println("YOU LOST!");

//			if enemyHP is less than or equal to 0, then print that the player WON
		} else if (enemyHP <= 0) {
			System.out.println("YOU WON!");
		}
	}

//	enemyDrawPhase() method with draw (type Card) parameter and return type Card, 
//	this is supposed to be filled with the card drawn by the enemy:
	public static Card enemyDrawPhase(Card draw) {

//		while draw parameter is an instance of the Spell class (meaning the card drawn is a Spell)
		while (draw instanceof Spell) {

//			generate a random choice of 0 and 2 with 1 or 2 being yes meaning a 67& chance for yes and 33% for no (no or yes)
			int choice = (int) Math.round(Math.random() * 2);

//			enemy choice is more than 1 (1 or 2 meaning yes)
			if (choice >= 1) {
//				iterate through the enemyHand array to search for an empty slot (index)
				for (int i = 0; i < enemyHand.length; i++) {
//					if element i of enemyHand is null (empty) then:
					if (enemyHand[i] == null) {
//						cast draw as type Spell and declare it to enemyHand at index i
						enemyHand[i] = (Spell) draw;
//						set the inHand property of that card to ture
						enemyHand[i].setInHand(true);
//						set draw to null (allowing for a redraw later)
						draw = null;
//						break from the for loop
						break;
					}
				}

//				if draw is null then redraw a card and declare it to draw
				if (draw == null) {
					draw = deck.draw();
				} else {
//					if draw isn't null then break the while loop
					break;
				}

//			if enemy choice says no then break the while loop
			} else {
				break;
			}

		}

//		if the draw card's atk is less then its defence then the enemy will place the card in defence mode		
		if (draw.getAtk() < draw.getDef()) {
			draw.placeCard(false);

//		if the draw card's atk is more then its defence then the enemy will place the card in attack mode		
		} else {
			draw.placeCard(true);
		}

//		print the card the enemy summoned and in what position
		System.out.println("\nThe enemy Summoned: " + draw + " in "
				+ ((draw.isAtkPos()) ? "Attack Position" : "Defence position"));
		return draw; // return card draw (this being declared to the enemyDraw variable in the main
						// method)
	}

//	enemySpellUse() method with void return type and player and enemy parameters for playerDraw and enemyDraw:
	public static void enemySpellUse(Card player, Card enemy) {
//		initializing spellsUsed for the enemy to 0
		int spellsUsed = 0;

//		while the enemyHand array has atleast one card and spellsUsed is less than 2
		while (enemyHand[0] != null || enemyHand[1] != null || enemyHand[2] != null && spellsUsed < 2) {

//			initialize enemy choice to a random int of 0 and 1
			int choice = (int) Math.round(Math.random());

//			if choice is 1 (meaning yes):
			if (choice == 1) {
//				generate a random spellChoice that will be the index of the enemyHand array to activate a spell
				int spellChoice = (int) Math.round(Math.random() * 2);

//				loop to validate the random spell choice index isn't null and is a slot with a card in place
				while (enemyHand[spellChoice] == null) {
					spellChoice = (int) Math.round(Math.random() * 2);
				}

//				calling useEffect method with enemyHand[spellChoice] as the active spell, 
//				false because it is called for enemy spell use and then the player and enemy parameters
				useEffect(enemyHand[spellChoice], false, player, enemy);

//				setting enemyHand at index spellChoice to null meaning that card has been used
				enemyHand[spellChoice] = null;

//				increasing spellsUsed by 1
				spellsUsed++;
			}

		}
//		resetting spellsUsed to 0
		spellsUsed = 0;
	}

//	useEffect method to interpret the spell card effects, with parameters for the spell activated, boolean for if 
//	its used by the players and player and enemy parameters for playerDraw and enemyDraw
	public static void useEffect(Spell x, boolean usedByPlayer, Card player, Card enemy) {
//		if the effect is -1000 opponenet health:
		if (x.getEffect().equals("-1000 opponent health")) {
//			if its used by the player
			if (usedByPlayer) {
//				minus 1000 from enemyHP
				enemyHP -= 1000;
//				if enemyHP is below 0 after, set it to 0
				if (enemyHP < 0) {
					enemyHP = 0;
				}
//				print what card used the spell and the remaining enemyHP
				System.out.println("You used " + x.getName()
						+ "'s effect and dealth 1000 damage to the opponents HP! The opponent has " + enemyHP
						+ "HP remaining");

//			if its used by the enemy
			} else {
//				minus 1000 from playerHP
				playerHP -= 1000;

//				if playerHP is less than 0 then set it to 0
				if (playerHP < 0) {
					playerHP = 0;
				}

//				print what card used the spell and the remaining playerHP
				System.out.println("The enemy used the monster-spell " + x.getName()
						+ " from their hand and reduced your HP by 1000! You now have " + playerHP + "HP remaining");

			}
//		if the effect is +1000 player health
		} else if (x.getEffect().equals("+1000 player health")) {
//			if its used by the player
			if (usedByPlayer) {
//				player gains 1000HP
				playerHP += 1000;
//				print what card used the spell and the remaining playerHP
				System.out.println("You used " + x.getName() + "'s effect and gained 1000HP. You now have " + playerHP
						+ "HP remaining");
//			if its used by the enemy	
			} else {
//				enemy gains 1000HP
				enemyHP += 1000;
//				print what card used the spell and the remaining enemyHP
				System.out.println("The enemy used the monster-spell " + x.getName()
						+ " from their hand and gained 1000hp! They now have " + enemyHP + "HP remaining");

			}
		} else if (x.getEffect().equals("+1000 attack")) {
//			if its used by the player
			if (usedByPlayer) {
//				player gains 1000 attack
				atkBonus += 1000;
//				print what card used the spell and the increased total attack pts
				System.out.println("You used " + x.getName()
						+ "'s effect and boosted you monster's attack by 1000! Your monster now has "
						+ (player.getAtk() + atkBonus) + " attack points");
//			if its used by the enemy		
			} else {
//				enemy gains 1000 attack
				enemyAtkBonus += 1000;
//				print what card used the spell and the increased total attack pts
				System.out.println("The enemy used the monster-spell " + x.getName()
						+ " from their hand and boosted it's monster's attack by 1000! Their monster now has "
						+ (enemy.getAtk() + enemyAtkBonus) + " attack points");

			}
		} else if (x.getEffect().equals("-500 opponent health")) {
//			if its used by the player
			if (usedByPlayer) {
//				minus 500 from enemyHP
				enemyHP -= 500;
//				if enemyHP is below 0 after, set it to 0
				if (enemyHP < 0) {
					enemyHP = 0;
				}
//				print what card used the spell and the remaining enemyHP
				System.out.println("You used " + x.getName()
						+ "'s effect and dealth 500 damage to the opponents HP! The opponent has " + enemyHP
						+ "HP remaining");
//			if its used by the enemy	
			} else {
//				minus 500 from playerHP
				playerHP -= 500;

//				if playerHP is less than 0 then set it to 0
				if (playerHP < 0) {
					playerHP = 0;
				}

//				print what card used the spell and the remaining playerHP
				System.out.println("The enemy used the monster-spell " + x.getName()
						+ " from their hand and reduced your HP by 500! You now have " + playerHP + "HP remaining");

			}
		} else if (x.getEffect().equals("+1000 defence")) {
//			if its used by the player
			if (usedByPlayer) {
//				player gains 1000 def
				defBonus += 1000;
//				print what card used the spell and the increased total defence pts
				System.out.println("You used " + x.getName()
						+ "'s effect and boosted you monster's defence by 1000! Your monster now has "
						+ (player.getDef() + defBonus) + " defence points");
//			if its used by the enemy	
			} else {
//				enemy gains 1000 def
				enemyDefBonus += 1000;
//				print what card used the spell and the increased total defence pts
				System.out.println("The enemy used the monster-spell " + x.getName()
						+ " from their hand and boosted it's monster's defence by 1000! Their monster now has "
						+ (enemy.getDef() + enemyDefBonus) + " defence points");

			}
		} else if (x.getEffect().equals("+500 player health")) {
//			if its used by the player
			if (usedByPlayer) {
//				player gains 500HP
				playerHP += 500;
//				print what card used the spell and the remaining playerHP
				System.out.println("You used " + x.getName() + "'s effect and gained 500HP. You now have " + playerHP
						+ "HP remaining");
//			if its used by the enemy	
			} else {
//				enemy gains 500HP
				enemyHP += 500;
//				print what card used the spell and the remaining enemyHP
				System.out.println("The enemy used the monster-spell " + x.getName()
						+ " from their hand and gained 500HP! They now have " + enemyHP + "HP remaining");

			}
		}

//		set the spell used back into the deck and remove it from hand
		x.setInDeck(true);
		x.setInHand(false);
	}

}
