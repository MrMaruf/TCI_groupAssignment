package gametests;

import bettingauthoritiyAPI.*;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.BettingRound;
import casino.bet.MoneyAmount;
import casino.game.Game;
import casino.game.IGameRule;
import casino.gamingmachine.GamingMachine;
import casino.gamingmachine.IGamingMachine;
import org.junit.Test;
import org.junit.Assert;

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
        int a = 1;
        long i = 10;
        Set<Bet> bets = new HashSet<>();

        //act

        BetResult finalBet = new BetResult(bet, new MoneyAmount(i));
        sut.setBettingRound(betRound);
        if(sut.isBettingRoundFinished() == false){
            bets.add(bet);
            bets.add(bet1);
            sut.addGamingMachine(gm);



            sut.bettingAuthority.getTokenAuthority().getRandomInteger(token);
            when(betRound.getAllBetsMade()).thenReturn(bets);
            when(gameRule.getMaxBetsPerRound()).thenReturn(1);
            when(gameRule.determineWinner(gameRule.getMaxBetsPerRound(), betRound.getAllBetsMade())).thenReturn(finalBet);

            for(IGamingMachine gameMachine: sut.getGamingMachines()){
                gameMachine.acceptWinner(gameRule.determineWinner(gameRule.getMaxBetsPerRound(), betRound.getAllBetsMade()));

            }



            sut.determineWinner();
        }


        //assert
        Assert.assertNotNull(a);
        Assert.assertNotNull(bets);
        //Assert.assertEquals(2, bets.size());
        verify(gm).acceptWinner(finalBet);
        verify(gameRule).determineWinner(a, bets);

        //verify(gameRule).getMaxBetsPerRound();

        Assert.assertEquals(bet, finalBet.getWinningBet());

    }

    @Test
    public void Game_isBettingFinished_Should_Return_ValueOf_property_same_name_Test(){
        IGameRule gameRule = mock(IGameRule.class);
        BettingAuthority bettingAuthority = new BettingAuthority();
        Game sut = new Game(gameRule, bettingAuthority);

        sut.setIsBettingFinished(true);

        Assert.assertEquals(sut.isBettingRoundFinished(), true);
    }
    @Test
    public void Game_acceptBet_Should_Pass_Bet_To_BettingRound_Log_Info_Test(){
        //arrange
        GamingMachine gm = mock(GamingMachine.class);
        IGameRule gameRule = mock(IGameRule.class);
        BettingAuthority bettingAuthority = new BettingAuthority();
        BetToken token = mock(BetToken.class);
        Game sut = new Game(gameRule, bettingAuthority);
        BettingRound betRound = mock(BettingRound.class);
        Bet bet = mock(Bet.class);

        //act
        if(sut.isBettingRoundFinished()){
            when(betRound.placeBet(bet)).thenReturn(true);
            when(betRound.numberOFBetsMade()).thenReturn(1);

            sut.bettingAuthority.getLoggingAuthority().addAcceptedBet(bet, betRound.getBettingRoundID(), gm.getGamingMachineID());
        }

        sut.acceptBet(bet, gm);

        verify(betRound).placeBet(bet);
        verify(betRound).numberOFBetsMade();
        Assert.assertEquals(true, (sut.acceptBet(bet, gm)));
    }
}
