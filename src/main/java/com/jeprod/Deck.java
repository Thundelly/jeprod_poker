package main.java.com.jeprod;

import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.ExecutionException;

class Deck {

    // Create a vector that holds cards
    private Vector<Card> _deck = new Vector<>(52);

    Deck() {
        Card card;

        for (int i = 1; i < 14; i++) {

            card = new Card("s", i);
            _deck.add(card);

            card = new Card("h", i);
            _deck.add(card);

            card = new Card("c", i);
            _deck.add(card);

            card = new Card("d", i);
            _deck.add(card);
        }

        // Shuffle the deck
        Collections.shuffle(_deck);
        System.out.println("New Deck Initialized.");
    }

    // For player 2
    // Another deck constructor
    // This constructor does not create a new deck, but make a deck class by taking data from database
    Deck(DataHandler dataHandler) throws ExecutionException, InterruptedException {
        _deck = dataHandler.getDeckCard();
        System.out.println("Old Deck Initialized.");
    }

    // Remove card from the deck
    Card remove() {
        Card removedCard = new Card(_deck.firstElement().getSuit(), _deck.firstElement().getValue());
        _deck.remove(_deck.firstElement());

        return removedCard;
    }

    Vector<Card> getRemainingDeck() {
        return _deck;
    }
}
