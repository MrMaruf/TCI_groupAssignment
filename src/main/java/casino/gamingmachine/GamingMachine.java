package casino.gamingmachine;

import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.MoneyAmount;
import casino.cashier.ICashier;
import casino.cashier.IPlayerCard;
import casino.game.IGame;
import casino.idbuilder.ids.BetID;
import casino.idbuilder.ids.GamingMachineID;

import java.util.Set;

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
    public boolean placeBet(long amountInCents) throws NoPlayerCardException {
        if(this.playerCard == null){
            throw new NoPlayerCardException();
        }
        if(this.currentBet != null){
            return false;
        }
        BetID betID = this.playerCard.generateNewBetID();
        Bet bet = new Bet(betID, new MoneyAmount(amountInCents));
        if(!this.cashier.checkIfBetIsValid(this.playerCard, bet)){
            return false;
        }
        this.currentBet = bet;
        return this.game.acceptBet(bet, this);
    }

    @Override
    public void acceptWinner(BetResult winResult) {
        Set<BetID> betids = this.playerCard.returnBetIDs();
        for(BetID betID: betids){
            if(betID == winResult.getWinningBet().getBetID()){
                this.cashier.addAmount(this.playerCard, winResult.getAmountWon());
                this.currentBet = null;
                return;
            }
        }
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
