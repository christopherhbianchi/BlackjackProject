package com.cbianchi.blackjack;

public class Player {
	
	private String name;
	private double wallet;
	private double wager;
	private Hand hand; //each player MUST have a hand object as a field
	

	
	public void placeWager(int wager) {
		
	}

	public Player() {
		this.hand = new Hand();
	}


	public String getName() {
		return name;
	}




	public void setName(String name) { //we want to allow the player to set their name
		this.name = name;
	}




	public double getWallet() {
		return wallet;
	}




	public void setWallet(double wallet) {
		this.wallet = (double)wallet; //we want to typecast in case someone just enters an int we don't want to freak the game out
		
	}




	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	
	
	
	public double getWager() {
		return wager;
	}

	public void setWager(double wager) {
		this.wager = (double)wager;
	}
	
	
	
	
	
	
	
	
	
}

	
