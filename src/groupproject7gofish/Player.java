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
 */
public abstract class Player {

   private String name;
    private ArrayList<Card> hand;
    private int score;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCardToHand(Card card) {
        hand.add(card);
    }

    public void removeCardFromHand(Card card) {
        hand.remove(card);
    }

    public void addPoint() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public boolean hasRank(String rank) {
        for (Card card : hand) {
            if (card.getRank().equals(rank)) {
                return true;
            }
        }
        return false;
    }

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
