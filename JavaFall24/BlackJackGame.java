import java.util.Scanner;

public class BlackJackGame {
    //instance variables
    private Deck deck;
    private Hand playerHand;
    private Hand dealerHand;
    private Betting betting;
    private Scanner scanner;

    //sets up the game
    public BlackJackGame() {
        deck = new Deck();
        deck.shuffle();
        playerHand = new Hand();
        dealerHand = new Hand();
        this.betting = new Betting(100);
        scanner = new Scanner(System.in);
    }

    //starts the game
    public void startGame() {
        try {
            while (true) {
                Thread.sleep(1000);
                System.out.println("\nYou have " + betting.getPlayerChips() + " chips.");
                Thread.sleep(1000);
                System.out.println("Place your bet: ");
                int betAmount = scanner.nextInt();
                scanner.nextLine();

                if (!betting.placeBet(betAmount)) {
                    System.out.println("Betting failed. Try again.");
                    continue;
                }

                //deals the cards
                playerHand.clear();
                dealerHand.clear();
                playerHand.addCard(deck.dealCard());
                playerHand.addCard(deck.dealCard());
                dealerHand.addCard(deck.dealCard());
                dealerHand.addCard(deck.dealCard());

                if (playerHand.getValue() == 21) {
                    Thread.sleep(1000);
                    System.out.println("\nPlayer has a blackjack!");
                    betting.winBlackJack();
                    continue;
                }

                //player's turn
                while (true) {
                    System.out.println("\nPlayer hand: " + playerHand);
                    System.out.println("Dealer hand: " + dealerHand.get(0));
                    if (playerHand.getValue() > 21) {
                        System.out.println("You just BUSTamante'd!");
                        betting.loseBet();
                        break;
                    }
                    Thread.sleep(1000);
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
            
                Thread.sleep(1000);
                System.out.println("\nPlayer's hand: " + playerValue);
                System.out.println("Dealer's hand: " + dealerValue);

                //determines the winner
                if (playerValue > 21) {
                    Thread.sleep(1000);
                    System.out.println("\nDealer wins!");
                } else if (dealerValue > 21) {
                    Thread.sleep(1000);
                    System.out.println("\nPlayer wins!");
                    betting.winBet();
                } else if (playerValue > dealerValue) {
                    Thread.sleep(1000);
                    System.out.println("\nPlayer wins!");
                    betting.winBet();
                } else if (dealerValue > playerValue) {
                    Thread.sleep(1000);
                    System.out.println("\nDealer wins!");
                } else {
                    Thread.sleep(1000);
                    System.out.println("\nIt's a tie!");
                    betting.tieBet();    
                }

                if (betting.getPlayerChips() == 0) {
                    System.out.println("Thanks for the chips! Come back when you have more.");
                    break;
                }

                System.out.println("You now have " + betting.getPlayerChips() + " chips.");

                System.out.println("Play another hand? (y/n)");
                String response = scanner.nextLine();
                if (!response.equals("y")) {
                    System.out.println("Are you sure you want to quit? (y/n)");
                    String response2 = scanner.nextLine();
                    if (response2.equals("y")) {
                        System.out.println("Everyone quits before their big win. Try again (y/n)");
                        String response3 = scanner.nextLine();
                        if (!response3.equals("y")) {
                            System.out.println("Come back when you're ready to win big!");
                            System.out.println("Final chip count: " + betting.getPlayerChips());
                            break;      
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}