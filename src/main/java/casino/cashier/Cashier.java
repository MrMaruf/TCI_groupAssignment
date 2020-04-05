package casino.cashier;

import bettingauthoritiyAPI.BettingAuthority;
import casino.bet.Bet;
import casino.bet.MoneyAmount;

import java.util.HashMap;
import java.util.List;


public class Cashier implements ICashier {
    protected HashMap<IPlayerCard, MoneyAmount> moneyPerPlayerCard;
    BettingAuthority betAuth;

    public Cashier(List<IPlayerCard> cards, BettingAuthority betAuth){
        this.moneyPerPlayerCard = new HashMap<>();
        for(IPlayerCard pc: cards){
            this.moneyPerPlayerCard.put(pc, null);
        }
        this.betAuth = betAuth;
    }

    @Override
    public IPlayerCard distributeGamblerCard() {
        for(IPlayerCard pc: this.moneyPerPlayerCard.keySet()){
            if(this.moneyPerPlayerCard.get(pc) == null) {
                this.moneyPerPlayerCard.put(pc, new MoneyAmount(0));
                this.betAuth.getLoggingAuthority().handOutGamblingCard(pc.getCardID());
                return pc;
            }
        }
        return null;
    }

    @Override
    public void returnGamblerCard(IPlayerCard card) {

    }

    @Override
    public boolean checkIfBetIsValid(IPlayerCard card, Bet betToCheck) {
        return false;
    }

    @Override
    public void addAmount(IPlayerCard card, MoneyAmount amount) {

    }
}
