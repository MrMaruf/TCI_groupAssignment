import ID.BettingRoundID;
import bettingauthoritiyAPI.BetToken;
import bettingauthoritiyAPI.BetTokenAuthority;
import bettingauthoritiyAPI.BettingAuthority;
import bettingauthoritiyAPI.IBetTokenAuthority;
import casino.game.IBettingRound;
import casino.game.IGame;
import casino.game.IGameRule;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

public class GameTest {
public void Game_startBettingRound_Should_Create_bettingRound_And_Log_Info_Test(){
    //arrange
    BettingAuthority betAuth = mock(BettingAuthority.class);
    IGameRule gRule = mock(IGameRule.class);
    Game sut = new Game(gRule, betAuth);
    IBetTokenAuthority betToken = mock(IBetTokenAuthority.class);
    IBettingRound betR = mock(IBettingRound.class);

    //act

    when(betAuth.getTokenAuthority()).thenReturn((betToken);
    when(sut.betR = betR).thenReturn(betR);
    sut.startBettingRound();

    //assert
    verify(betAuth.getLoggingAuthority()).startBettingRound(betR);



}


}
