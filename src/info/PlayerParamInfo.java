package info;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class PlayerParamInfo {

    private double allowMultDefaultType;
    private double dashPowerRateDeltaMa;
    private double dashPowerRateDeltaMin;
    private double effortMaxDeltaFacto;
    private double effortMinDeltaFactor;
    private double extraStaminaDeltaMa;
    private double extraStaminaDeltaMin;
    private double inertiaMomentDeltaFacto;
    private double kickRandDeltaFactor;
    private double kickableMarginDeltaMax;
    private double kickableMarginDeltaMin;
    private double newDashPowerRateDeltaMax;
    private double newDashPowerRateDeltaMin;
    private double newStaminaIncMaxDeltaFacto;
    private double playerDecayDeltaMax;
    private double playerDecayDeltaMin;
    private double playerType;
    private double ptMax;
    private double randomSeed;
    private double staminaIncMaxDeltaFactor;
    private double subsMa;

    public PlayerParamInfo(double allowMultDefaultType, double dashPowerRateDeltaMa,
                           double dashPowerRateDeltaMin, double effortMaxDeltaFacto,
                           double effortMinDeltaFactor, double extraStaminaDeltaMa,
                           double extraStaminaDeltaMin, double inertiaMomentDeltaFacto,
                           double kickRandDeltaFactor, double kickableMarginDeltaMax,
                           double kickableMarginDeltaMin, double newDashPowerRateDeltaMax,
                           double newDashPowerRateDeltaMin, double newStaminaIncMaxDeltaFacto,
                           double playerDecayDeltaMax, double playerDecayDeltaMin, double playerType,
                           double ptMax, double randomSeed, double staminaIncMaxDeltaFactor, double subsMa) {

        this.allowMultDefaultType = allowMultDefaultType;
        this.dashPowerRateDeltaMa = dashPowerRateDeltaMa;
        this.dashPowerRateDeltaMin = dashPowerRateDeltaMin;
        this.effortMaxDeltaFacto = effortMaxDeltaFacto;
        this.effortMinDeltaFactor = effortMinDeltaFactor;
        this.extraStaminaDeltaMa = extraStaminaDeltaMa;
        this.extraStaminaDeltaMin = extraStaminaDeltaMin;
        this.inertiaMomentDeltaFacto = inertiaMomentDeltaFacto;
        this.kickRandDeltaFactor = kickRandDeltaFactor;
        this.kickableMarginDeltaMax = kickableMarginDeltaMax;
        this.kickableMarginDeltaMin = kickableMarginDeltaMin;
        this.newDashPowerRateDeltaMax = newDashPowerRateDeltaMax;
        this.newDashPowerRateDeltaMin = newDashPowerRateDeltaMin;
        this.newStaminaIncMaxDeltaFacto = newStaminaIncMaxDeltaFacto;
        this.playerDecayDeltaMax = playerDecayDeltaMax;
        this.playerDecayDeltaMin = playerDecayDeltaMin;
        this.playerType = playerType;
        this.ptMax = ptMax;
        this.randomSeed = randomSeed;
        this.staminaIncMaxDeltaFactor = staminaIncMaxDeltaFactor;
        this.subsMa = subsMa;
    }

    public double getAllowMultDefaultType() {
        return allowMultDefaultType;
    }

    public double getDashPowerRateDeltaMa() {
        return dashPowerRateDeltaMa;
    }

    public double getDashPowerRateDeltaMin() {
        return dashPowerRateDeltaMin;
    }

    public double getEffortMaxDeltaFacto() {
        return effortMaxDeltaFacto;
    }

    public double getEffortMinDeltaFactor() {
        return effortMinDeltaFactor;
    }

    public double getExtraStaminaDeltaMa() {
        return extraStaminaDeltaMa;
    }

    public double getExtraStaminaDeltaMin() {
        return extraStaminaDeltaMin;
    }

    public double getInertiaMomentDeltaFacto() {
        return inertiaMomentDeltaFacto;
    }

    public double getKickRandDeltaFactor() {
        return kickRandDeltaFactor;
    }

    public double getKickableMarginDeltaMax() {
        return kickableMarginDeltaMax;
    }

    public double getKickableMarginDeltaMin() {
        return kickableMarginDeltaMin;
    }

    public double getNewDashPowerRateDeltaMax() {
        return newDashPowerRateDeltaMax;
    }

    public double getNewDashPowerRateDeltaMin() {
        return newDashPowerRateDeltaMin;
    }

    public double getNewStaminaIncMaxDeltaFacto() {
        return newStaminaIncMaxDeltaFacto;
    }

    public double getPlayerDecayDeltaMax() {
        return playerDecayDeltaMax;
    }

    public double getPlayerDecayDeltaMin() {
        return playerDecayDeltaMin;
    }

    public double getPlayerType() {
        return playerType;
    }

    public double getPtMax() {
        return ptMax;
    }

    public double getRandomSeed() {
        return randomSeed;
    }

    public double getStaminaIncMaxDeltaFactor() {
        return staminaIncMaxDeltaFactor;
    }

    public double getSubsMa() {
        return subsMa;
    }
}
