package com.cbianchi.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	
	public static void main(String[] args) {
		
		Deck d1 = new Deck();
		d1.buildDeck();
		d1.showDeck();
		
	}
	
		int deckCardPosition = 0; //need a way to reset this when we shuffle too

		static List<Card> cardDeck = new ArrayList<Card>(52); //so that each time i call build deck it destroys the old one!
		
		public void buildDeck() {
			for (Suit suit : Suit.values()) {
				for (Rank rank : Rank.values()) {
					cardDeck.add(new Card(rank, suit));
				}
			}
		}
		
		
		public void showDeck() {
			for (Card card1 : cardDeck) {
				System.out.println(card1.toString());
			}
		}
		
		public void shuffleDeck() {
			buildDeck(); //so when we shuffle the deck it automatically rebuilds out our deck for us
			Collections.shuffle(cardDeck);
			deckCardPosition = 0; //rests cardPosition to 0.
		}
		
		public Card dealCard() {
			
			Card theCard = cardDeck.get(deckCardPosition); //so this returns a card to the user. Need a way to remove the card from the deck too
			cardDeck.remove(deckCardPosition); //removes from deck
			deckCardPosition++;					//need a way to reset the deck again(see shuffleDeck() above)
			return theCard;
		}
		
		
		public void cardsLeft() {
			System.out.println(cardDeck.size()); //maybe we want to make it so after each game it says?
		}

}
