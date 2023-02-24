/**
 * Elia Phan
 * CS231 SP23 Project 1
 * CardTests.java
 * last modified 2/12/2023
 * Based on: Prof. Max Bender & Naser Al Madi's original code
 *
 * How to run? in command prompt:
 * javac CardTests.java
 * java CardTests
 */
public class CardTests {
    public static void cardTests() {

        // case 1: testing Card(i)
        {
            // set up
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1 + " == 5");
            System.out.println(c2 + " == 10");

            // test
            assert c1 != null : "Error in Card::Card()";
            assert c2 != null : "Error in Card::Card()";
        }

        // case 2: testing getValue()
        {
            // set up
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1.getValue() + " == 5");
            System.out.println(c2.getValue() + " == 10");

            // test
            assert c1.getValue() == 5 : "Error in Card::Card() or Card::getValue()";
            assert c2.getValue() == 10 : "Error in Card::Card() or Card::getValue()";
        }

        // case 3: testing toString()
        {
            // set up
            Card c1 = new Card(5);
            Card c2 = new Card(10);

            // verify
            System.out.println(c1.toString() + " == 5");
            System.out.println(c2.toString() + " == 10");

            // test
            assert c1.toString().equals("5") : "Error in Card::toString()";
            assert c2.toString().equals("10") : "Error in Card::toString()";
        }

        System.out.println("*** Done testing Card! ***\n");
    }


    public static void main(String[] args) {

        cardTests();
    }
}
