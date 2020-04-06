package casino;

import bettingauthoritiyAPI.BettingAuthority;
import casino.bet.Bet;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.game.IGame;
import player.IPlayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Casino implements ICasino {

private HashMap<String, IGame> allGames = new HashMap<String, IGame>();

private ArrayList<IPlayer> allPlayers = new ArrayList<IPlayer>();

private ICashier cashier;

private BettingAuthority bettingAuthority;

public Casino(ICashier cashier, BettingAuthority bettingAuthority){
    this.cashier = cashier;
    this.bettingAuthority = bettingAuthority;
}


    /**
     * Throws an exception if game already exists. Can't return null, due to the void.
     * Can't change void, due to assignment limitation.
     * @param gameName
     * @param gameToAdd
     */
    @Override
    public void addGame(String gameName, IGame gameToAdd) {
    if(allGames.containsKey(gameName))
        throw new ArrayStoreException("Game with this name already exists");
    else
        allGames.put(gameName,gameToAdd);

    }

    @Override
    public IGame getGame(String name) {
        return allGames.get(name);
    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) {
        return cashier.checkIfBetIsValid(card, betToCheck);
    }
}
