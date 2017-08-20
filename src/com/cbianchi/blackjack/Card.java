package com.cbianchi.blackjack;

import java.util.HashMap;
import java.util.Map;

public class Card {

	private Rank rank;
	private Suit suit;

	// value = //can you parse an enum to an integer? Or i want to run a foreach
	// loop that searches through a map to get this

	public Card(Rank rank, Suit suit) {

		this.rank = rank;
		this.suit = suit;
		// cardValues.get(this.rank);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Card: Rank: ");
		builder.append(rank);
		builder.append(", Suit: ");
		builder.append(suit);
		builder.append("");
		return builder.toString();
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}



}
