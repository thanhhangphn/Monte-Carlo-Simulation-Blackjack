/**
 * Elia Phan
 * CS231 SP23 Project 1
 * Card.java
 * last modified 2/12/2023
 * Based on: Prof. Max Bender & Naser Al Madi's original outline
 *
 * How to run?
 * Run CardTests.java to execute test code
 */
public class Card {

    /**
     * The value of the card.
     */
    private int value;

    /**
     * Constructs a card with the specified value.
     * @param val is the specified value
     */
    public Card(int val) {
        value = val;
    }

    /**
     * Returns the value of the card.
     * @return the value of the card
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns a string representation of this card.
     * @return a string representation of this card
     */
    public String toString() {
        return value + "";
    }
}
