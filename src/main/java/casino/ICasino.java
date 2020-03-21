package casino;

import casino.bet.Bet;
import casino.cashier.IPlayerCard;
import casino.game.IGame;

public interface ICasino {
    /**
     * method to add a named game to the casino
     * <p>
     *
     *
     * @param gameToAdd
     */
    void addGame(String gameName, IGame gameToAdd);

    /**
     * method to get a game in a casino
     * <p>
     *
     *
     * @return
     */
    IGame getGame(String name);

    /**
     * check if bet is valid.
     * <p>
     *
     *
     * @param card       card which makes the bet
     * @param betToCheck bet to check if it's possible to make using this card.
     * @return true when bet is possible, otherwise false
     */
    boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck);
}
