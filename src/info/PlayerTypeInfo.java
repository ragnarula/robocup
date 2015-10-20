package info;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class PlayerTypeInfo {
    private int    id;
    private double playerSpeedMax;
    private double staminaIncMax;
    private double playerDecay;
    private double inertiaMoment;
    private double dashPowerRate;
    private double playerSize;
    private double kickableMargin;
    private double kickRand;
    private double extraStamina;
    private double effortMax;
    private double effortMin;

    public PlayerTypeInfo(int id, double playerSpeedMax, double staminaIncMax,
                          double playerDecay, double inertiaMoment, double dashPowerRate,
                          double playerSize, double kickableMargin, double kickRand,
                          double extraStamina, double effortMax, double effortMin) {
        this.id = id;
        this.playerSpeedMax = playerSpeedMax;
        this.staminaIncMax = staminaIncMax;
        this.playerDecay = playerDecay;
        this.inertiaMoment = inertiaMoment;
        this.dashPowerRate = dashPowerRate;
        this.playerSize = playerSize;
        this.kickableMargin = kickableMargin;
        this.kickRand = kickRand;
        this.extraStamina = extraStamina;
        this.effortMax = effortMax;
        this.effortMin = effortMin;
    }

    public int getId() {
        return id;
    }

    public double getPlayerSpeedMax() {
        return playerSpeedMax;
    }

    public double getStaminaIncMax() {
        return staminaIncMax;
    }

    public double getPlayerDecay() {
        return playerDecay;
    }

    public double getInertiaMoment() {
        return inertiaMoment;
    }

    public double getDashPowerRate() {
        return dashPowerRate;
    }

    public double getPlayerSize() {
        return playerSize;
    }

    public double getKickableMargin() {
        return kickableMargin;
    }

    public double getKickRand() {
        return kickRand;
    }

    public double getExtraStamina() {
        return extraStamina;
    }

    public double getEffortMax() {
        return effortMax;
    }

    public double getEffortMin() {
        return effortMin;
    }
}
