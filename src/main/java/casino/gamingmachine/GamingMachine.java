package casino.gamingmachine;

import ID.GamingMachineID;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.game.IGame;

public class GamingMachine implements IGamingMachine {
    private IPlayerCard playerCard;
    private ICashier cashier;
    private IGame game;
    private Bet bet;

    public IPlayerCard getPlayerCard(){
        return playerCard;
    }

    @Override
    public boolean placeBet(long amountInCents) {
        return true;
    }

    @Override
    public void acceptWinner(BetResult winResult) {

    }

    @Override
    public GamingMachineID getGamingMachineID() {
        return null;
    }

    @Override
    public void connectCard(IPlayerCard card) {
        playerCard = card;
    }
}
