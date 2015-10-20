package info.flag;

import com.github.robocup_atan.atan.model.enums.Flag;

/**
 * Created by raghavnarula on 19/10/15.
 */
public class FlagInfo {

    private FlagType type;
    private FlagSide side;
    private Flag flag;
    private double distance;
    private double direction;
    private double distChange;
    private double dirChange;
    private double bodyFacingDirection;
    private double headFacingDirection;

    public FlagInfo(FlagType type, FlagSide side, Flag flag, double distance,
                    double direction, double distChange, double dirChange,
                    double bodyFacingDirection, double headFacingDirection) {
        this.type = type;
        this.side = side;
        this.flag = flag;
        this.distance = distance;
        this.direction = direction;
        this.distChange = distChange;
        this.dirChange = dirChange;
        this.bodyFacingDirection = bodyFacingDirection;
        this.headFacingDirection = headFacingDirection;
    }

    public FlagType getType() {
        return type;
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
