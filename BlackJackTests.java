/**
 * Elia Phan
 * CS231 SP23 Project 1
 * BlackJackTests.java
 * last modified 2/12/2023
 * Based on: Prof. Max Bender & Naser Al Madi's original code
 *
 * How to run?
 * javac BlackJackTests.java
 * java BlackJackTests
 */


public class BlackJackTests {

    public static void blackJackTests() {

        // case 1: testing BlackJack() and BlackJack(i)
        {
            // set up
            BlackJack bj1 = new BlackJack();
            BlackJack bj2 = new BlackJack(5);

            // verify

            // test
            assert bj1 != null : "Error in BlackJack::BlackJack()";
            assert bj2 != null : "Error in BlackJack::BlackJack()";
        }


        // case 2: testing reset();
        {
            // set up
            BlackJack bj1 = new BlackJack();

            // verify

            // test
            bj1.reset();
            assert bj1.player.size() == 0 : "Error in BlackJack::reset()";
            assert bj1.dealer.size() == 0 : "Error in BlackJack::reset()";
            assert bj1.deck.size() > 26: "Error in BlackJack::deal()";
        }


        // case 3: testing reset();
        {
            // set up
            BlackJack bj1 = new BlackJack();

            // verify

            // test
            bj1.deal();
            assert bj1.player.size() == 1 : "Error in BlackJack::deal()";
            assert bj1.dealer.size() == 1 : "Error in BlackJack::deal()";
        }

        System.out.println("*** Done testing BlackJack! ***\n");
    }

    public static void main(String[] args) {
        blackJackTests();
    }
}
