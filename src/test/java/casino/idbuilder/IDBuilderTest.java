package casino.idbuilder;

import casino.idbuilder.ids.*;
import org.junit.Assert;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.instanceOf;

public class IDBuilderTest {
    @Test
    public void getCardID_Should_Return_CardID_Object_Test(){
        // assign and act
        CardID cardID = IDBuilder.getCardID();

        // assert
        Assert.assertThat(cardID, instanceOf(CardID.class));
    }

    @Test
    public void getGamingMachineID_Should_Return_GameMachineID_Object_Test(){
        // assign and act
        GamingMachineID gameMachineID = IDBuilder.getGamingMachineID();

        // assert
        Assert.assertThat(gameMachineID, instanceOf(GamingMachineID.class));
    }

    @Test
    public void getBetID_Should_Return_BetID_Object_Test(){
        // assign and act
        BetID betID = IDBuilder.getBetID();

        // assert
        Assert.assertThat(betID, instanceOf(BetID.class));
    }

    @Test
    public void getBettingRoundID_Should_Return_BettingRoundID_Object_Test(){
        // assign and act
        BettingRoundID bettingRoundID = IDBuilder.getBettingRoundID();

        // assert
        Assert.assertThat(bettingRoundID, instanceOf(BettingRoundID.class));
    }

    @Test
    public void getGameID_Should_Return_GameID_Object_Test(){
        // assign and act
        GameID gameID = IDBuilder.getGameID();

        // assert
        Assert.assertThat(gameID, instanceOf(GameID.class));
    }
}
