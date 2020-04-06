package casino;

import bettingauthoritiyAPI.BettingAuthority;
import casino.bet.Bet;
import casino.bet.MoneyAmount;
import casino.cashier.Cashier;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.game.Game;
import casino.game.GameRule;
import casino.game.IGame;
import casino.idbuilder.IDBuilder;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import player.IPlayer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CasinoTest {
    BettingAuthority ba;
    Casino casino;
    Cashier cashier;
    List<IPlayerCard> PClist;
    GameRule gr = new GameRule(5);
    PlayerCard pc;
    @Before
    public void setUp() throws Exception {
        ba = new BettingAuthority();
        PClist = new ArrayList<IPlayerCard>();
        pc = new PlayerCard();
        PClist.add(pc);
        cashier = new Cashier(PClist, ba);

        casino = new Casino(cashier, ba);
    }

    @Test
    public void Casino_addGame_Should_Create_IGame_Object_And_Add_It_To_HashMap_allGames_Test(){
        //arrange
        IGame game = new Game(gr, ba);
        String gameName = "Hi Game";

        //act
        casino.addGame(gameName, game);

        // test
        Assert.assertEquals(game, casino.getGame(gameName));
    }

    @Test(expected = ArrayStoreException.class)
    public void Casino_addGame_With_Already_Existing_Name_Should_Return_Null_Test(){
        //arrange
        IGame game = new Game(gr, ba);
        String gameName = "Hi Game";
        casino.addGame(gameName, game);

        //act
        casino.addGame(gameName, game);

        //test
    }
    @Test
    public void Casino_getGame_With_Nonexisting_Name_Should_Return_Null_Test(){
        //arrange
        IGame game = new Game(gr, ba);
        String gameName = "Hi Game";
        casino.addGame(gameName, game);

        //act

        //test
        Assert.assertNull(casino.getGame("Poro Poro"));
    }



}