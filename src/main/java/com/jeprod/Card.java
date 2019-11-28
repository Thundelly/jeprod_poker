package com.jeprod;

class Card {

    private String _suit;       // 1. Spade 2. Heart 3. Club 4. Diamond
    private int _value;

    Card(String suit, int value) {
        setSuit(suit);
        setValue(value);
    }

    private void setSuit(String suit) {
        _suit = suit;
    }

    private void setValue(int value) {
        _value = value;
    }

    String getSuit() {
        return _suit;
    }

    int getValue() {
        return _value;
    }
}
