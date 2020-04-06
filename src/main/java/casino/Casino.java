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

public Casino(){

}



    @Override
    public void addGame(String gameName, IGame gameToAdd) {

    }

    @Override
    public IGame getGame(String name) {
        return null;
    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) {
        return false;
    }
}
