package info;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class CPTInfo {
    public enum Side{
        OWN,
        OTHER
    }
    private Side side;
    private int unum;
    private int type;

    public CPTInfo(Side side, int unum, int type) {
        this.side = side;
        this.unum = unum;
        this.type = type;
    }

    public Side getSide() {
        return side;
    }

    public int getUnum() {
        return unum;
    }

    public int getType() {
        return type;
    }
}
