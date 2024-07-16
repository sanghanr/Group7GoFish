/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package groupproject7gofish;

import java.util.ArrayList;
import java.util.Collections;

/**
 * The Deck class represents a standard deck of 52 playing cards.
 * It provides methods to shuffle the deck, draw a card, and check the number of cards left.
 * The deck is initialized with all 52 cards and shuffled upon creation.
 * 
 * Author: Parth Vaghani
 */
public class Deck {
    private ArrayList<Card> cards; // List to hold all the cards in the deck

    /**
     * Constructor to initialize the deck with 52 cards and shuffle them.
     */
    public Deck() {
        cards = new ArrayList<>(); // Initialize the ArrayList to hold Card objects
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"}; // Array of suits
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"}; // Array of ranks

        // Loop through each suit
        for (String suit : suits) {
            // Loop through each rank within the current suit
            for (String rank : ranks) {
                // Create a new Card object with the current suit and rank, and add it to the deck
                cards.add(new Card(suit, rank));
            }
        }

        // Shuffle the deck to randomize the order of cards
        Collections.shuffle(cards);
    }

    /**
     * Method to draw a card from the top of the deck.
     * @return the drawn card, or null if the deck is empty.
     */
    public Card drawCard() {
        if (!cards.isEmpty()) { // Check if there are any cards left in the deck
            return cards.remove(cards.size() - 1); // Remove and return the last card in the deck
        }
        return null; // Return null if the deck is empty
    }

    /**
     * Method to get the number of cards left in the deck.
     * @return the number of cards remaining in the deck.
     */
    public int cardsLeft() {
        return cards.size(); // Return the size of the deck (number of cards remaining)
    }
}
