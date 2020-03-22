package ID;

import java.util.UUID;

public abstract class generalID implements Comparable {
    private UUID id;
    public generalID(){
        id = UUID.randomUUID();
    }
    @Override
    public String toString(){
        return id.toString();
    }
    public UUID getID(){
        return id;
    }
    @Override
    public int compareTo(Object o) {
        if(o instanceof generalID || o instanceof UUID)
            return o.toString().compareTo(this.toString()) == 0 ? 0 : 1; // if 0 then both are UUIDs and the both are equal, but if 1 both are UUIDs but not equal
        else
            return -1; // if -1 then object is not of UUID ir generalID types.
    }
}
