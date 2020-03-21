package bettingauthoritiyAPI;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.game.IBettingRound;

import java.util.Set;

public interface IBetLoggingAuthority {
    /**
     * this method logs when a PlayerCard has been handed out to a Gambler.
     * <p>
     * it's used for logging purposes by the betlogging authority.
     */
    public void handOutGamblingCard(GeneralID card);

    /**
     * this method logs the PlayerCard which is turned in by a Gambler.
     * All betID's on it are logged by the authority.
     * <p>
     * <p>
     * it's used for logging purposes by the betlogging authority.
     */
    public void handInGamblingCard(GeneralID card, Set<BetID> betsMade);

    /**
     * this method logs when a BettingRound starts. It should be called before any submitted bets are added to
     * a betting round.
     * <p>
     * it's used for logging purposes by the betlogging authority.
     */
    void startBettingRound(IBettingRound startingBettingRound);

    /**
     * this method logs an accepted bet by a BettingRound. It should be called:
     * after startBettingRound is called,
     * before endBettingRound is called
     * <p>
     * <p>
     * it's used for logging purposes by the betlogging authority.
     */
    void addAcceptedBet(Bet acceptedBet, BettingRoundID bettingRoundID, GamingMachineID gamingMachineID);

    /**
     * this method logs when a BettingRound ends. It should be called after the winner of a betting round
     * has been decided. all information in the betting Round are logged by the authority.
     * <p>
     * it's used for logging purposes by the betlogging authority.
     */
    void endBettingRound(IBettingRound endedBettingRound, BetResult result);
}
