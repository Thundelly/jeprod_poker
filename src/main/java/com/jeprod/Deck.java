package com.jeprod;
import com.jeprod.Card;

import java.util.Collections;
import java.util.Vector;

class Deck {

    private Vector<Card> deck = new Vector<>();

    Deck() {
        Card card;

        for (int i = 1; i < 14; i++) {

            card = new Card("s", i);
            deck.add(card);

            card = new Card("h", i);
            deck.add(card);

            card = new Card("c", i);
            deck.add(card);

            card = new Card("d", i);
            deck.add(card);
        }
        Collections.shuffle(deck);
    }

    private Card remove() {
        Card removedCard = new Card(deck.firstElement().getSuit(), deck.firstElement().getValue());
        deck.remove(deck.firstElement());

        return removedCard;
    }



}
