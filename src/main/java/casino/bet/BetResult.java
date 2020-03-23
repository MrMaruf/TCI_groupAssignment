package casino.bet;

/**
 * Immutable class.
 * contains the Bet which won, together with the amount won.
 */
public class BetResult {
    private Bet winningBet;  // original bet which won.
    private MoneyAmount amountWon;

    /**
     * Creates an object
     * @param winningBet
     * @param amountWon
     */
    public BetResult(Bet winningBet, MoneyAmount amountWon) {
        this.winningBet = winningBet;
        this.amountWon = amountWon;
    }

    /**
     * @return winning bet
     */
    public Bet getWinningBet() {
        return winningBet;
    }

    /**
     * @return how much money was won
     */
    public MoneyAmount getAmountWon() {
        return amountWon;
    }
}

