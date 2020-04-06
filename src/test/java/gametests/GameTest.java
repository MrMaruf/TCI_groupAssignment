package gametests;

import ID.BetID;
import ID.BettingRoundID;
import bettingauthoritiyAPI.*;
import casino.ICasino;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.BettingRound;
import casino.bet.MoneyAmount;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.Game;
import casino.game.IBettingRound;
import casino.game.IGame;
import casino.game.IGameRule;
import casino.gamingmachine.GamingMachine;
import casino.gamingmachine.IGamingMachine;
import com.sun.tools.classfile.Opcode;
import org.junit.Test;
import org.junit.Assert;
import player.IPlayer;
import player.Player;

import java.util.*;

import static org.mockito.Mockito.*;

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

    @Test
    public void Game_determineWinner_should_find_betResult_and_send_it_to_gamingmachine_test(){
       //arrange
        GamingMachine gm = mock(GamingMachine.class);
        IGameRule gameRule = mock(IGameRule.class);
        BettingAuthority bettingAuthority = new BettingAuthority();
        BetToken token = mock(BetToken.class);
        BettingRound betRound = mock(BettingRound.class);
        Game sut = new Game(gameRule, bettingAuthority);
        Bet bet = mock(Bet.class);
        Bet bet1 = mock(Bet.class);
        int a = 0;
        long i = 10;
        Set<Bet> bets = new HashSet<>();

        //act

        BetResult finalBet = new BetResult(bet, new MoneyAmount(i));
        if(sut.isBettingRoundFinished() == false){
            bets.add(bet);
            bets.add(bet1);

            a = sut.bettingAuthority.getTokenAuthority().getRandomInteger(token);
            when(betRound.getAllBetsMade()).thenReturn(bets);
            when(gameRule.getMaxBetsPerRound()).thenReturn(1);
            when(gameRule.determineWinner(a, bets)).thenReturn(finalBet);

            foreach(GamingMachine gameMachine: sut.getGamingMachines()){
                g.acceptWinner(finalBet);
                gm.acceptWinner(finalBet);
            }



            sut.determineWinner();
        }


        //assert
        verify(gm).acceptWinner(finalBet);
        verify(gameRule).determineWinner(a, bets);
        verify(betRound.getAllBetsMade()).equals(bets);
        verify(gameRule.getMaxBetsPerRound()).equals(1);
        verify(finalBet).getWinningBet().equals(bet);

    }
}
