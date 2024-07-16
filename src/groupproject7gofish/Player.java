/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package groupproject7gofish;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author freny vahanka
 * Group Project
 * Date: July 16
 */
public abstract class Player {

     // The name of the player
    private final String name;
    // The player's hand, represented as a list of cards
    private final ArrayList<Card> hand;
    // The player's score
    private int score;

    // Constructor to initialize the player's name, hand, and score
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    // Getter method for the player's name
    public String getName() {
        return name;
    }

    // Getter method for the player's hand
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    // Method to add a card to the player's hand
    public void addCardToHand(Card card) {
        hand.add(card);
    }

    // Method to remove a card from the player's hand
    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    // Method to add a point to the player's score
    public void addPoint() {
        score++;
    }

    // Getter method for the player's score
    public int getScore() {
        return score;
    }

    // Method to check if the player has a card of a specific rank in their hand
    public boolean hasRank(String rank) {
        for (Card card : hand) {
            if (card.getRank().equals(rank)) {
                return true;
            }
        }
        return false;
    }

     // Method to get all cards of a specific rank from the player's hand
    public ArrayList<Card> getCardsOfRank(String rank) {
        ArrayList<Card> cardsOfRank = new ArrayList<>();
        for (Card card : hand) {
            if (card.getRank().equals(rank)) {
                cardsOfRank.add(card);
            }
        }
        return cardsOfRank;
    }

}