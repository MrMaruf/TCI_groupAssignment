package casino.bet;

import ID.BetID;

/**
 * immutable class.
 * keeps unique betID and moneyamount in the bet.
 */
public class Bet {
    private BetID betID;
    private MoneyAmount moneyAmount;

    /**
     * Constructor that takes 2 arguments and creates an object Bet.
     * @param betID
     * @param moneyAmount
     */
    public Bet(BetID betID, MoneyAmount moneyAmount) {
        this.betID = betID;
        this.moneyAmount = moneyAmount;
    }

    /**
     * returns ID of the Bet
     * @return BetID
     */
    public BetID getBetID() {
        return betID;
    }

    /**
     * returns MoneyAmount placed on the Bet
     * @return MoneyAmount
     */
    public MoneyAmount getMoneyAmount() {
        return moneyAmount;
    }
}
