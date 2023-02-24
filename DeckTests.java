/**
 * Elia Phan
 * CS231 SP23 Project 1
 * DeckTests.java
 * last modified 2/12/2023
 * Based on: Prof. Max Bender & Naser Al Madi's original code
 *
 * How to run? in command prompt:
 * javac DeckTests.java
 * java DeckTests
 */

public class DeckTests {

    public static void deckTests() {

        // case 1: testing Deck() and size()
        {
            // set up
            Deck d1 = new Deck(false);

            // verify
            System.out.println(d1);

            // test
            assert d1 != null : "Error in Deck::Deck()";
            assert d1.size() == 52 : "Error in Deck::Deck()";
        }

        // case 2: testing deal()
        {
            // set up
            Deck d1 = new Deck(false);

            // verify

            // test
            Card c1 = d1.deal();

            assert d1 != null : "Error in Deck::deal()";
            assert c1 != null : "Error in Deck::deal()";
            assert d1.size() == 51 : "Error in Deck::deal()";
        }

        // case 3: testing build()
        {
            // set up
            Deck d1 = new Deck(false);

            // verify

            // test
            Card c1 = d1.deal();
            Card c2 = d1.deal();
            Card c3 = d1.deal();
            d1.build();

            assert d1 != null : "Error in Deck::build()";
            assert c1 != null : "Error in Deck::deal()";
            assert c2 != null : "Error in Deck::deal()";
            assert c3 != null : "Error in Deck::deal()";
            assert d1.size() == 52 : "Error in Deck::build()";
        }

        // case 4: testing shuffle()
        {
            // set up
            Deck d1 = new Deck(false);

            // verify


            // test
            String before = d1.toString();
            d1.shuffle();
            String after = d1.toString();


            assert !before.equals(after) : "Error in Deck::shuffle()";
            assert d1.size() == 52 : "Error in Deck::shuffle()";
        }

        // case 5: check correct number of each card


        // case 6: check reshuffle randomness


        System.out.println("*** Done testing Deck! ***\n");
    }


    public static void main(String[] args) {

        deckTests();
    }
}