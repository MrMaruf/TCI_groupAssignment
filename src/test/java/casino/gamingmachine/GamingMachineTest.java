package casino.gamingmachine;

import bettingauthoritiyAPI.BettingAuthority;
import bettingauthoritiyAPI.IBetLoggingAuthority;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.Cashier;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.game.IGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.*;

public class GamingMachineTest {
    IGame game;
    ICashier cashier;

    @Before
    public void setUp(){
        this.game = mock(IGame.class);
        this.cashier = mock(ICashier.class);
    }

    @Test
    public void acceptWinner_Should_Tell_Cashier_To_Transfer_MoneyAmount_To_The_Winner_Test() {
        // arrange
        GamingMachine gm = new GamingMachine(this.game, this.cashier);
        // connect card to gamingmachine
        // place the winning bet
        BetResult winningBet = mock(BetResult.class);
        MoneyAmount won = new MoneyAmount(100);
        when(winningBet.getAmountWon()).thenReturn(won);

        // act
        gm.acceptWinner(winningBet);

        // assert
        verify(this.cashier).addAmount(gm.playerCard, won);
        Assert.assertNull(gm.currentBet);
    }


    @Test
    public void connectCard_Should_Set_An_IPlayerCard_To_The_GameMachine_Test() {
        // arrange
        GamingMachine gm = new GamingMachine(this.game, this.cashier);
        IPlayerCard cardToConnect = mock(IPlayerCard.class);

        // act
        gm.connectCard(cardToConnect);

        // assert
        Assert.assertEquals(gm.playerCard, cardToConnect);
    }

    @Test
    public void placeBet_With_Valid_MoneyAmount_Should_Create_Bet_From_Card_With_MoneyAmount_Pass_It_To_Game_And_Return_True_Test() {
        // arrange
        GamingMachine gm = new GamingMachine(this.game, this.cashier);
        // connect card
        long moneyToBet = 200;
        boolean betIsValid = false;

        // act
        betIsValid = gm.placeBet(moneyToBet);

        // assert
        Assert.assertNotNull(gm.currentBet);
    }
}