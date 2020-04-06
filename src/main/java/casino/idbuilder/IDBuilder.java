package casino.idbuilder;

import casino.idbuilder.ids.*;


/**
 * Builder for creation of GeneralID objects.
 *
 */
public class IDBuilder {
    public static CardID getCardID(){
        return new CardID();
    }
    public static GamingMachineID getGamingMachineID(){
        return new GamingMachineID();
    }
    public static BetID getBetID(){
        return new BetID();
    }
    public static BettingRoundID getBettingRoundID(){
        return new BettingRoundID();
    }
    public static GameID getGameID(){
        return new GameID();
    }
}
