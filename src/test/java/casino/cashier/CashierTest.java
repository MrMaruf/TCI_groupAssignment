package casino.cashier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.*;
import bettingauthoritiyAPI.BettingAuthority;
import bettingauthoritiyAPI.IBetLoggingAuthority;
import casino.bet.Bet;
import casino.bet.MoneyAmount;
import casino.idbuilder.ids.BetID;
import casino.idbuilder.ids.CardID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class CashierTest {
    IBetLoggingAuthority bl;
    BettingAuthority betAuth;
    List<IPlayerCard> cards;

    @Before
    public void setUp(){
        this.bl = mock(IBetLoggingAuthority.class);
        this.betAuth = mock(BettingAuthority.class);
        this.cards = new ArrayList<>();
        this.cards.add(mock(IPlayerCard.class));
        when(this.betAuth.getLoggingAuthority()).thenReturn(this.bl);
    }

    @Test
    public void distributePlayerCard_Should_Return_IPlayerCard_Object_And_Log_Info_Test(){
        // arrange
        Cashier c = new Cashier(this.cards, this.betAuth);
        IPlayerCard emptyCard;

        // act
        emptyCard = c.distributeGamblerCard();

        // assert
        Assert.assertThat(emptyCard, instanceOf(IPlayerCard.class));
        Assert.assertEquals(c.moneyPerPlayerCard.get(emptyCard).getAmountInCents(), 0);
        verify(this.bl).handOutGamblingCard(emptyCard.getCardID());
    }


    @Test
    public void addAmount_Valid_MoneyAmount_Should_Set_MoneyAmount_To_A_PlayerCard_Test(){
        // arrange
        Cashier c = new Cashier(this.cards, this.betAuth);
        IPlayerCard playerCard = c.distributeGamblerCard();

        // act
        c.addAmount(playerCard, new MoneyAmount(200));
        c.addAmount(playerCard, new MoneyAmount(50));

        // assert
        Assert.assertEquals(c.moneyPerPlayerCard.get(playerCard).getAmountInCents(), 250);
    }


    @Test
    public void checkIfBetIsValid_And_Card_Has_Enough_Money_Should_Return_TRUE_Test(){
        // arrange
        Cashier c = new Cashier(this.cards, this.betAuth);
        IPlayerCard playerCard = c.distributeGamblerCard();
        c.addAmount(playerCard, new MoneyAmount(200));
        Bet validBet = mock(Bet.class);
        when(validBet.getMoneyAmount()).thenReturn(new MoneyAmount(50));
        boolean isBetValid = false;

        // act
        isBetValid = c.checkIfBetIsValid(playerCard, validBet);

        // assert
        Assert.assertTrue(isBetValid);
        Assert.assertEquals(c.moneyPerPlayerCard.get(playerCard).getAmountInCents(), 150);
    }

    @Test
    public void returnGamblerCard_Should_Make_PlayerCard_object_detached_from_player_And_Log_Info_Test(){
        // arrange
        Cashier c = new Cashier(this.cards, this.betAuth);
        IPlayerCard playerCard = c.distributeGamblerCard();
        when(playerCard.returnBetIDsAndClearCard()).thenReturn(null);
        // act
        c.returnGamblerCard(playerCard);

        // assert
        verify(this.bl).handInGamblingCard(playerCard.getCardID(), null);
        Assert.assertNull(c.moneyPerPlayerCard.get(playerCard));
    }
}
