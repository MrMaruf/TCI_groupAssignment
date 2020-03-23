package casino.bet;

import java.util.Currency;

/**
 * immutable object representing an amount of money.
 * For demo purposes: hardocded USD
 */
public class MoneyAmount {
    private long amountInCents;
    private Currency currency;

    /**
     * Creates an object
     * @param amountInCents
     */
    public MoneyAmount(long amountInCents) {
        this.amountInCents = amountInCents;
        this.currency = Currency.getInstance("USD");
    }

    /**
     * @return the amount of money in USD Cents
     */
    public long getAmountInCents() {
        return amountInCents;
    }
}
