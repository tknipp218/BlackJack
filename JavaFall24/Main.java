import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public int getValue() {
        switch (rank) {
            case "Ace":
                return 1;
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "10":
            case "Jack":
            case "Queen":
            case "King":
                return 10;
            default:
                return 0;
            
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}

class Hand {
    private ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();

    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int value = 0;
        int aceCount = 0;

        for (Card card : cards) {
            value += card.getValue();
            if (card.toString().startsWith("Ace")) {
                aceCount++;
            }
        }

        while (value <= 11 && aceCount > 0) {
            value += 10;
            aceCount--;
        }

        return value;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        BlackjackGame game = new BlackjackGame();
        game.startGame();
    }
}

/*
 *Cards = (ace(needs to be 1 or 11), 2-10, jack(worth 10), queen(worth 10), king(worth 10))
 *playerHand
 *dealerHand
 *How many playes?
*/
