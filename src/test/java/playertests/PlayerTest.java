package playertests;
import ID.BettingRoundID;
import bettingauthoritiyAPI.*;
import casino.cashier.IPlayerCard;
import casino.game.Game;
import casino.game.IBettingRound;
import casino.game.IGameRule;
import org.junit.Test;
import org.junit.Assert;

import static org.mockito.Mockito.*;
public class PlayerTest {
    @Test
    public void Player_addPlayerCard_Should_Add_PlayerCard_To_The_List_of_playerCards_Test(){
        Casino casino = Mock(Casino.class);
        IPlayer sut = new Player(casino);

        IPlayerCard card = mock(IPlayerCard.class);
        sut.addPlayerCard(card);

        Assert.assertEquals(1, sut.playerCards.count());
    }
}
