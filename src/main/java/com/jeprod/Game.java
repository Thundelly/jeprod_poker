package main.java.com.jeprod;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

class Game {
    private String _playerId;
    float totalBet = 0;

    private Deck _deck;
    private Player player = new Player();
    private DataHandler dataHandler = new DataHandler();

    // Initialize the game
    Game(Deck deck, String playerId) throws IOException {

        _playerId = playerId;

        // Create hand from the deck
        // remove function deletes card from the deck
        for (int i = 0; i < 5; i++) {
            player.addToHand(deck.remove());
        }

        // Read deck
        _deck = deck;

        // Setting the default bet value
        float defaultBet = 100;
        player.setBet(defaultBet);
    }

    void turn() {

    }

//    void turn() throws ExecutionException, InterruptedException {
//        Scanner scan = new Scanner(System.in);
//
//        System.out.println(_playerId + "'s turn: \n");
//        readDatabase();
//
//        System.out.println("[R]aise, [C]all, [F]old.");
//        char decision = scan.next().toLowerCase().charAt(0);
//
//        switch (decision) {
//            case 'r':
//                break;
//            case 'c':
//                break;
//            case 'f':
//                break;
//        }
//    }

    // Update the new hand
    // Update the new deck
    void updateDatabase() throws ExecutionException, InterruptedException {
        int numOfCards = 0;

        Evaluator evaluator = new Evaluator(player.getHand());
        int value = evaluator.evaluate();

        // Update p1 cards
        if (_playerId.equals("p1")) {
            for (Card card : player.getHand()) {
                numOfCards++;
                dataHandler.writer("p1", card, numOfCards, player.getMoney(), player.getBet(), value);
            }

            numOfCards = 10;

            for (Card card : _deck.getRemainingDeck()) {
                numOfCards++;
                dataHandler.writer("deck", card, numOfCards, null, null, null);
            }

        // Update p2 cards
        } else if (_playerId.equals("p2")) {
            for (Card card : player.getHand()) {
                numOfCards++;
                dataHandler.writer("p2", card, numOfCards, player.getMoney(), player.getBet(), value);
            }

            numOfCards = 10;

            for (Card card : _deck.getRemainingDeck()) {
                numOfCards++;
                dataHandler.writer("deck", card, numOfCards, null, null, null);
            }
        }
    }

    void readDatabase() throws ExecutionException, InterruptedException {
//        dataHandler.reader("p1");
//        dataHandler.reader("p2");
    }

    void setPlayerId() throws ExecutionException, InterruptedException {
        dataHandler.getPlayerId();
    }

    // End game for DEBUGGING PURPOSES
    void endGame() throws ExecutionException, InterruptedException {
        // First value is p1 hand, second value is p2 hand
        int[] handvalues = dataHandler.getHandValues();

        System.out.println(handvalues[0]);
        System.out.println(handvalues[1]);

        if (handvalues[0] > handvalues[1]) {
            System.out.println("Player 1 wins!");

        } else {
            System.out.println("Player 2 wins!");
        }
    }
}