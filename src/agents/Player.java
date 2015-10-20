package agents;

import com.github.robocup_atan.atan.model.ActionsPlayer;
import com.github.robocup_atan.atan.model.ControllerPlayer;
import com.github.robocup_atan.atan.model.enums.*;
import brain.PerceptHistory;
import info.Percept;
import info.flag.FlagInfo;
import info.flag.FlagSide;
import info.flag.FlagType;

import java.util.HashMap;

/**
 * Created by raghavnarula on 19/10/15.
 */
public class Player implements ControllerPlayer {

    private int timestep = 0;
    private ActionsPlayer player;
    private Percept percept;
    private PerceptHistory perceptHistory;

    public Player(){
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
        FlagInfo f = new FlagInfo(FlagType.BOUNDRY, FlagSide.LEFT, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagLeft(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.BOUNDRY, FlagSide.RIGHT, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.BOUNDRY, FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.BOUNDRY, FlagSide.OTHER, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagCenter(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.PITCH, FlagSide.CENTER, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagCornerOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.PERIMITER, FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagCornerOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.PERIMITER, FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagPenaltyOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.PITCH, FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagPenaltyOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.PITCH, FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagGoalOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.GOAL, FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeFlagGoalOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        FlagInfo f = new FlagInfo(FlagType.GOAL, FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addFlag(f);
    }

    @Override
    public void infoSeeLine(Line line, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {

    }

    @Override
    public void infoSeePlayerOther(int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {

    }

    @Override
    public void infoSeePlayerOwn(int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {

    }

    @Override
    public void infoSeeBall(double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {

    }

    @Override
    public void infoHearReferee(RefereeMessage refereeMessage) {

    }

    @Override
    public void infoHearPlayMode(PlayMode playMode) {

    }

    @Override
    public void infoHearPlayer(double direction, String message) {

    }

    @Override
    public void infoHearError(Errors error) {

    }

    @Override
    public void infoHearOk(Ok ok) {

    }

    @Override
    public void infoHearWarning(Warning warning) {

    }

    @Override
    public void infoSenseBody(ViewQuality viewQuality, ViewAngle viewAngle, double stamina, double unknown, double effort, double speedAmount, double speedDirection, double headAngle, int kickCount, int dashCount, int turnCount, int sayCount, int turnNeckCount, int catchCount, int moveCount, int changeViewCount) {

    }

    @Override
    public void infoCPTOwn(int unum, int type) {

    }

    @Override
    public void infoCPTOther(int unum) {

    }

    @Override
    public void infoPlayerType(int id, double playerSpeedMax, double staminaIncMax, double playerDecay, double inertiaMoment, double dashPowerRate, double playerSize, double kickableMargin, double kickRand, double extraStamina, double effortMax, double effortMin) {

    }

    @Override
    public void infoPlayerParam(double allowMultDefaultType, double dashPowerRateDeltaMax, double dashPowerRateDeltaMin, double effortMaxDeltaFactor, double effortMinDeltaFactor, double extraStaminaDeltaMax, double extraStaminaDeltaMin, double inertiaMomentDeltaFactor, double kickRandDeltaFactor, double kickableMarginDeltaMax, double kickableMarginDeltaMin, double newDashPowerRateDeltaMax, double newDashPowerRateDeltaMin, double newStaminaIncMaxDeltaFactor, double playerDecayDeltaMax, double playerDecayDeltaMin, double playerTypes, double ptMax, double randomSeed, double staminaIncMaxDeltaFactor, double subsMax) {

    }

    @Override
    public void infoServerParam(HashMap<ServerParams, Object> info) {

    }
}
