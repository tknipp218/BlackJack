import java.util.Scanner;

public class BlackjackGame {
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private Scanner scanner;

    public BlackjackGame() {
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand();
        dealerHand = new Hand();
        scanner = new Scanner(System.in);
    }

    public void startGame() {
        try {
            playerHand.addCard(deck.dealCard());
            playerHand.addCard(deck.dealCard());
            dealerHand.addCard(deck.dealCard());
            dealerHand.addCard(deck.dealCard());

            while (true) {
                System.out.println("Player hand: " + playerHand);
                if (playerHand.getValue() > 21) {
                    System.out.println("Player busts!");
                    break;
                }
                System.out.println("Do you want to hit or stand? (h/s)");
                String input = scanner.nextLine();
                if (input.equals("h")) {
                    playerHand.addCard(deck.dealCard());
                } else if (input.equals("s")) {
                    break;
                }
            }

            while (dealerHand.getValue() < 17) {
                dealerHand.addCard(deck.dealCard());
            }

            int playerValue = playerHand.getValue();
            int dealerValue = dealerHand.getValue();

            System.out.println("Player's hand: " + playerValue);
            System.out.println("Dealer's hand: " + dealerValue);

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
        } finally {
            scanner.close();
        }
    }
}