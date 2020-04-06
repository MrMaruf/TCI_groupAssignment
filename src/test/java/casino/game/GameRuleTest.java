package casino.game;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashSet;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameRuleTest {
    @Test
    public void determineWinner_Should_Return_The_Correct_betResult_Test(){
        // assign
        IGameRule rule = new GameRule(5);
        LinkedHashSet<Bet> bets = new LinkedHashSet<>();
        // mocking
        bets.add(mock(Bet.class));
        Bet winningBet = mock(Bet.class);
        when(winningBet.getMoneyAmount()).thenReturn(new MoneyAmount(100));
        bets.add(winningBet);
        bets.add(mock(Bet.class));
        bets.add(mock(Bet.class));

        // act
        BetResult result = rule.determineWinner(1, bets);

        // assert
        Assert.assertEquals(result.getWinningBet(), winningBet);
        Assert.assertEquals(result.getAmountWon().getAmountInCents(), 200);
    }

    @Test
    public void determineWinner_With_No_Bets_Should_Return_Null_Test(){
        // assign
        IGameRule rule = new GameRule(5);
        LinkedHashSet<Bet> bets = new LinkedHashSet<>();

        // act
        BetResult result = rule.determineWinner(1, bets);

        // assert
        Assert.assertNull(result);
    }
}
