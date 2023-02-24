/**
 * Elia Phan
 * CS231 SP23 Project 1
 * Deck.java
 * last modified 2/12/2023
 * Based on: Prof. Max Bender & Naser Al Madi's original outline
 *
 * How to run?
 * Run DeckTests.java to execute test code
 */

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private ArrayList<Card> deck; //declare a deck as an ArrayList of Cards
    private Random rand = new Random(); //initialize a Random object (for shuffle() method)

    /**
     * Creates the underlying deck as an ArrayList of Card objects. 
     * Calls build() as a subroutine to build the deck itself.
     */
    public Deck(boolean isSixDeck) {
        deck = new ArrayList<>(); //initialize a deck as an ArrayList of Cards
        if (isSixDeck){     //repeat adding decks six times for a six-deck game (isSixDeck == true)
            for (int i=0; i<6; i++) {
                this.build();
            }
        }
        else{       //only adding deck once for a single-deck game (isSixDeck == false)
            this.build();
        }
        this.shuffle();
    }

    /**
     * Builds up/Adds to the underlying deck with 52 cards.
     */
    public void build() {
        int[] mylist = new int[]{2,3,4,5,6,7,8,9,11}; //add 4 each of cards with values 2-9 and 11
        for (int i = 1; i < 5; i++){
            for (int item : mylist){
                deck.add(new Card(item));
            }
        }
        for (int i = 1; i < 17; i++) { //add 16 cards with the value 10
            deck.add(new Card(10));
        }
    }

    /**
     * Returns the number of cards left in the deck. 
     * @return the number of cards left in the deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Returns and removes the first card of the deck.
     * @return the first card of the deck
     */
    public Card deal() {
        Card output = deck.get(0);
        deck.remove(0);
        return output;
    }

    /**
     * Shuffles the cards currently in the deck. 
     */
    public void shuffle() { //using Durstenfeld modern algorithm of the Fisher–Yates shuffle
        for (int i = 0; i < deck.size()-2; i++){ //for i from n−1 down to 1 do the following:
            int j = rand.nextInt(i, deck.size()); //j ← random integer such that 0 ≤ j ≤ i
            Card temp = deck.get(i); //swap deck[i] and deck[j] using a temporary variable (temp)
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    /**
     * Returns a string representation of the deck.
     * @return a string representation of the deck
     */
    public String toString() {
        String output = "";
        for (Card card : deck){
            output += card.toString() + ", ";
        }
        return output;
    }
}