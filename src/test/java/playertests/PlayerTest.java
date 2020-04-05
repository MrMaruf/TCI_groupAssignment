package playertests;
import ID.BettingRoundID;
import bettingauthoritiyAPI.*;
import casino.ICasino;
import casino.bet.Bet;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.Game;
import casino.game.IBettingRound;
import casino.game.IGame;
import casino.game.IGameRule;
import casino.gamingmachine.IGamingMachine;
import org.junit.Test;
import org.junit.Assert;
import player.IPlayer;
import player.Player;

import java.util.AbstractList;
import java.util.List;

import static org.mockito.Mockito.*;
public class PlayerTest {
    @Test
    public void Player_addPlayerCard_Should_Add_PlayerCard_To_The_List_of_playerCards_Test(){
        //arrange
        ICasino casino = mock(ICasino.class);
        IPlayer sut = new Player(casino);

        IPlayerCard card = new PlayerCard();

        //act
        sut.addPlayerCard(card);

        //assert
        Assert.assertEquals(1, sut.getAllPlayerCards().size());

    }

    @Test
    public void Player_removePlayerCard_Should_Remove_PlayerCard_From_The_List_of_PlayerCards_Test(){
       //arrange
        ICasino casino = mock(ICasino.class);
        IPlayer sut = new Player(casino);
        IPlayerCard card = mock(PlayerCard.class);


        //act
        sut.addPlayerCard(card);
        sut.removePlayerCard(card);

        //assert
        Assert.assertEquals(0, sut.getAllPlayerCards().size() );
    }

    @Test
    public void Player_betOnMachine_Should_Place_Bet_On_A_Game_Test(){
        //arrange
        ICasino casino = mock(ICasino.class);
        IPlayer sut = new Player(casino);
        IPlayerCard card = mock(PlayerCard.class);
        IGame game = mock(Game.class);
        IGamingMachine gameMachine = mock(IGamingMachine.class);
        Bet bet = mock(Bet.class);

        //act
        doNothing().when(casino).addGame("game", game);
        if(game != null) {

                when(casino.getGame("game")).thenReturn(game);
                when(game.acceptBet(bet,gameMachine)).thenReturn(true);

        }



        sut.betOnMachine(gameMachine, card);

        //arrange

        verify(game).acceptBet(bet, gameMachine);
        Assert.assertTrue(game.acceptBet(bet, gameMachine));


    }
}
