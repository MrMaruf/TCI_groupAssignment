package casino.cashier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.*;
import bettingauthoritiyAPI.BettingAuthority;
import bettingauthoritiyAPI.IBetLoggingAuthority;
import casino.idbuilder.ids.CardID;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class CashierTest {
    @Test
    public void distributePlayerCard_Should_Return_IPlayerCard_Object_And_Log_Info_Test(){
        // arrange
        IBetLoggingAuthority bl = mock(IBetLoggingAuthority.class);
        BettingAuthority betAuth = mock(BettingAuthority.class);
        when(betAuth.getLoggingAuthority()).thenReturn(bl);

        List<IPlayerCard> cards = new ArrayList<>();
        cards.add(mock(IPlayerCard.class));
        ICashier c = new Cashier(cards, betAuth);
        IPlayerCard emptyCard;


        // act
        emptyCard = c.distributeGamblerCard();

        // assert
        Assert.assertThat(emptyCard, instanceOf(IPlayerCard.class));
        verify(bl).handOutGamblingCard(emptyCard.getCardID());
    }

}
