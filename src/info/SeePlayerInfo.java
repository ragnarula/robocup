package info;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class SeePlayerInfo {

    public enum PlayerTeam {
        OWN,
        OTHER
    }

    private PlayerTeam team;
    private int number;
    private boolean goalie;
    private double distance;
    private double direction;
    private double distChange;
    private double dirChange;
    private double bodyFacingDirection;
    private double headFacingDirection;

    public SeePlayerInfo(PlayerTeam team, int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        this.team = team;
        this.number = number;
        this.goalie = goalie;
        this.distance = distance;
        this.direction = direction;
        this.distChange = distChange;
        this.dirChange = dirChange;
        this.bodyFacingDirection = bodyFacingDirection;
        this.headFacingDirection = headFacingDirection;
    }

    public PlayerTeam getTeam() {
        return team;
    }

    public int getNumber() {
        return number;
    }

    public boolean isGoalie() {
        return goalie;
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
