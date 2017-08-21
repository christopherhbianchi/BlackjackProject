package com.cbianchi.blackjack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameApp {

	Scanner keyboard = new Scanner(System.in);
	String startInput;
	Player p1 = new Player(); // don't need a hand object because we made a hand object a field of player,
								// because each player has to have a hand
	Player dealer = new Player();
	Deck d1 = new Deck();

	int playerVal = 0;
	int dealerVal = 0;

	static boolean game = true;
	static boolean somebodyWins = false;
	static String hitStaySplit = "";

	public static void main(String[] args) {

		GameApp gA1 = new GameApp();

		gA1.setUpUser();

		while (game) {
			System.out.println("");
			gA1.promptUser();
			gA1.checkWallet();
			gA1.dealCards();
			gA1.showCards("ONE");
			gA1.repromptWager();
			gA1.hitStaySplit();
			gA1.dealerTurn();
			gA1.checkScore();
			gA1.resetGame();
		}

	}

	// put something in a while loop outside this message that can break based on
	// input

	public void setUpUser() {
		System.out.println("Welcome to Blackjack. Enter your name: ");
		p1.setName(keyboard.next());
		System.out.println("How much have you come to play with?: ");
		p1.setWallet(keyboard.nextDouble());
	}

	public void promptUser() {
		System.out.println("Enter your wager: ");
		p1.setWager(keyboard.nextDouble());
		if(p1.getWallet() <= p1.getWager()) { //if the wager is more than their wallet amount, we set wallet to 0
			p1.setWager(p1.getWager() - p1.getWallet());
			p1.setWallet(0);
			
		}
		double x = p1.getWager();
		p1.setWallet(p1.getWallet() - x); // take the wager off your wallet
		System.out.println("Here are your cards: ");
	}

	public void dealCards() {
		Card c1;
		Card c2;
		Card c3;
		Card c4;

		d1.buildDeck();
		d1.shuffleDeck();
		c1 = d1.dealCard();
		c2 = d1.dealCard();
		c3 = d1.dealCard();
		c4 = d1.dealCard();
		p1.getHand().addCard(c1);
		p1.getHand().addCard(c2);
		dealer.getHand().addCard(c3);
		dealer.getHand().addCard(c4);

	}

	public void showCards(String dealerShowAmount) { //we take in the string so we can set a literal String in as a condition to hide the first card if we type in ONE when we call that method
		System.out.println("Player's Cards:");
		for (Card c : p1.getHand().getCardsInHand()) {
			System.out.println(c);
		}
		System.out.println(getPlayerVal());
		System.out.println();

		System.out.println("Dealer's Cards:");

		if (dealerShowAmount.equals("ONE")) {
			System.out.println(dealer.getHand().getCardsInHand().get(0));
			System.out.println(dealer.getHand().getCardsInHand().get(0).getRank().getValue());
		} else if (dealerShowAmount.endsWith("ALL")) {
			for (Card c : dealer.getHand().getCardsInHand()) {
				System.out.println(c);
			}
			System.out.println(getDealerVal());
		} else if (dealerShowAmount.endsWith("TWO")) { //we use these strings and we type in literals to determine whether or not we want to kick into the conditional statement
			System.out.println(dealer.getHand().getCardsInHand().get(0));
			System.out.println(dealer.getHand().getCardsInHand().get(1));
		}
		
	}

	public void repromptWager() {
		String input;
		double x = p1.getWager(); // just to clean up the ternary in the setter below

		if (p1.getWallet() >= 2*x) { //if there's even enough money to double down, ask if they want to
			System.out.println("Now that you've seen your cards, would you like to double your bet?: Y or N");
			input = keyboard.next().toLowerCase();
		
			p1.setWager((input.equals("y")) ? (2 * x) : (x)); // doubles the wage if they say Yes

			if (input.equals("y")) {
				p1.setWallet(p1.getWallet() - p1.getWager()); // takes
			}
		}
	}

	public void hitStaySplit() {

		Card c1;
		do {
			System.out.println("Would you like to hit, or stay?: hit, stay");

			hitStaySplit = keyboard.next().toLowerCase(); // formats their answer into all lower case

			System.out.println("You have elected to " + hitStaySplit);

			if (hitStaySplit.equals("hit")) {
				c1 = d1.dealCard();
				p1.getHand().addCard(c1);


				if (getPlayerVal() > 21) {
					showCards("ONE");
					break;
				} else {
					showCards("ONE");
				}
			} else if (hitStaySplit.equals("stay")) {
				showCards("ONE");
			  }
			
		} while (!hitStaySplit.equalsIgnoreCase("stay"));
	}

	public void dealerTurn() {
		while (getDealerVal() < 17) {
			Card c1;
			c1 = d1.dealCard();
			dealer.getHand().addCard(c1);
		}
		showCards("ALL"); //since dealer's turn is now, we are going to pass in the literal "ALL" so all cards will be shown
	}

	public void checkScore() {

		int playerVal = getPlayerVal();
		int dealerVal = getDealerVal();
		if (playerVal > 21 && dealerVal <= 21) {
			System.out.println("Player Busted");
			somebodyWins = true;
		} else if (dealerVal > 21 && playerVal <= 21) {
			System.out.println("Dealer Busted! Player wins!");
			double x = p1.getWallet();
			somebodyWins = true;
			p1.setWallet(x + (p1.getWager() * 2)); //winning returns the bet and the winnings to the wallet
		} else {
			if (playerVal == dealerVal) {
				System.out.println("You Push");
				double x = p1.getWallet();
				p1.setWallet(x + p1.getWager()); //push returns money back to players wallet
				somebodyWins = true;
			} else if (playerVal > dealerVal) {
				System.out.println(" Player Wins");
				double x = p1.getWallet();
				p1.setWallet(x + (p1.getWager() * 2));
				somebodyWins = true;
			} else if (playerVal < dealerVal) {
				System.out.println(" Dealer Wins");
				somebodyWins = true;
			}
		}

	}

	public int getPlayerVal() {
		int sum = 0;
			for (Card c : p1.getHand().getCardsInHand()) {
				sum = sum + c.getRank().getValue();
			}	
			
			if (sum > 21) {								
				for (Card c : p1.getHand().getCardsInHand()) { //thing about this section is that we need to know if the sum>21, before we go checking for aces at all 
					if (c.getRank() == Rank.ACE) {//so if it is, let's see if ones an ace, then we'll take 10 off the value
						sum = sum - 10;
					}
				}
			}
			
		return sum;
	}

	public int getDealerVal() {
		int sum = 0;
		for (Card c : dealer.getHand().getCardsInHand()) {
			sum = sum + c.getRank().getValue();

		}
		
		if (sum > 21) {
			for (Card c : p1.getHand().getCardsInHand()) {
				if (c.getRank() == Rank.ACE) {
					sum = sum - 10;
				}
			}
		}
		return sum;
	}

	public void resetGame() {
		p1.getHand().resetHand();
		dealer.getHand().resetHand();
		p1.resetWager(); //sets the wager back down to 0
		playerVal = 0;
	}
	
	public void checkWallet() {
		if(p1.getWallet() <= 0) {
			System.out.println("You are out of money. Come back later.");
			game = false;
		}
	}

}

// prompt for name and if they'd like to play
// destroy old deck, shuffle, and break... I COULD MAKE THE DECK STATIC (did it
// and that solves it
// hand the player a card
// prompt player for move, provide them options (hit, stay, split, etc.)
// continue to prompt until they stay or break 21
// if they break 21 game over
// if not, dealer plays until they pass the player or until he breaks 21
// if dealer passes player value, he wins
// if dealer breaks, player wins
// provide appropriate message
// ask if they want to play again






