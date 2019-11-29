package com.jeprod;

import java.util.Collections;
import java.util.Vector;

class Deck {

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
        Collections.shuffle(_deck);
    }

    private Card remove() {
        Card removedCard = new Card(_deck.firstElement().getSuit(), _deck.firstElement().getValue());
        _deck.remove(_deck.firstElement());

        return removedCard;
    }

    Vector<Card> getRemainingDeck() {
        return _deck;
    }
}
