package info;

import com.github.robocup_atan.atan.model.enums.ViewAngle;
import com.github.robocup_atan.atan.model.enums.ViewQuality;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class SenseBodyInfo {
    private ViewQuality viewQuality;
    private ViewAngle viewAngle;
    private double stamina;
    private double unknown;
    private double effort;
    private double speedAmount;
    private double speedDirection;
    private double headAngle;
    private int kickCount;
    private int dashCount;
    private int turnCount;
    private int sayCount;
    private int turnNeckCount;
    private int catchCount;
    private int moveCount;
    private int changeViewCount;

    public SenseBodyInfo(ViewQuality viewQuality, ViewAngle viewAngle,
                         double stamina, double unknown, double effort,
                         double speedAmount, double speedDirection,
                         double headAngle, int kickCount, int dashCount,
                         int turnCount, int sayCount, int turnNeckCount,
                         int catchCount, int moveCount, int changeViewCount) {
        this.viewQuality = viewQuality;
        this.viewAngle = viewAngle;
        this.stamina = stamina;
        this.unknown = unknown;
        this.effort = effort;
        this.speedAmount = speedAmount;
        this.speedDirection = speedDirection;
        this.headAngle = headAngle;
        this.kickCount = kickCount;
        this.dashCount = dashCount;
        this.turnCount = turnCount;
        this.sayCount = sayCount;
        this.turnNeckCount = turnNeckCount;
        this.catchCount = catchCount;
        this.moveCount = moveCount;
        this.changeViewCount = changeViewCount;
    }

    public ViewQuality getViewQuality() {
        return viewQuality;
    }

    public ViewAngle getViewAngle() {
        return viewAngle;
    }

    public double getStamina() {
        return stamina;
    }

    public double getUnknown() {
        return unknown;
    }

    public double getEffort() {
        return effort;
    }

    public double getSpeedAmount() {
        return speedAmount;
    }

    public double getSpeedDirection() {
        return speedDirection;
    }

    public double getHeadAngle() {
        return headAngle;
    }

    public int getKickCount() {
        return kickCount;
    }

    public int getDashCount() {
        return dashCount;
    }

    public int getTurnCount() {
        return turnCount;
    }

    public int getSayCount() {
        return sayCount;
    }

    public int getTurnNeckCount() {
        return turnNeckCount;
    }

    public int getCatchCount() {
        return catchCount;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public int getChangeViewCount() {
        return changeViewCount;
    }
}
