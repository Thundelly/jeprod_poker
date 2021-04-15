package main.java.com.jeprod;
import java.util.*;

class Evaluator {
    private Vector<Card> _hand;

    Evaluator(Vector<Card> hand) {
        _hand = hand;
    }

    int evaluate() {
        int highestValue = 0;

        int _value;

        if (Boolean.parseBoolean(isOnePair().get(0).toString())) {
            _value = 20 + Integer.parseInt(isOnePair().get(1).toString());

        } else if (Boolean.parseBoolean(isTwoPair().get(0).toString())) {
            _value = 40 + Integer.parseInt(isTwoPair().get(1).toString());

        } else if (Boolean.parseBoolean(isThreeOfAKind().get(0).toString())) {
            _value = 60 + Integer.parseInt(isThreeOfAKind().get(1).toString());

        } else if (Boolean.parseBoolean(isFullHouse().get(0).toString())) {
            _value = 80 + Integer.parseInt(isFullHouse().get(1).toString());

        } else if (Boolean.parseBoolean(isFourOfAKind().get(0).toString())) {
            _value = 100 + Integer.parseInt(isFourOfAKind().get(1).toString());

        } else if (Boolean.parseBoolean(isStraight().get(0).toString())) {
            _value = 120 + Integer.parseInt(isStraight().get(1).toString());

        } else if (Boolean.parseBoolean(isFlush().get(0).toString())) {
            _value = 140 + Integer.parseInt(isFlush().get(1).toString());

        } else {
            for (int i = 0; i < _hand.size(); i++) {
                if (_hand.elementAt(i).getValue() > highestValue) {
                    highestValue = _hand.elementAt(i).getValue();
                }
            }

            _value = highestValue;
        }

        return _value;
    }

    private List<Object> isOnePair() {
        for (int i = 0; i < _hand.size(); i++) {
            for (int j = i + 1; j < _hand.size(); j++) {
                if (_hand.elementAt(i).getValue() == _hand.elementAt(j).getValue()) {
                    return Arrays.asList(true, _hand.elementAt(i).getValue());
                }
            }
        }
        return Collections.singletonList(false);
    }

    private List<Object> isTwoPair() {
        int numOfPair = 0;
        int higherPair = 0;

        for (int i = 0; i < _hand.size(); i++) {
            for (int j = i + 1; j < _hand.size(); j++) {
                if (_hand.elementAt(i).getValue() == _hand.elementAt(j).getValue()) {
                    numOfPair++;
                    if (_hand.elementAt(i).getValue() > higherPair) {
                        higherPair = _hand.elementAt(i).getValue();
                    }
                }
            }
        }
        // true if 2, false if less than 2
        if (numOfPair == 2) {
            return Arrays.asList(true, higherPair);
        } else {
            return Collections.singletonList(false);
        }
    }

    private List<Object> isThreeOfAKind() {
        for (int i = 0; i < _hand.size(); i++) {
            for (int j = i + 1; j < _hand.size(); j++) {
                for (int k = j + 1; k < _hand.size(); k++) {
                    if (_hand.elementAt(i).getValue() == _hand.elementAt(j).getValue()
                            && _hand.elementAt(j).getValue() == _hand.elementAt(k).getValue()) {

                        return Arrays.asList(true, _hand.elementAt(i).getValue());
                    }
                }
            }
        }
        return Collections.singletonList(false);
    }

    private List<Object> isFullHouse() {
        // If there are two pairs, and one three of a kind, it's full house
        if (Boolean.parseBoolean(isTwoPair().get(0).toString())
                && Boolean.parseBoolean(isThreeOfAKind().get(0).toString())) {

            return Arrays.asList(true,
                    Integer.parseInt(isTwoPair().get(1).toString())
                    + Integer.parseInt(isThreeOfAKind().get(1).toString()));
        }
        return Collections.singletonList(false);
    }

    private List<Object> isFourOfAKind() {
        for (int i = 0; i < _hand.size(); i++) {
            for (int j = i + 1; j < _hand.size(); j++) {
                for (int k = j + 1; k < _hand.size(); k++) {
                    for (int l = k + 1; l < _hand.size(); l++) {
                        if (_hand.elementAt(i).getValue() == _hand.elementAt(j).getValue()
                                && _hand.elementAt(j).getValue() == _hand.elementAt(k).getValue()
                                && _hand.elementAt(k).getValue() == _hand.elementAt(l).getValue()) {

                            return Arrays.asList(true, _hand.elementAt(i).getValue());
                        }
                    }

                }
            }
        }
        return Collections.singletonList(false);
    }

    private List<Object> isStraight() {
        int[] values = new int[] {
                _hand.elementAt(0).getValue(),
                _hand.elementAt(1).getValue(),
                _hand.elementAt(2).getValue(),
                _hand.elementAt(3).getValue(),
                _hand.elementAt(4).getValue()};

        Arrays.sort(values);
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] + 1 != values[i + 1]) {
                return Collections.singletonList(false);
            }
        }
        return Arrays.asList(true, _hand.elementAt(4).getValue());
    }

    // Did not implement the royal flush
    private List<Object> isFlush() {
        // If all suits are equal, then flush
        return Arrays.asList((_hand.elementAt(0).getSuit().equals(_hand.elementAt(1).getSuit())
                && _hand.elementAt(0).getSuit().equals(_hand.elementAt(2).getSuit())
                && _hand.elementAt(0).getSuit().equals(_hand.elementAt(3).getSuit())
                && _hand.elementAt(0).getSuit().equals(_hand.elementAt(4).getSuit())),

                _hand.elementAt(0).getValue());
    }
}
