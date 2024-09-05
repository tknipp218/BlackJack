public class Betting {
    private int playerChips;
    private int betAmount;
    
    public Betting(int initialChips) {
        this.playerChips = initialChips;
    }

    public boolean placeBet(int amount) {
        if (amount > playerChips) {
            System.out.println("You don't have enough chips to place that bet.");
            return false;
        }
        this.betAmount = amount;
        playerChips -= amount;
        return true;
    }

    public void winBet() {
        playerChips += (betAmount * 2);
        betAmount = 0;
    }

    public void winBlackJack() {
        playerChips += (betAmount * 2.5);
        betAmount = 0;
    }

    public void loseBet() {
        betAmount = 0;
    }

    public int getPlayerChips() {
        return playerChips;
    }
}


