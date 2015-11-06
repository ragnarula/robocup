package info;

import com.github.robocup_atan.atan.model.enums.Flag;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

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

    public Vector2D getBoundryFlagLocation(){
        return new Vector2D(getX(),getY());
    }

    public boolean isBoundryFlag(){
        return line == FlagLine.BOUNDRY;
    }


    private double getY() {
        if(side == FlagSide.OWN) {
            return  -57.5;
        }
        if(side == FlagSide.OTHER) {
            return 57.5;
        }

        if(side == FlagSide.LEFT || side == FlagSide.RIGHT) {
            switch (flag) {
                case OWN_10:
                    return -10;
                case OWN_20:
                    return -20;
                case OWN_30:
                    return -30;
                case OWN_40:
                    return -40;
                case OWN_50:
                    return -50;
                case OTHER_10:
                    return 10;
                case OTHER_20:
                    return 20;
                case OTHER_30:
                    return 30;
                case OTHER_40:
                    return 40;
                case OTHER_50:
                    return 50;
            }
        }
        return 0;
    }

    private double getX() {
        if(side == FlagSide.LEFT) {
            return  -39.0;
        }
        if(side == FlagSide.RIGHT) {
            return 39.0;
        }

        if(side == FlagSide.OWN || side == FlagSide.OTHER) {
            switch (flag) {
                case LEFT_10:
                    return -10;
                case LEFT_20:
                    return -20;
                case LEFT_30:
                    return -30;
                case RIGHT_10:
                    return 10;
                case RIGHT_20:
                    return 20;
                case RIGHT_30:
                    return 30;
            }
        }
        return 0;
    }

    public double getFlagAbsAngleRadians(){
        return FastMath.toRadians(bodyFacingDirection + headFacingDirection + direction);
    }
}
