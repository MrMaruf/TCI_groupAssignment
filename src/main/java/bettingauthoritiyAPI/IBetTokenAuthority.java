package bettingauthoritiyAPI;

import casino.idbuilder.ids.BettingRoundID;

public interface IBetTokenAuthority {
    BetToken getBetToken(BettingRoundID bettingRoundID);

    Integer getRandomInteger(BetToken betToken);
}
