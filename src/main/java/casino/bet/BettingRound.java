package casino.bet;

import ID.BettingRoundID;
import bettingauthoritiyAPI.BetToken;
import casino.game.IBettingRound;

import java.util.List;
import java.util.Set;

public class BettingRound implements IBettingRound {

    private List<Bet> allBets;

    private BetToken token;

    public BettingRound(BetToken token){
        this.token = token;
    }
    @Override
    public BettingRoundID getBettingRoundID() {
        return null;
    }

    @Override
    public boolean placeBet(Bet bet) {
        return false;
    }

    @Override
    public Set<Bet> getAllBetsMade() {
        return null;
    }

    @Override
    public BetToken getBetToken() {
        return null;
    }

    @Override
    public int numberOFBetsMade() {
        return 0;
    }
}
