package bettingauthoritiyAPI;

import ID.BettingRoundID;

public interface IBetTokenAuthority {
    BetToken getBetToken(BettingRoundID bettingRoundID);

    Integer getRandomInteger(BetToken betToken);
}
