import ID.BetID;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class GameMachineTest {

    public void GameMachine_acceptWinner_Should_Tell_Cashier_To_Transfer_MoneyAmount_To_The_Winner_Test(){
        //arrange
        Game game = mock(Game.class);
        Cashier cashier = mock(Cashier.class);
        GameMachine gameMachine = new GameMachine(game, cashier);
        BetID betID = mock(BetID.class);
        MoneyAmount amount = mock(MoneyAmount.class);
        Bet bet = new Bet(betID, amount);
        BetResult winBet = new BetResult(bet, amount);
        PlayerCard card = mock(PlayerCard.class);

        //act
        long amountincents_mock = 100;

        when(betID.toString()).thenReturn("ABC_ID");
        when(amount.getAmountInCents()).thenReturn(amountincents_mock);
        when(winBet.getWinningBet()).thenReturn(bet);
        when(winBet.getAmountWon()).thenReturn(amount);
        when(cashier.addAmount(card, amount)).then(bet = null);

        //assert
        verify(cashier).addAmount(card, amount);
        verify(bet == null);
        
    }

}
