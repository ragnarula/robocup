package info;

import com.github.robocup_atan.atan.model.enums.Line;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class SeeLineInfo {
    private Line line;
    private double distance;
    private double direction;
    private double distChange;
    private double dirChange;
    private double bodyFacingDirection;
    private double headFacingDirection;

    public SeeLineInfo(Line line, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        this.line = line;
        this.distance = distance;
        this.direction = direction;
        this.distChange = distChange;
        this.dirChange = dirChange;
        this.bodyFacingDirection = bodyFacingDirection;
        this.headFacingDirection = headFacingDirection;
    }

    public Line getLine() {
        return line;
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
