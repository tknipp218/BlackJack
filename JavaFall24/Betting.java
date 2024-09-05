public class Betting {
    int playerChips;
    int betAmount;
    
    public int winBet() {
        return playerChips += (betAmount * 2);
    }

    public double winBlackjack() {
        return playerChips += (betAmount * 2 * 1.5);
    }

    public double loseBet() {
        double playerChips -= double betAmount;
    }
    
}


