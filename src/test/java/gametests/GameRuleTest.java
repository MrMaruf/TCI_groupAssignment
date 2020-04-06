package gametests;

import ID.BetID;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.game.IGameRule;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameRuleTest {
    @Test
    public void GameRule_determineWinner_Should_Return_The_Correct_BetResult_Test(){

        List<Bet> bets = mock(List.class);
        long l = 10;
        bets.add(new Bet(new BetID(), new MoneyAmount(l)));
        bets.add(new Bet(new BetID(), new MoneyAmount(l)));
        Random rn = mock(Random.class);
        when(rn.nextInt()).thenReturn(1);
        int random = rn.nextInt();
        Bet bet = null;
        IGameRule sut = new GameRule(5);
        when(bets.size()).thenReturn(sut.getMaxBetsPerRound());
        for(Bet b: bets){
            bet = bets.get(random);
        }

        BetResult betResult = new BetResult(bet, bet.getMoneyAmount());

        sut.determineWinner(random, (Set<Bet)bets);

        Assert.assertEquals(sut.determineWinner(random, ((Set<Bet)bets)), betResult);


    }
}
