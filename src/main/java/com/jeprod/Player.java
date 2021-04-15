package main.java.com.jeprod;
import java.util.Vector;

class Player {
    private Vector<Card> _hand = new Vector<>(5);
    private float _money;
    private float _bet;

    // Constructor
    Player() {
        _money = 10000;
    }

    // Add the card to the vector of hand
    void addToHand(Card card) {
        _hand.add(card);
    }

    // Get the vector of hand
    Vector<Card> getHand() {
        return _hand;
    }

    void setMoney(float change) {
        _money += change;
    }

    float getMoney() {
        return _money;
    }

    void setBet(float bet) {
        _bet = bet;
    }

    float getBet() {
        return _bet;
    }
}
