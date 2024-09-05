import java.util.Collections;
import java.util.Stack;

public class Deck {
    //stack of cards
    private Stack<Card> cards;

    //creates a deck of cards
    public Deck() {
        cards = new Stack<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        for (String suit : suits) {
            for (String rank : ranks) {
                cards.add(new Card(suit, rank));
            }
        }
    }

    //shuffles the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    //deals a card from the deck
    public Card dealCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Deck is empty");
        }
        return cards.pop();
    }
}
