package casino.cashier;

import casino.idbuilder.ids.BetID;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PlayerCardTest {
    PlayerCard pc;
    @Before
    public void setUp() throws Exception {
        pc = new PlayerCard();
    }

    @After
    public void tearDown() throws Exception {
        pc = null;
    }

    @Test
    public void PlayerCard_returnBetIdsAndClearCard_Should_Reset_List_allBetIds_Test() {
        //arrange
        Set<BetID> temporarySet;
        pc.generateNewBetID();

        //act
        temporarySet = pc.returnBetIDsAndClearCard();

        //test
        Assert.assertTrue(pc.getNumberOfBetIDs() == 0);
        Assert.assertNotEquals(temporarySet.size(), pc.getNumberOfBetIDs());
    }

    @Test
    public void PlayerCard_generateBetId_Should_Create_BetId_Add_It_To_List_allBetIds_And_Return_It_Test(){
        //arrange
        BetID bet;

        //act
        bet = pc.generateNewBetID();

        //test
        Assert.assertTrue(pc.returnBetIDs().contains(bet));
    }
}