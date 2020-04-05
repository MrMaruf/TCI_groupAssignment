package casino.cashier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.*;
import bettingauthoritiyAPI.BettingAuthority;
import bettingauthoritiyAPI.IBetLoggingAuthority;
import casino.bet.MoneyAmount;
import casino.idbuilder.ids.CardID;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class CashierTest {
    IBetLoggingAuthority bl;
    BettingAuthority betAuth;
    List<IPlayerCard> cards;

    @Mock(name = "moneyPerPlayerCard")
    private HashMap<IPlayerCard, MoneyAmount> moneyPerPlayerCard;


    @Before
    public void setUp(){
        bl = mock(IBetLoggingAuthority.class);
        betAuth = mock(BettingAuthority.class);
        cards = new ArrayList<>();
        cards.add(mock(IPlayerCard.class));
        when(betAuth.getLoggingAuthority()).thenReturn(bl);
    }

    @Test
    public void distributePlayerCard_Should_Return_IPlayerCard_Object_And_Log_Info_Test(){
        // arrange
        ICashier c = new Cashier(this.cards, this.betAuth);
        IPlayerCard emptyCard;


        // act
        emptyCard = c.distributeGamblerCard();

        // assert
        Assert.assertThat(emptyCard, instanceOf(IPlayerCard.class));
        verify(this.bl).handOutGamblingCard(emptyCard.getCardID());
    }


    @Test
    public void checkIfBetIsValid_And_Card_Has_Enough_Money_Should_Return_TRUE_Test(){
        // arrange
        ICashier c = new Cashier(this.cards, betAuth);
        IPlayerCard emptyCard;
        // add amount
        // make bet

        // act
        emptyCard = c.distributeGamblerCard();

        // assert
        // check if it's ok
    }


    @Test
    public void addAmount_Valid_MoneyAmount_Should_Set_MoneyAmount_To_A_PlayerCard_Test(){
        // arrange
        ICashier c = new Cashier(this.cards, betAuth);
        IPlayerCard playerCard = c.distributeGamblerCard();

        // act
        c.addAmount(playerCard, new MoneyAmount(200));

        // assert
        Assert.assertEquals(moneyPerPlayerCard.get(playerCard).getAmountInCents(), 200);
    }
}
