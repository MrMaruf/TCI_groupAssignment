import ID.BettingRoundID;
import bettingauthoritiyAPI.*;
import casino.game.Game;
import casino.game.IBettingRound;
import casino.game.IGameRule;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.*;

public class GameTest {
@Test
public void Game_startBettingRound_Should_Create_bettingRound_And_Log_Info_Test(){
    BettingAuthority betAuth = new BettingAuthority();

    IGameRule gRule = mock(IGameRule.class);
    Game sut = new Game(gRule, betAuth);
    IBetTokenAuthority betTokenAuth = mock(IBetTokenAuthority.class);
    IBettingRound betR = mock(IBettingRound.class);
    BettingRoundID betRID = mock(BettingRoundID.class);
    BetToken betToken = mock(BetToken.class);

    //act




    sut.startBettingRound();

    //assert
    //Assert.assertEquals(sut.getBettingRound(), betR);
    Assert.assertNotNull(sut.getBettingRound());
    //Assert.assertEquals(betR, sut.getBettingRound());
    //verify(betLoggingAuthority).startBettingRound(betR);




}


}
