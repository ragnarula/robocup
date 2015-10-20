package agents;

import com.github.robocup_atan.atan.model.ActionsPlayer;
import com.github.robocup_atan.atan.model.ControllerPlayer;
import com.github.robocup_atan.atan.model.enums.*;
import brain.PerceptHistory;
import info.*;

import java.util.HashMap;

/**
 * Created by raghavnarula on 19/10/15.
 */
public class Player implements ControllerPlayer {

    private int timestep = 0;
    private ActionsPlayer  player;
    private Percept        percept;
    private PerceptHistory perceptHistory;

    public Player() {
        this.perceptHistory = new PerceptHistory();
    }

    @Override
    public void preInfo() {
        percept = new Percept(timestep);
        timestep += 1;
    }

    @Override
    public void postInfo() {
        perceptHistory.addPercept(percept);
        percept = null;
    }

    @Override
    public ActionsPlayer getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(ActionsPlayer c) {
        player = c;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public void setType(String newType) {

    }


    @Override
    public void infoSeeFlagRight(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY, SeeFlagInfo.FlagSide.RIGHT, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagLeft(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY, SeeFlagInfo.FlagSide.LEFT, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY, SeeFlagInfo.FlagSide.OTHER, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagCenter(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.CENTER, SeeFlagInfo.FlagSide.CENTER, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagCornerOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.PERIMITER, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagCornerOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.PERIMITER, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagPenaltyOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.PENALTY, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagPenaltyOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.PENALTY, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagGoalOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.GOAL, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeFlagGoalOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.GOAL, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    @Override
    public void infoSeeLine(Line line, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeLineInfo l = new SeeLineInfo(line, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenLineInfo(l);
    }

    @Override
    public void infoSeePlayerOther(int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeePlayerInfo p = new SeePlayerInfo(SeePlayerInfo.PlayerTeam.OTHER, number, goalie, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenPlayerInfo(p);
    }

    @Override
    public void infoSeePlayerOwn(int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeePlayerInfo p = new SeePlayerInfo(SeePlayerInfo.PlayerTeam.OTHER, number, goalie, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenPlayerInfo(p);
    }

    @Override
    public void infoSeeBall(double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeBallInfo b = new SeeBallInfo(distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenBallInfo(b);
    }

    @Override
    public void infoHearReferee(RefereeMessage refereeMessage) {
        percept.addRefereeMessage(refereeMessage);
    }

    @Override
    public void infoHearPlayMode(PlayMode playMode) {
        percept.addPlayModeMessage(playMode);
    }

    @Override
    public void infoHearPlayer(double direction, String message) {
        HearPlayerInfo i = new HearPlayerInfo(direction, message);
        percept.addHearPlayerInfo(i);
    }

    @Override
    public void infoHearError(Errors error) {
        percept.addError(error);
    }

    @Override
    public void infoHearOk(Ok ok) {
        percept.addOk(ok);
    }

    @Override
    public void infoHearWarning(Warning warning) {
        percept.addWarning(warning);
    }

    @Override
    public void infoSenseBody(ViewQuality viewQuality, ViewAngle viewAngle, double stamina, double unknown, double effort, double speedAmount, double speedDirection, double headAngle, int kickCount, int dashCount, int turnCount, int sayCount, int turnNeckCount, int catchCount, int moveCount, int changeViewCount) {
        SenseBodyInfo i = new SenseBodyInfo(viewQuality, viewAngle, stamina, unknown,
                effort, speedAmount, speedDirection, headAngle, kickCount, dashCount,
                turnCount, sayCount, turnNeckCount, catchCount, moveCount, changeViewCount);
        percept.addSenseBodyInfo(i);
    }

    @Override
    public void infoCPTOwn(int unum, int type) {
        CPTInfo i = new CPTInfo(CPTInfo.Side.OWN, unum, type);
        percept.addCPTInfo(i);
    }

    @Override
    public void infoCPTOther(int unum) {
        CPTInfo i = new CPTInfo(CPTInfo.Side.OWN, unum, 0);
        percept.addCPTInfo(i);
    }

    @Override
    public void infoPlayerType(int id, double playerSpeedMax, double staminaIncMax, double playerDecay, double inertiaMoment, double dashPowerRate, double playerSize, double kickableMargin, double kickRand, double extraStamina, double effortMax, double effortMin) {
        PlayerTypeInfo i = new PlayerTypeInfo(id, playerSpeedMax, staminaIncMax,
                playerDecay, inertiaMoment, dashPowerRate, playerSize, kickableMargin,
                kickRand, extraStamina, effortMax, effortMin);
        percept.addPlayerTypeInfo(i);
    }

    @Override
    public void infoPlayerParam(double allowMultDefaultType, double dashPowerRateDeltaMax,
                                double dashPowerRateDeltaMin, double effortMaxDeltaFactor,
                                double effortMinDeltaFactor, double extraStaminaDeltaMax,
                                double extraStaminaDeltaMin, double inertiaMomentDeltaFactor,
                                double kickRandDeltaFactor, double kickableMarginDeltaMax,
                                double kickableMarginDeltaMin, double newDashPowerRateDeltaMax,
                                double newDashPowerRateDeltaMin, double newStaminaIncMaxDeltaFactor,
                                double playerDecayDeltaMax, double playerDecayDeltaMin, double playerTypes,
                                double ptMax, double randomSeed, double staminaIncMaxDeltaFactor, double subsMax) {

        PlayerParamInfo i = new PlayerParamInfo(allowMultDefaultType, dashPowerRateDeltaMax,
                dashPowerRateDeltaMin, effortMaxDeltaFactor,
                effortMinDeltaFactor, extraStaminaDeltaMax,
                extraStaminaDeltaMin, inertiaMomentDeltaFactor,
                kickRandDeltaFactor, kickableMarginDeltaMax,
                kickableMarginDeltaMin, newDashPowerRateDeltaMax,
                newDashPowerRateDeltaMin, newStaminaIncMaxDeltaFactor,
                playerDecayDeltaMax, playerDecayDeltaMin, playerTypes,
                ptMax, randomSeed, staminaIncMaxDeltaFactor, subsMax);

        percept.addPlayerParam(i);

    }

    @Override
    public void infoServerParam(HashMap<ServerParams, Object> info) {
        percept.addServerParam(info);
    }
}
