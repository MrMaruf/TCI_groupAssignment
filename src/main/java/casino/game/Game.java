package casino.game;

import ID.BettingRoundID;
import bettingauthoritiyAPI.BetToken;
import bettingauthoritiyAPI.BettingAuthority;
import casino.bet.Bet;
import casino.bet.BetResult;
import casino.bet.BettingRound;
import casino.gamingmachine.IGamingMachine;

import java.util.*;

public class Game implements IGame {
    private IBettingRound bettingRound;

    private List<IGamingMachine> gamingMachines;

    private IGameRule gameRule;


    public BettingAuthority bettingAuthority;


    public Game(IGameRule gameRule, BettingAuthority bettingAuthority){
        this.bettingAuthority = bettingAuthority;
        this.gameRule = gameRule;
        gamingMachines = new ArrayList<>();

    }

    public List<IGamingMachine> getGamingMachines() {return gamingMachines;}
    public IBettingRound getBettingRound(){
        return this.bettingRound;
    }

    public void setBettingRound(IBettingRound bettingRound){
        this.bettingRound = bettingRound;
    }

    public void addGamingMachine(IGamingMachine machine){
        this.gamingMachines.add(machine);
    }
    @Override
    public void startBettingRound() {
        IBettingRound bettingRound1 = new BettingRound(new BetToken(new BettingRoundID()));
        if(getBettingRound() == bettingRound1){
            throw new IllegalArgumentException("the betting round has already started");
        }else{
            setBettingRound(new BettingRound(new BetToken(new BettingRoundID())));
            bettingAuthority.getLoggingAuthority().startBettingRound(bettingRound1);
        }


    }

    @Override
    public boolean acceptBet(Bet bet, IGamingMachine gamingMachine) {
        return false;
    }

    @Override
    public void determineWinner() {
        if(isBettingRoundFinished() == false){
            BetToken token = bettingAuthority.getTokenAuthority().getBetToken(bettingRound.getBettingRoundID());
            setBettingRound(new BettingRound(token));
            if(getBettingRound() == null){

                Set<Bet> bets = bettingRound.getAllBetsMade();
                BetResult betResult = gameRule.determineWinner(bettingAuthority.getTokenAuthority().getRandomInteger(bettingRound.getBetToken()), bets);

                for(IGamingMachine gm: getGamingMachines()){
                    gm.acceptWinner(betResult);
                }
            }

        }
    }

    @Override
    public boolean isBettingRoundFinished() {
        return false;
    }
}
