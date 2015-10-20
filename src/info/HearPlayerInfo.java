package info;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class HearPlayerInfo {

    private double direction;
    private String message;

    public HearPlayerInfo(double direction, String message) {
        this.direction = direction;
        this.message = message;
    }

    public double getDirection() {
        return direction;
    }

    public String getMessage() {
        return message;
    }
}
