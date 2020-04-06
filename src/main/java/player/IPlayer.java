package player;

import casino.cashier.IPlayerCard;
import casino.gamingmachine.GamingMachine;
import casino.gamingmachine.IGamingMachine;
import casino.gamingmachine.NoPlayerCardException;

import java.util.List;

public interface IPlayer {
    public void addPlayerCard(IPlayerCard playerCard);

    public void removePlayerCard(IPlayerCard playerCard);

    public void playOnGameMachine(IPlayerCard playerCard, GamingMachine gamingMachine);

    public List<IPlayerCard> getAllPlayerCards();

    public void betOnMachine(GamingMachine gamingMachine, IPlayerCard iPlayerCard, long amount) throws NoPlayerCardException;


}
