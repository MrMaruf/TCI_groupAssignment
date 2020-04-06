package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.mockito.Mockito.mock;

public class GameRuleTest {
    @Test
    public void determineWinner_Should_Return_The_Correct_betResult_Test(){
        // assign
        IGameRule rule = new GameRule(2);
        Set<Bet> bets = new HashSet<>();
        // mocking
        bets.add(mock(Bet.class));
        Bet winningBet = mock(Bet.class);
        bets.add(winningBet);
        bets.add(mock(Bet.class));
        bets.add(mock(Bet.class));

        //act
        BetResult result = rule.determineWinner(1, bets);

        // assert
        Assert.assertEquals(result.getWinningBet(), winningBet);
    }
}
