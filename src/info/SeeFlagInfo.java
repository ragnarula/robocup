package info;

import com.github.robocup_atan.atan.model.enums.Flag;

/**
 * Created by raghavnarula on 19/10/15.
 */
public class SeeFlagInfo {

    public enum FlagLine {
        BOUNDRY,
        PERIMITER,
        PENALTY,
        GOAL,
        CENTER
    }

    public enum FlagSide {
        OWN,
        OTHER,
        LEFT,
        RIGHT,
        CENTER
    }

    private SeeFlagInfo.FlagLine line;
    private SeeFlagInfo.FlagSide side;
    private Flag flag;
    private double distance;
    private double direction;
    private double distChange;
    private double dirChange;
    private double bodyFacingDirection;
    private double headFacingDirection;

    public SeeFlagInfo(SeeFlagInfo.FlagLine line, SeeFlagInfo.FlagSide side, Flag flag, double distance,
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

    public SeeFlagInfo.FlagLine getLine() {
        return line;
    }

    public SeeFlagInfo.FlagSide getSide() {
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
