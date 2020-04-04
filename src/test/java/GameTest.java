import ID.BettingRoundID;
import bettingauthoritiyAPI.BetToken;
import bettingauthoritiyAPI.BettingAuthority;
import bettingauthoritiyAPI.IBetTokenAuthority;
import casino.game.IBettingRound;
import casino.game.IGameRule;

import static org.mockito.Mockito.*;

public class GameTest {
public void Game_startBettingRound_Should_Create_bettingRound_And_Log_Info_Test(){
    //arrange
    BettingAuthority betAuth = mock(BettingAuthority.class);
    IGameRule gRule = mock(IGameRule.class);
    Game sut = new Game(gRule, betAuth);
    IBetTokenAuthority betTokenAuth = mock(IBetTokenAuthority.class);
    IBettingRound betR = mock(IBettingRound.class);
    BettingRoundID betRID = mock(BettingRoundID.class);
    BetToken betToken = mock(BetToken.class);

    //act

    when(betR.getBettingRoundID()).thenReturn(betRID);
    when(betAuth.getTokenAuthority().getBetToken(betRID)).thenReturn(betToken);
    when(sut.isBettingRoundFinished()).thenReturn(true);
    when(sut.getBettingRound()).thenReturn(betR);
    sut.startBettingRound();

    //assert
    verify(sut.getBettingRound()).equals(betR);
    verify(betAuth.getLoggingAuthority()).startBettingRound(betR);



}


}
