import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;

    public BlackjackGame() {
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand();
        dealerHand = new Hand();
    }

    public void startGame() {
        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());
        dealerHand.addCard(deck.dealCard());

        System.out.println("Player's hand: " + playerHand);
        System.out.println("Dealer's hand: " + dealerHand.cards.get(0) + " and [Hidden]");

        playerTurn();
        dealerTurn();
        determineWinner();
    }

    private void playerTurn() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Player's hand value: " + playerHand.getValue());
            if(playerHand.getValue() > 21) {
                System.out.println("Player busts!");
                return;
            }
            System.out.println("Do you want to hit or stand? (h/s)");
            String action = scanner.nextLine();
            if (action.equals("h")) {
                playerHand.addCard(deck.dealCard());
                System.out.println("Player's hand: " + playerHand);
            } else {
                break;
            }
        }
    }

    private void dealerTurn() {
        System.out.println("Dealer's hand: " + dealerHand);
        while (dealerHand.getValue() < 17) {
            dealerHand.addCard(deck.dealCard());
            System.out.println("Dealer's hand: " + dealerHand);
        }
        if (dealerHand.getValue() > 21) {
            System.out.println("Dealer busts!");
        }
    }
    private void determineWinner() {
        int playerValue = playerHand.getValue();
        int dealerValue = dealerHand.getValue();

        System.out.println("Player's hand value: " + playerValue);
        System.out.println("Dealer's hand value: " + dealerValue);

        if (playerValue > 21) {
            System.out.println("Dealer wins!");
        } else if (dealerValue > 21) {
            System.out.println("Player wins!");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins!");
        } else if (dealerValue > playerValue) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();
    }
}