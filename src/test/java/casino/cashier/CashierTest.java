package casino.cashier;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.mockito.Mockito.*;

import bettingauthoritiyAPI.BettingAuthority;
import org.junit.Assert;
import org.junit.Test;


public class CashierTest {
    @Test
    public void distributePlayerCard_Should_Return_IPlayerCard_Object_And_Log_Info_Test(){
        // arrange
        boolean hasGottenACard = false;
        BettingAuthority betAuth = mock(BettingAuthority.class);
        ICashier c = new Cashier(betAuth);
        IPlayerCard emptyCard;

        // act
        emptyCard = c.distributeGamblerCard();

        // assert
        Assert.assertThat(emptyCard, instanceOf(IPlayerCard.class));
        verify(betAuth).getLoggingAuthority().handOutGamblingCard(emptyCard.getCardID());
    }

}
