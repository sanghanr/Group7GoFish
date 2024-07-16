/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Pancham Patel -16 july
 */
package groupproject7gofish;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 *
 * @author PanchamPatel
 */
public class Card {

    // Private instance variables to store the suit and rank of the card
    private String suit;
    private String rank;

    /**
     * Constructor to initialize a card with a suit and rank.
     *
     * @param suit The suit of the card (e.g., hearts, spades, diamonds, clubs)
     * @param rank The rank of the card (e.g., 2, 3, 4, ... , Jack, Queen, King, Ace)
     */
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    /**
     * Getter method to retrieve the suit of the card.
     *
     * @return The suit of the card
     */
    public String getSuit() {
        return suit;
    }

    /**
     * Getter method to retrieve the rank of the card.
     *
     * @return The rank of the card
     */
    public String getRank() {
        return rank;
    }

    /**
     * Overridden toString method to provide a string representation of the card.
     *
     * @return A string in the format "rank of suit"
     */
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}