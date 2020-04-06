package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameRule implements IGameRule {
    int maxBetsPerRound;

    public GameRule(int maxBetsPerRound){
        this.maxBetsPerRound = maxBetsPerRound;
    }

    @Override
    public BetResult determineWinner(Integer randomWinValue, Set<Bet> bets) {
        if(bets.size() == 0){
            return null;
        }
        List<Bet> allBets = new ArrayList<>(bets);
        Bet winner = allBets.get(randomWinValue % allBets.size());
        MoneyAmount amountWon = null;
        amountWon = new MoneyAmount(winner.getMoneyAmount().getAmountInCents() * 2);
        return new BetResult(winner, amountWon);
    }

    @Override
    public int getMaxBetsPerRound() {
        return maxBetsPerRound;
    }
}
