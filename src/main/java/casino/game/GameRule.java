package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameRule implements IGameRule {
    private int maxBets;

    public GameRule(int maxBets){
        this.maxBets = maxBets;
    }

    @Override
    public BetResult determineWinner(Integer randomWinValue, Set<Bet> bets) {
       Bet bet = null;
       List<Bet> bets_array = new ArrayList<>();

        for(Bet b: bets){
           bets_array.add(b);
       }

        for(Bet b: bets_array){
            bet = bets_array.get(randomWinValue);
        }

        return new BetResult(bet, bet.getMoneyAmount());
    }

    @Override
    public int getMaxBetsPerRound() {
        return maxBets;
    }
}
