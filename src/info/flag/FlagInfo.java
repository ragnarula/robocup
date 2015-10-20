package info.flag;

import com.github.robocup_atan.atan.model.enums.Flag;

/**
 * Created by raghavnarula on 19/10/15.
 */
public class FlagInfo {

    private FlagLine line;
    private FlagSide side;
    private Flag flag;
    private double distance;
    private double direction;
    private double distChange;
    private double dirChange;
    private double bodyFacingDirection;
    private double headFacingDirection;

    public FlagInfo(FlagLine line, FlagSide side, Flag flag, double distance,
                    double direction, double distChange, double dirChange,
                    double bodyFacingDirection, double headFacingDirection) {
        this.line = line;
        this.side = side;
        this.flag = flag;
        this.distance = distance;
        this.direction = direction;
        this.distChange = distChange;
        this.dirChange = dirChange;
        this.bodyFacingDirection = bodyFacingDirection;
        this.headFacingDirection = headFacingDirection;
    }

    public FlagLine getLine() {
        return line;
    }

    public FlagSide getSide() {
        return side;
    }

    public double getDistance() {
        return distance;
    }

    public double getDirection() {
        return direction;
    }

    public double getDistChange() {
        return distChange;
    }

    public double getDirChange() {
        return dirChange;
    }

    public double getBodyFacingDirection() {
        return bodyFacingDirection;
    }

    public double getHeadFacingDirection() {
        return headFacingDirection;
    }
}
