package com.cbianchi.blackjack;

import java.util.ArrayList;
import java.util.List;

public class Hand {

		List<Card> cardsInHand = new ArrayList<Card>(2);
		




		public void addCard(Card card1) { //do i want to pull this from the game or from the deck? cohesion/coupling?
		
		cardsInHand.add(card1); //have it add a card from another method call to the deck or the game or something.

		}
		
		public List<Card> getCardsInHand() {
			return this.cardsInHand;
			
		}
		
		
		public void resetHand() {
			this.cardsInHand = new ArrayList<Card>();
		}










}
