package casino.gamingmachine;

import casino.bet.BetResult;
import casino.cashier.IPlayerCard;

public interface IGamingMachine {
    /**
     *
     * @param amountInCents
     * @return
     */
    boolean placeBet(long amountInCents) throws NoPlayerCardException;

    /**
     * Accept the BetResult from the winner. clear all open bets on this machine.
     * when the winner has made his bet in this machine: let the Cashier update the amount.
     * @param winResult
     */
    void acceptWinner(BetResult winResult);

    /**
     * getter
     * @return gamingmachineID
     */
    GamingMachineID getGamingMachineID();

    /**
     * connect card to this gaming machine
     * @param card
     */
    void connectCard(IPlayerCard card);

}
