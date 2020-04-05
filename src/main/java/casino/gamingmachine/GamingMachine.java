package casino.gamingmachine;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.game.IGame;
import casino.idbuilder.ids.BetID;
import casino.idbuilder.ids.GamingMachineID;

public class GamingMachine implements IGamingMachine {
    IGame game;
    ICashier cashier;
    protected Bet currentBet;
    protected IPlayerCard playerCard;


    public GamingMachine(IGame game, ICashier cashier){
        this.game = game;
        this.cashier = cashier;
    }

    @Override
    public boolean placeBet(long amountInCents) {
        BetID betID = this.playerCard.generateNewBetID();
        Bet bet = new Bet(betID, new MoneyAmount(amountInCents));
        this.currentBet = bet;
        return this.game.acceptBet(bet, this);
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
        this.playerCard = card;
    }
}
