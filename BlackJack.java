/**
 * Elia Phan
 * CS231 SP23 Project 1
 * BlackJack.java
 * last modified 2/12/2023
 *
 * How to run?
 * Run DeckTests.java to execute test code
 *
 * TURN OFF ACE RULE?: line 20 changed to: public Hand player = new Hand(false);
 *
 * TURN OFF SIX_DECK RULE?: line 23 changed to: public Deck deck = new Deck(false);
 *
 * TURN OFF REAL BLACKJACK RULE?: line 25 changed to: private boolean realBlackJackRule = false;
 *
 * CHOOSE STRATEGY?: Uncomment one line among three lines: line 201, line 202, line 203
 */
public class BlackJack {
    private int reshuffleCutoff; //the number of cards below which the deck must be reshuffled
    public Hand player = new Hand(true); //a Hand object for the player
    //TURN OFF ACE RULE? line 20 changed to: public Hand player = new Hand(false);
    public Hand dealer = new Hand(false); //a Hand object for the dealer
    public boolean isSixDeck = false;
    //TURN OFF SIX_DECK RULE? line 23 changed to: boolean isSixDeck = false;
    public boolean realBlackJackRule = false;
    //TURN OFF REAL BLACKJACK RULE? line 25 changed to: private boolean realBlackJackRule = false;
    public Deck deck = new Deck(isSixDeck); //a Deck object


    /**
     * Constructor that stores the reshuffleCutoff and set up a game
     *
     * @param cutoff: the internal reshuffle cutoff field
     */
    public BlackJack(int cutoff) {
        reshuffleCutoff = cutoff;
        this.reset();
    }


    /**
     * Constructor that set up a game with default reshuffle cutoff of 26
     */
    public BlackJack() {
        this(26);
    }


    /**
     * Reset the game:
     * No cards in both player's Hand and dealer's Hand.
     * If the deck has less card than the reshuffle cutoff, then create a fresh, shuffled deck.
     * Otherwise, the deck is not modified.
     */
    public void reset() {
        player.reset();
        dealer.reset();
        if (deck.size() < reshuffleCutoff) {
            deck = new Deck(isSixDeck);
        }
    }


    /**
     * Deal out two cards to player & dealer from the Deck.
     * Returns true if the player gets a real Blackjack.
     */
    public void deal() {
        for (int j = 0; j < 2; j++) {
            player.add(deck.deal());
            dealer.add(deck.deal());
        }
        if (player.getTotalValue() == 21) {
            player.isRealBlackjack = true;
        }
        if (dealer.getTotalValue() == 21) {
            dealer.isRealBlackjack = true;
        }
    }


    /**
     * Have the player draw cards until the total value of the player's hand >= 16.
     * Return false if the player goes over 21 (bust).
     */
    public boolean playerTurn() {
        Boolean bool;
        while (player.getTotalValue() <= 16) {
            player.add(deck.deal());
        }
        bool = player.getTotalValue() > 21;
        return bool;
    }


    /**
     * Have the player hit or stand based on hard totals rule.
     * Return false if the player goes over 21 (bust).
     */
    public boolean playerTurnHardTotals() {
        Boolean bool;
        while (player.getTotalValue() < 10){        //10 and down always hits.
            player.add(deck.deal());
        }
        while (11 <= player.getTotalValue() && player.getTotalValue() <= 16){           //11-16 stands against dealer 2-6, otherwise hit
            if (2 >= dealer.getCard(0).getValue()){
                player.add(deck.deal());
            } else if (6 <= dealer.getCard(0).getValue()) {
                player.add(deck.deal());
            } else{
                break;
            }
        }
        bool = player.getTotalValue() > 21;
        return bool;
    }


