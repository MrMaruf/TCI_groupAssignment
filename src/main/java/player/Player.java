package player;

import casino.ICasino;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.gamingmachine.IGamingMachine;

import java.util.*;

public class Player implements IPlayer {

    public ArrayList<IPlayerCard> playerCards = new ArrayList<IPlayerCard>();

    private ICasino casino;

    public Player(ICasino casino) {

    }

    @Override
    public void addPlayerCard(IPlayerCard playerCard) {
        playerCards.add(playerCard);
    }

    @Override
    public void removePlayerCard(IPlayerCard playerCard) {
        if(playerCards.contains(playerCard)){
            playerCards.remove(playerCard);
        }
        else{
            throw new IllegalArgumentException("the player card is invalid");
        }

    }

    @Override
    public void playOnGameMachine(IPlayerCard playerCard, IGamingMachine gamingMachine) {

    }

    @Override
    public ArrayList<IPlayerCard> getAllPlayerCards() {
        return this.playerCards;
    }

    @Override
    public void betOnMachine(IGamingMachine gamingMachine, IPlayerCard iPlayerCard) {

    }
}
