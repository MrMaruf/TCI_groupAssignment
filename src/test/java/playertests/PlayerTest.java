package playertests;
import ID.BettingRoundID;
import bettingauthoritiyAPI.*;
import casino.ICasino;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.Game;
import casino.game.IBettingRound;
import casino.game.IGameRule;
import org.junit.Test;
import org.junit.Assert;
import player.IPlayer;
import player.Player;

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
}
