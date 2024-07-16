/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package groupproject7gofish;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 * Go Fish 
 * Group 7
 * @author dancye 
 * @author Rihil
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Game {

    private ArrayList<Player> players;
    private Deck deck;
    private Scanner scanner;

    public Game() {
        players = new ArrayList<>();
        deck = new Deck();
        scanner = new Scanner(System.in);
    }

    public void registerPlayer(String name) {
        players.add(new Player(name) {});
    }

    public void startGame() {
        for (Player player : players) {
            for (int i = 0; i < 5; i++) {
                player.addCardToHand(deck.drawCard());
            }
        }

        boolean gameOngoing = true;
        while (gameOngoing) {
            for (Player player : players) {
                if (deck.cardsLeft() == 0) {
                    gameOngoing = false;
                    break;
                }

                System.out.println(player.getName() + "'s turn:");
                System.out.println("Your hand: " + player.getHand());

                System.out.print("Ask for a rank: ");
                String rank = scanner.nextLine();

                Player opponent = getOpponent(player);
                ArrayList<Card> cardsOfRank = opponent.getCardsOfRank(rank);
                if (!cardsOfRank.isEmpty()) {
                    System.out.println("Opponent has " + cardsOfRank.size() + " " + rank + "(s).");

                    for (Card card : cardsOfRank) {
                        player.addCardToHand(card);
                        opponent.removeCardFromHand(card);
                    }
                    player.addPoint();
                } else {
                    System.out.println("Go Fish!");
                    Card drawnCard = deck.drawCard();
                    if (drawnCard != null) {
                        player.addCardToHand(drawnCard);
                    }
                }

                System.out.println("Your score: " + player.getScore());
            }
        }

        determineWinner(); // will show the winner and score
    }

    private Player getOpponent(Player currentPlayer) {
        for (Player player : players) {
            if (!player.equals(currentPlayer)) {
                return player;
            }
        }
        return null;
    }

    private void determineWinner() {
        Player winner = null;
        int highestScore = 0;

        for (Player player : players) {
            if (player.getScore() > highestScore) {
                highestScore = player.getScore();
                winner = player;
            }
        }

        if (winner != null) {
            System.out.println("The winner is " + winner.getName() + " with a score of " + highestScore + "!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    public static void main(String[] args) {
        Game game = new Game() {};
        
        Scanner input = new Scanner(System.in);
 
        int numberOfPlayer = 0;
        System.out.print("How many people you are:- ");
        numberOfPlayer = input.nextInt();
        while(true){
            if(numberOfPlayer>4){
                System.out.println("Only 4 players can enroll");
                System.out.print("How many people you are:- ");
                numberOfPlayer = input.nextInt();
            }else{
                break;
            }
        }
        String userName;
        for(int i = 1; i<=numberOfPlayer;i++ ){
            System.out.print("Insert name of"+i+"'s the player:- ");
            userName = input.nextLine();
            game.registerPlayer(userName);
        }
        game.startGame();
    }
}