    /**
     * Have the player hit or stand based on hard totals rule and soft total rules.
     * Return false if the player goes over 21 (bust).
     */
    public boolean playerTurnHardSoftTotals() {
        Boolean bool;
        for (int i = 0; i < player.size(); i++) {
            if (player.getCard(i).getValue() == 11) {
                while (player.getTotalValue() >= 11 && player.getTotalValue() <= 16) {       //11-16 stands against dealer 2-6, otherwise hit
                    if (2 >= dealer.getCard(0).getValue() || dealer.getCard(0).getValue() <= 6) {
                        player.add(deck.deal());
                    } else {
                        break;
                    }
                }
                while (player.getTotalValue() == 18) {     //Soft 18 hits against 9-11, otherwise stand.
                    if (9 <= dealer.getCard(0).getValue() || dealer.getCard(0).getValue() <= 11) {
                        player.add(deck.deal());
                    } else{
                        break;
                    }
                    }
                }
            else{
                this.playerTurnHardTotals();
            }
        }
        bool = player.getTotalValue() > 21;
        return bool;
    }


    /**
     * Have the dealer draw cards until the total of the dealer's hand >= 17.
     * Return false if the dealer goes over 21.
     */
    public boolean dealerTurn() {
        Boolean bool;
        while (dealer.getTotalValue() <= 17) {
            dealer.add(deck.deal());
        }
        bool = dealer.getTotalValue() > 21;
        return bool;
    }


    /**
     * Assign the new cutoff value to the internal reshuffle cutoff field.
     */
    public void setReshuffleCutoff(int cutoff) {
        reshuffleCutoff = cutoff;
    }


    /**
     * Returns the current value of the reshuffle cutoff field.
     */
    public int getReshuffleCutoff() {
        return reshuffleCutoff;
    }


    /**
     * Returns a String that has represents the state of the game:
     * Show the player & dealer hands and their current total value.
     */
    public String toString() {
        String output = "";
        output += "Player: " + player.toString() + " & Dealer: " + dealer.toString();
        return output;
    }


    /**
     * Test the above functions: Play 20 games
     * Deal two hands -> Call playerTurn() and dealerTurn() -> Print out the game state
     * CHOOSE STRATEGY?: Uncomment one line among three lines: line 201, line 202, line 203
     */
    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        for (int j = 1; j<20; j++){
            game.deal();
            //game.playerTurn();                        //CHOOSE STRATEGY: basic strategy
            //game.playerTurnHardTotals();              //CHOOSE STRATEGY: hard total rule strategy
            game.playerTurnHardSoftTotals();            //CHOOSE STRATEGY: soft and hard total rule strategy
            game.dealerTurn();
            System.out.println(game.toString());
            System.out.println(game.game(true));
            game.reset();
        }
    }


    /**
     * Determine the winner by comparing two players' totals
     * Return -1 if the dealer wins, 0 in case of a push (tie), and a 1 if the player wins.
     * @param verbose: If verbose == true, print out the initial and final hands of the game and the result: e.g. dealer/push/player.
     */
    public int game(boolean verbose){
        int output = 100;
        String statement = "";

        //Return -1, 0, 1 based on the result & Print out game statement based on parameter:
        if (this.playerTurn() == true) {
            output = -1;
        } else if (this.dealerTurn() == true) {
            output = 1;
        } else if (dealer.getTotalValue() > player.getTotalValue()) {
            output = -1;
        } else if (player.getTotalValue() > dealer.getTotalValue()) {
            output = 1;
        } else if (player.getTotalValue() == dealer.getTotalValue()){
            //if the game applies the real Blackjack rule && the player has a real Blackjack && the dealer doesn't:
            if (realBlackJackRule == true && player.isRealBlackjack && !dealer.isRealBlackjack){
                output = 1; //then, real Blackjack rule counts
            } else {
                output = 0;
            }
        }
        if (verbose) {
            if (output == 1){
                statement = "player wins";}
            else if (output == -1){
                statement = "dealer wins";}
            else if (output == 0){
                statement = "push";}
            System.out.println("player/" + statement + "/dealer");
        }
        return output;
    }
}

