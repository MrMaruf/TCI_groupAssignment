package casino.cashier;

import casino.bet.Bet;
import casino.bet.MoneyAmount;

public interface ICashier {
    /**
     * Cards are distributed by a Cashier to a gambler
     * bankteller keeps track of which cards are handed out.
     * @return
     */
    IPlayerCard distributeGamblerCard();

    /**
     * When handing in the card at a Bank teller, all betID’s on it are logged.
     * The total amount of money credit is physically handed to the gambler,
     * and the amount stored on the card is changed to zero.
     * The stored betID’s on the card are also removed.
      * @param card
     */
    void returnGamblerCard(IPlayerCard card);

    /**
     * check if Bet made with the playercard is possible. this is based on the amount related
     * to the card, and the amount made in the bet.
     *
     * if the bet is valid, the amount of the bet is subtracted from the amount belonging to
     * the card.
     *
     * @param card
     * @param betToCheck
     * @return
     * @throws BetNotExceptedException
     */
    boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) throws BetNotExceptedException;

    /**
     * add amount to the players card. No negative BetAmounts are allowed.
     *
     * @param card card to add amount to
     * @param amount amount to add to card
     */
    void addAmount(IPlayerCard card, MoneyAmount amount);
}
