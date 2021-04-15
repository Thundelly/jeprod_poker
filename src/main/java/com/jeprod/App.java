package main.java.com.jeprod;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

public class App {

    // Datahandler access to database
    public DataHandler dataHandler;

    // Player id
    // p1 for player 1
    // p2 for player 2
    public String playerId;

    public void access() throws IOException, ExecutionException, InterruptedException {
        dataHandler = new DataHandler();
        playerId = dataHandler.getPlayerId();

        if (playerId.equals("p1")) {

            // New deck is initialized
            Deck deck = new Deck();

            // p1 hand is initialized
            Game game = new Game(deck, playerId);

            // Make change to database
            game.updateDatabase();

        } else {

            // Old deck from the database is initialized
            Deck deck = new Deck(dataHandler);

            // p2 hand is initialized
            Game game = new Game(deck, playerId);

            // Make change to database
            game.updateDatabase();

            // Reset the playerid to false
            dataHandler.resetPlayerId();

            // End game
//            game.endGame();
        }
    }

    public App() throws IOException {

    }
}
