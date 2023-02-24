/**
 * Elia Phan
 * CS231 SP23 Project 1
 * Simulation.java
 * last modified 2/12/2023
 *
 * How to run?
 * javac Simulation.java
 * java Simulation
 *
 * TURN OFF ACE RULE?: BlackJack.java line 35 changed to: game.player.isPlayer = false;
 *
 * TURN OFF SIX_DECK RULE?: BlackJack.java line 36 changed to: game.realBlackJackRule = false;
 *
 * TURN OFF REAL BLACKJACK RULE?: BlackJack.java line 37 changed to: game.isSixDeck = false;
 *
 * CHOOSE STRATEGY?: Uncomment one line among three lines: line 42, line 43, line 44
 */

public class Simulation {

    /**
     * Executes 1000 games of Blackjack:
     * Create and re-use a single Blackjack object.
     * Print out how many games the player wins/the dealer wins/are pushes, as raw numbers and as percentages.
     */
    public static void main(String[] args) {
        //initialize and declare fields for the number of times the player/dealer wins and pushes happen
        int playerWin = 0;
        int dealerWin = 0;
        int push = 0;

        //Create a Blackjack object, set up the rule of the game
        BlackJack game = new BlackJack();
        game.player.isPlayer = true;                //true means Ace rule applies, vice versa
        game.realBlackJackRule = true;              //true means real Blackjack rule applies, vice versa
        game.isSixDeck = true;                      //true means sex-deck rule applies, vice versa


        for (int i = 0; i<1000; i++) {
                game.deal();
                //game.playerTurn();                        //CHOOSE STRATEGY: basic strategy
                //game.playerTurnHardTotals();              //CHOOSE STRATEGY: hard total rule strategy
                game.playerTurnHardSoftTotals();            //CHOOSE STRATEGY: soft and hard total rule strategy
                game.dealerTurn();
                if (game.game(false) == 1){playerWin += 1;}
                else if (game.game(false) == -1){dealerWin += 1;}
                else if (game.game(false) == 0){push += 1;}
                game.game(false);
                game.reset();
            }
        int total = playerWin + dealerWin + push;
        double playerPercent = playerWin*100/total;
        double dealerPercent = dealerWin*100/total;
        double tiePercent = push*100/total;
        System.out.println("");
        System.out.println("Ace Rule: " + game.player.isPlayer + "; Real Blackjack Rule: " + game.realBlackJackRule + "; Six-Deck: " + game.isSixDeck);
        System.out.println("Player won " + playerWin + "/1000 times, " + playerPercent + "%");
        System.out.println("Dealer won " + dealerWin + "/1000 times, " + dealerPercent + "%");
        System.out.println("Tie happened " + push + "/1000 times, " + tiePercent + "%");
        }
}
