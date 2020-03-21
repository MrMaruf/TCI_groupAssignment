package bettingauthoritiyAPI;

public interface IBetTokenAuthority {
    BetToken getBetToken(BettingRoundID bettingRoundID);

    Integer getRandomInteger(BetToken betToken);
}
