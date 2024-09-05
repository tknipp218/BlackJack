import java.util.ArrayList;
import java.util.List;

public class Hand {
    public List<Card> cards;

    public Hand() {
        cards = new ArrayList<>();

    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public int getValue() {
        int value = 0;
        int aces = 0;

        for (Card card : cards) {
            int cardValue = card.getValue();
            if (card.toString().startsWith("Ace")) {
                aces++;
            }
            value += cardValue;
        }

        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }

    @Override
    public String toString() {
        return cards.toString();
    }
}
