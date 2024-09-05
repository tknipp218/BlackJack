public class Card {
    //instance variables
    private String suit;
    private String rank;

    //establishes the suit and rank of the card
    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    //gets the suit of the card
    public String getSuit() {
        return suit;
    }

    //gets the rank of the card
    public String getRank() {
        return rank;
    }

    //gets the value of the card
    public int getValue() {
        switch (rank) {
            case "Ace":
                return 11;
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

    //returns the rank and suit of the card
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
