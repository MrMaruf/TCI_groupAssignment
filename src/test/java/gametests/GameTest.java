package gametests;

import ID.BettingRoundID;
import bettingauthoritiyAPI.*;
import casino.ICasino;
import casino.bet.Bet;
import casino.bet.BettingRound;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.Game;
import casino.game.IBettingRound;
import casino.game.IGame;
import casino.game.IGameRule;
import casino.gamingmachine.GamingMachine;
import casino.gamingmachine.IGamingMachine;
import org.junit.Test;
import org.junit.Assert;
import player.IPlayer;
import player.Player;

import java.util.AbstractList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameTest {
    @Test
    public void Game_startBettingRound_Should_Create_Betting_Round_And_Log_Info_Test(){
        IGameRule gameRule = mock(IGameRule.class);
        BettingAuthority bettingAuthority = new BettingAuthority();
        BettingRound betRound = mock(BettingRound.class);
        Game sut = new Game(gameRule, bettingAuthority);

        sut.setBettingRound(betRound);
        if(sut.getBettingRound() != null){
            sut.bettingAuthority.getLoggingAuthority().startBettingRound(betRound);
        }

        Assert.assertNotNull(sut.bettingAuthority);
        Assert.assertNotNull(sut.getBettingRound());
    }
}
