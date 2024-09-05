import java.util.Scanner;

public class BlackjackGame {
    //instance variables
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private Scanner scanner;

    //sets up the game
    public BlackjackGame() {
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand();
        dealerHand = new Hand();
        scanner = new Scanner(System.in);
    }

    //starts the game
    public void startGame() {
        try {
            //deals the cards
            playerHand.addCard(deck.dealCard());
            playerHand.addCard(deck.dealCard());
            dealerHand.addCard(deck.dealCard());
            dealerHand.addCard(deck.dealCard());

            //player's turn
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

            //dealer's turn
            while (dealerHand.getValue() < 17) {
                dealerHand.addCard(deck.dealCard());
            }

            //gets the value of the hands
            int playerValue = playerHand.getValue();
            int dealerValue = dealerHand.getValue();
            
            System.out.println("Player's hand: " + playerValue);
            System.out.println("Dealer's hand: " + dealerValue);

            //determines the winner
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