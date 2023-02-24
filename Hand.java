/**
 * Elia Phan
 * CS231 SP23 Project 1
 * Hand.java
 * last modified 2/12/2023
 * Based on: Prof. Max Bender & Naser Al Madi's original outline
 *
 * How to run?
 * Run HandTests.java to execute test code
 */

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand; //declare a hand as an ArrayList of Cards
    public boolean isPlayer; //declare a field distinguishing player and dealer
    public boolean isRealBlackjack = false; //true when the hand have 2 cards totalling 21, otherwise false


    /**
     * Creates an empty hand as an ArrayList of Cards.
     */
    public Hand(boolean thisIsPlayer) {
        hand = new ArrayList<>();       //initialize a hand as an ArrayList of Cards
        isPlayer = thisIsPlayer;
    }


    /**
     * Removes any cards currently in the hand.
     */
    public void reset(){
        if (this.size()>0){
            hand.clear();
        }
    }


    /**
     * Adds the specified card to the hand.
     * @param card the card to be added to the hand
     */
    public void add(Card card){
        hand.add(card);
    }


    /**
     * Returns the number of cards in the hand.
     * @return the number of cards in the hand
     */
    public int size(){
        return hand.size();
    }


    /**
     * Returns the card in the hand specified by the given index.
     * @param index the index of the card in the hand.
     * @return the card in the hand at the specified index.
     */
    public Card getCard(int index){
        return hand.get(index);
    }


    /**
     * Returns the summed value over all cards in the hand.
     * @return the summed value over all cards in the hand
     */
    public int getTotalValue(){
        int sum = 0;
        for (Card card : hand) {
            // if the hand is of the player && there is an Ace (represented by an 11), the Ace rule counts
            if (this.isPlayer && card.getValue() == 11 && sum + 11 > 21){
                sum += 1;
            }
            // otherwise, calculate the sum as normal
            else {
                sum += card.getValue();
            }
        }
        return sum;
    }


    /**
     * Returns a string representation of the hand.
     * @return a string representation of the hand
     */
    public String toString(){
        String output = "[";
        for (int i = 0; i < hand.size()-1; i++){
            output += hand.get(i).toString() + ", ";
        }
        if (hand.size() > 0){
            output += hand.get(hand.size()-1).toString();
        }
        output += "] : " + this.getTotalValue();
        return output;
    }
}
