package casino.gamingmachine;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.game.IGame;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class GamingMachineTest {
    IGame game;
    ICashier cashier;
    IPlayerCard cardToConnect;

    @Before
    public void setUp(){
        this.game = mock(IGame.class);
        this.cashier = mock(ICashier.class);
        this.cardToConnect = mock(IPlayerCard.class);
    }

    @Test
    public void connectCard_Should_Set_An_IPlayerCard_To_The_GameMachine_Test() {
        // arrange
        GamingMachine gm = new GamingMachine(this.game, this.cashier);

        // act
        gm.connectCard(this.cardToConnect);

        // assert
        Assert.assertEquals(gm.playerCard, cardToConnect);
    }

    @Test
    public void placeBet_With_Valid_MoneyAmount_Should_Create_Bet_From_Card_With_MoneyAmount_Pass_It_To_Game_And_Return_True_Test() {
        // arrange
        when(this.game.acceptBet(any(Bet.class), any(IGamingMachine.class))).thenReturn(true);
        GamingMachine gm = new GamingMachine(this.game, this.cashier);
        gm.connectCard(this.cardToConnect);
        boolean betIsValid = false;

        // act
        betIsValid = gm.placeBet(200);

        // assert
        Assert.assertNotNull(gm.currentBet);
        Assert.assertTrue(betIsValid);
        verify(this.game).acceptBet(gm.currentBet, gm);
    }

    @Test
    public void acceptWinner_Should_Tell_Cashier_To_Transfer_MoneyAmount_To_The_Winner_Test() {
        // arrange
        GamingMachine gm = new GamingMachine(this.game, this.cashier);
        gm.connectCard(this.cardToConnect);
        gm.placeBet(100);
        MoneyAmount winningAmount = new MoneyAmount(200);
        BetResult winningBet = new BetResult(gm.currentBet, winningAmount);

        // act
        gm.acceptWinner(winningBet);

        // assert
        Assert.assertNull(gm.currentBet);
        verify(this.cashier).addAmount(gm.playerCard, winningAmount);
    }

}