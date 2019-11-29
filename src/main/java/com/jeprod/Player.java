package com.jeprod;

import java.util.Vector;

class Player {
    private Vector<Card> _hand = new Vector<>(5);
    private float _money;

    private void addToHand(Card card) {
        _hand.add(card);
    }

    Vector<Card> getHand() {
        return _hand;
    }

    private void setMoney(float change) {
        _money += change;
    }

    float getMoney() {
        return _money;
    }

    
}
