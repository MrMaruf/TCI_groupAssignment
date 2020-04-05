package casino.game;

import ID.BettingRoundID;
import bettingauthoritiyAPI.BetToken;
import bettingauthoritiyAPI.BettingAuthority;
import casino.bet.Bet;
import casino.bet.BettingRound;
import casino.gamingmachine.IGamingMachine;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Game implements IGame {
    private IBettingRound bettingRound;

    private List<IGamingMachine> gamingMachines;

    private IGameRule gameRule;

    public BettingAuthority bettingAuthority;

    public Game(IGameRule gameRule, BettingAuthority bettingAuthority){
        this.bettingAuthority = bettingAuthority;
        this.gameRule = gameRule;
        gamingMachines = new List<IGamingMachine>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<IGamingMachine> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(IGamingMachine iGamingMachine) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends IGamingMachine> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends IGamingMachine> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public IGamingMachine get(int index) {
                return null;
            }

            @Override
            public IGamingMachine set(int index, IGamingMachine element) {
                return null;
            }

            @Override
            public void add(int index, IGamingMachine element) {

            }

            @Override
            public IGamingMachine remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<IGamingMachine> listIterator() {
                return null;
            }

            @Override
            public ListIterator<IGamingMachine> listIterator(int index) {
                return null;
            }

            @Override
            public List<IGamingMachine> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
    }

    public IBettingRound getBettingRound(){
        return this.bettingRound;
    }

    public void setBettingRound(IBettingRound bettingRound){
        this.bettingRound = bettingRound;
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

    }

    @Override
    public boolean isBettingRoundFinished() {
        return false;
    }
}
