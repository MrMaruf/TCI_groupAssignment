package ID;

import java.util.UUID;

public abstract class GeneralID implements Comparable {
    private UUID id;
// testing auto-merging
    /**
     * Generates an unique ID based on UUID.
     * <p>Creates an object.</p>
     */
    public GeneralID(){
        id = UUID.randomUUID();
    }

    /**
     * @return UUID id as a String.
     */
    @Override
    public String toString(){
        return id.toString();
    }

    /**
     * @return ID as UUID
     */
    public UUID getID(){
        return id;
    }

    /**
     * Check the Object o.
     * If o is null, throws an exception.
     * If o of type GeneralID or UUID, it turns both to string and compares two Strings.
     * Returns 0 if equal. If not, returns 1.
     * If o not of type GeneralID or UUID, returns -1.
     * @param o
     * @return 0 if equal. 1 if not equal, but o is of type GeneralID/UUID. -1 if o is not of the proper type.
     */
    @Override
    public int compareTo(Object o) {
        if (o == null)
            throw new NullPointerException();
        if(o instanceof GeneralID || o instanceof UUID)
            return o.toString().compareTo(this.toString()) == 0 ? 0 : 1; // if 0 then both are UUIDs and the both are equal, but if 1 both are UUIDs but not equal
        else
            return -1; // if -1 then object is not of UUID ir generalID types.
    }
}
