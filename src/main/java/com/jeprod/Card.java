package main.java.com.jeprod;

class Card {

    private String _suit;       // 1. Spade 2. Heart 3. Club 4. Diamond

    // J: 11
    // Q: 12
    // K: 13
    private int _value;         // Value of the card

    // Constructor
    Card(String suit, int value) {
        setSuit(suit);
        setValue(value);
    }

    // Set suits
    private void setSuit(String suit) {
        _suit = suit;
    }

    // Set value of the cards
    private void setValue(int value) {
        _value = value;
    }

    // Access suits
    String getSuit() {
        return _suit;
    }

    // Access values of the cards
    int getValue() {
        return _value;
    }
}
