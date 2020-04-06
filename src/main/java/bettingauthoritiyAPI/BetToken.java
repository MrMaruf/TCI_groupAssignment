package bettingauthoritiyAPI;


import casino.idbuilder.ids.BettingRoundID;

import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

/**
 *  immutable class consisting of a unique ID + creationTime combination,
 *  combined with the bettingroundID it relates to.
 *
 *  This class is used for logging purposes of the bettingauthority.
 */
public class BetToken implements Comparable {
    private BettingRoundID bettingRoundID;
    private UUID uniqueTokenID;
    private Instant creationTime;

    /**
     * After passing BettingRoundID, it saved.
     * Unique token is created, as well as creation time is saved.
     * @param bettingRoundID
     */
    public BetToken(BettingRoundID bettingRoundID) {
        this.bettingRoundID = bettingRoundID;
        this.uniqueTokenID = UUID.randomUUID();
        this.creationTime = Instant.now();
    }

    /**
     * Returns ID of the betting round
     * @return BettingRoundID
     */
    public BettingRoundID getBettingRoundID() {
        return bettingRoundID;
    }

    /**
     * Gets unique token's ID
     * @return unique token's ID
     */
    public UUID getUniqueTokenID() {
        return uniqueTokenID;
    }

    /**
     *
     * @return creation time of the object/ID
     */
    public Instant getCreationTime() {
        return creationTime;
    }

    /**
     * Compares Object o to this object. If o isn't null and is an instance of BetToken, it proceds with comparing.
     * Otherwise, throws an exception.
     * It compares both uniquesTokenId and creationTime. If both are equal, then returns 0. Else returns 1/-1
     * @param o
     * @return 0 if objects are the same. 1/-1 if not the same.
     */
    @Override
    public int compareTo(Object o) {
            // throw exceptions when necessary
            if(o == null){
                throw new NullPointerException();
            }
            if(! (o instanceof BetToken)){
                throw new ClassCastException();
            }
            // comparing logical attributes
            BetToken token = (BetToken)o;
            int returnvalue = this.uniqueTokenID.compareTo(token.uniqueTokenID);
            if(returnvalue == 0){
                returnvalue = this.creationTime.compareTo(token.creationTime);
            }
            return returnvalue;
        }
    /**
     * Compares Object o to this object. If positive returns true.
     * If o isn't null and is an instance of BetToken, it proceds with comparing.
     * Otherwise, returns false.
     * It compares both uniquesTokenId and creationTime. If both are equal, then returns true. Else returns false
     * @param o
     * @return true if objects are the same. false if not the same.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BetToken betToken = (BetToken) o;
        return uniqueTokenID.equals(betToken.uniqueTokenID) &&
                creationTime.equals(betToken.creationTime);
    }

    /**
     * Creates hashCode
     * @return hashCode made out of unique token's ID and creation time
     */
    @Override
    public int hashCode() {
        return Objects.hash(uniqueTokenID, creationTime);
    }
}
