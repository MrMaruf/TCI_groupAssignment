package casino.cashier;

import casino.idbuilder.IDBuilder;
import casino.idbuilder.ids.BetID;
import casino.idbuilder.ids.CardID;

import java.util.HashSet;
import java.util.Set;

public class PlayerCard implements IPlayerCard {
    private Set<BetID> allBetIds = new HashSet<BetID>();
    private CardID cardID = IDBuilder.getCardID();
    @Override
    public Set<BetID> returnBetIDs() {
        return allBetIds;
    }

    @Override
    public Set<BetID> returnBetIDsAndClearCard() {
        Set<BetID> copy = new HashSet<BetID>();
        copy.addAll(allBetIds);
        allBetIds.clear();
        return copy;
    }

    @Override
    public BetID generateNewBetID() {
        BetID newID = IDBuilder.getBetID();
        allBetIds.add(newID);
        return newID;
    }

    @Override
    public int getNumberOfBetIDs() {
        return allBetIds.size();
    }

    @Override
    public CardID getCardID() {
        return cardID;
    }
}
