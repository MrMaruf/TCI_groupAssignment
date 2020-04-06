package player;

import casino.ICasino;
import casino.cashier.IPlayerCard;
import casino.cashier.PlayerCard;
import casino.gamingmachine.GamingMachine;
import casino.gamingmachine.IGamingMachine;

import java.util.*;

public class Player implements IPlayer {

    public ArrayList<IPlayerCard> playerCards = new ArrayList<IPlayerCard>();

    private ICasino casino;

    public Player(ICasino casino) {
        this.casino = casino;
    }

    @Override
    public void addPlayerCard(IPlayerCard playerCard) {
        if(playerCards.contains(playerCard)){
            throw new IllegalArgumentException("the player card already exists");
        }
        else{
            playerCards.add(playerCard);
        }

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
    public void playOnGameMachine(IPlayerCard playerCard, GamingMachine gamingMachine) {

            gamingMachine.connectCard(playerCard);

    }

    @Override
    public ArrayList<IPlayerCard> getAllPlayerCards() {
        return this.playerCards;
    }

    @Override
    public void betOnMachine(GamingMachine gamingMachine, IPlayerCard iPlayerCard, long amount) {
        if(gamingMachine.getPlayerCard() == iPlayerCard){
            gamingMachine.placeBet(amount);
        }else{
            gamingMachine.connectCard(iPlayerCard);
            gamingMachine.placeBet(amount);
        }

    }
}
