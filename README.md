## Blackjack Project

### Christopher Bianchi


#### Overview
This project is a command-line blackjack game.


#### Topics Covered
Inheritance
Object Oriented Design
Building classes with objects as fields
Using collections to organize and manage data
Use of conditionals to build game logic
Rules of Blackjack can be found at: https://en.wikipedia.org/wiki/Blackjack#Rules_of_play_at_casinos


#### The Code

First, I created classes needed to build out the game. Including: Card, Deck, Hand, Player, Rank, and Suit.
My Card class took the enums Rank and Suit as fields, with Rank also having a card value assigned to each Rank. My Player
class had a Hand object as a field, with the Hand object having an ArrayList of its cards that were dealt out during the game.

Second, I began designing the GameApp. The GameApp had plenty of built-in functionality. Tasks that the GameApp was built to 
handle include:
- Prompting the user for their name, and how much money they brought to the table.
- Prompting the user to make a wager and checking their wallet to be sure they had enough to place said wager.
- Dealing the user's and dealer's cards while hiding the dealer's first card until it was the dealer's turn.
- Prompting the user if they would like to double their wager after the initial deal.
- Prompting the user to hit or stay, while checking to be sure the user didn't break 21.
- If the user broke 21 to account for them potentially having an ace.
- Checking the score of both dealer and player at the end.
- Adjusting the user's wallet for winnings, and resetting the wager.

Third, a couple of the most important functions were the getPlayerVal and hitStaySplit functions. The getPlayerVal function
was where the player's cards in its hand were tallied up for points. I built it using conditional statements that said
if the sum of the players cards were greater than 21, check to see if one of those cards was an Ace, and if it was then to reduce the
sum of the player's cards by 10. Since an Ace can be worth either 11 or 1. The hitStaySplit function was crucial because it is
the fundamental component of playing Blackjack. I used an addCard method to add a card to the player's hand, and then called a showCards method, which called getPlayerVal and then used the returned int from getPlayerVal to determine if the player busted or not. And if the player chose stay it initiated the dealer's turn.

Fourth, the dealer was a player object and programmed to continue to hit unless he landed over 18.

Fifth, my checkScore method checked a number of conditions to determine if the player won or busted, or if the dealer won or busted, or if the player and dealer pushed. These required calls to a method that returned the values of the player's and dealer's hands.
