package agent;

import ai.AgentAI;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import ai.model.PerceptHistory;
import com.github.robocup_atan.atan.model.ActionsPlayer;
import com.github.robocup_atan.atan.model.ControllerPlayer;
import com.github.robocup_atan.atan.model.enums.*;
import info.*;

import java.util.HashMap;

/**
 * Our implementation of the ControllerPlayer interface.
 * The aim of this class is to bring together our EnvironmentModel, our chain of AI Component and the ActionsPlayer set
 * by the ATAM API.
 *
 * During each simulation step we build a 'Percept' object which stores all the info sent to the controller by the server.
 * The Percept is then added to the PerceptHistory.
 *
 * Next, when postInfo is called, the percept history added to a new model, which is pushed into the first component in the
 * chain of AI components, along with a list of commands executed in the previous simulation step, given by the CommandPlayer.
 */
public class Player implements ControllerPlayer {

    private int timestep = 0;
    private int playerNumber;
    private ActionsPlayer  player;
    private info.Percept percept;
    private PerceptHistory perceptHistory = new PerceptHistory();
    private AgentAI agentAI;
    private CommandPlayer commandPlayer;

    /**
     *
     * @param playerNumber The player number given during initialisation by @see agent.Team class.
     *                     Should begin at 0 (goalkeppe) and end at 10.
     */
    public Player(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    /** {@inheritDoc}
     * Create new empty percept ready to receive info.
     * */
    @Override
    public void preInfo() {
        percept = new Percept(timestep, playerNumber);
        timestep += 1;
    }

    /** {@inheritDoc}
     *
     * Adds Percept to the complete history, create model with percept and command history, and give to AI to process.
     * */
    @Override
    public void postInfo() {
        perceptHistory.addPercept(percept);
        percept = null;
        agentAI.put(new EnvironmentModel(perceptHistory.getCopyWithLastPercept(), commandPlayer.getAndClearHistory()));
    }

    /** {@inheritDoc} */
    @Override
    public ActionsPlayer getPlayer() {
        return player;
    }

    /** {@inheritDoc} */
    @Override
    public void setPlayer(ActionsPlayer c) {
        player = c;
        commandPlayer = new CommandPlayer(c);
        agentAI = new AgentAI(commandPlayer);
    }

    /** {@inheritDoc} */
    @Override
    public String getType() {
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public void setType(String newType) {

    }


    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagRight(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY, SeeFlagInfo.FlagSide.RIGHT, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagLeft(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY, SeeFlagInfo.FlagSide.LEFT, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.BOUNDRY, SeeFlagInfo.FlagSide.OTHER, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagCenter(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.CENTER, SeeFlagInfo.FlagSide.CENTER, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagCornerOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.PERIMITER, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagCornerOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.PERIMITER, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagPenaltyOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.PENALTY, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagPenaltyOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.PENALTY, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagGoalOwn(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.GOAL, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeFlagGoalOther(Flag flag, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeFlagInfo f = new SeeFlagInfo(SeeFlagInfo.FlagLine.GOAL, SeeFlagInfo.FlagSide.OWN, flag, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenFlagInfo(f);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeLine(Line line, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeLineInfo l = new SeeLineInfo(line, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenLineInfo(l);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeePlayerOther(int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeePlayerInfo p = new SeePlayerInfo(SeePlayerInfo.PlayerTeam.OTHER, number, goalie, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenPlayerInfo(p);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeePlayerOwn(int number, boolean goalie, double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeePlayerInfo p = new SeePlayerInfo(SeePlayerInfo.PlayerTeam.OWN, number, goalie, distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenPlayerInfo(p);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSeeBall(double distance, double direction, double distChange, double dirChange, double bodyFacingDirection, double headFacingDirection) {
        SeeBallInfo b = new SeeBallInfo(distance, direction, distChange, dirChange, bodyFacingDirection, headFacingDirection);
        percept.addSeenBallInfo(b);
    }

    /** {@inheritDoc} */
    @Override
    public void infoHearReferee(RefereeMessage refereeMessage) {
        percept.addRefereeMessage(refereeMessage);
    }

    /** {@inheritDoc} */
    @Override
    public void infoHearPlayMode(PlayMode playMode) {
        percept.addPlayModeMessage(playMode);

        if (playMode == PlayMode.GOAL_OWN || playMode == PlayMode.GOAL_OTHER|| playMode == PlayMode.BEFORE_KICK_OFF  ) {
            this.pause(1000);
            switch (this.getPlayer().getNumber()) {
                case 1 :
                    this.commandPlayer.move(-40, 0);
                    break;
                case 2 :
                    this.commandPlayer.move(-10, -20);
                    break;
                case 3 :
                    this.commandPlayer.move(-12, -7);
                    break;
                case 4 :
                    this.commandPlayer.move(-12, -2);
                    break;
                case 5 :
                    this.commandPlayer.move(-12, 2);
                    break;
                case 6 :
                    this.commandPlayer.move(-12, 7);
                    break;
                case 7 :
                    this.commandPlayer.move(-30, -25);
                    break;
                case 8 :
                    this.commandPlayer.move(-30, -10);
                    break;
                case 9 :
                    this.commandPlayer.move(-30, 10);
                    break;
                case 10 :
                    this.commandPlayer.move(-30, 25);
                    break;
                case 11 :
                    this.commandPlayer.move(-10, 20);
                    break;
                default :
                    throw new Error("number must be initialized before move");
            }
        }
    }

    /** {@inheritDoc} */
    @Override
    public void infoHearPlayer(double direction, String message) {
        HearPlayerInfo i = new HearPlayerInfo(direction, message);
        percept.addHearPlayerInfo(i);
    }

    /** {@inheritDoc} */
    @Override
    public void infoHearError(Errors error) {
        percept.addError(error);
    }

    /** {@inheritDoc} */
    @Override
    public void infoHearOk(Ok ok) {
        percept.addOk(ok);
    }

    /** {@inheritDoc} */
    @Override
    public void infoHearWarning(Warning warning) {
        percept.addWarning(warning);
    }

    /** {@inheritDoc} */
    @Override
    public void infoSenseBody(ViewQuality viewQuality, ViewAngle viewAngle, double stamina, double unknown, double effort, double speedAmount, double speedDirection, double headAngle, int kickCount, int dashCount, int turnCount, int sayCount, int turnNeckCount, int catchCount, int moveCount, int changeViewCount) {
        SenseBodyInfo i = new SenseBodyInfo(viewQuality, viewAngle, stamina, unknown,
                effort, speedAmount, speedDirection, headAngle, kickCount, dashCount,
                turnCount, sayCount, turnNeckCount, catchCount, moveCount, changeViewCount);
        percept.addSenseBodyInfo(i);
    }

    /** {@inheritDoc} */
    @Override
    public void infoCPTOwn(int unum, int type) {
        CPTInfo i = new CPTInfo(CPTInfo.Side.OWN, unum, type);
        percept.addCPTInfo(i);
    }

    /** {@inheritDoc} */
    @Override
    public void infoCPTOther(int unum) {
        CPTInfo i = new CPTInfo(CPTInfo.Side.OWN, unum, 0);
        percept.addCPTInfo(i);
    }

    /** {@inheritDoc} */
    @Override
    public void infoPlayerType(int id, double playerSpeedMax, double staminaIncMax, double playerDecay, double inertiaMoment, double dashPowerRate, double playerSize, double kickableMargin, double kickRand, double extraStamina, double effortMax, double effortMin) {
        PlayerTypeInfo i = new PlayerTypeInfo(id, playerSpeedMax, staminaIncMax,
                playerDecay, inertiaMoment, dashPowerRate, playerSize, kickableMargin,
                kickRand, extraStamina, effortMax, effortMin);
        percept.addPlayerTypeInfo(i);
    }

    /** {@inheritDoc} */
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

    /** {@inheritDoc} */
    @Override
    public void infoServerParam(HashMap<ServerParams, Object> info) {
        percept.addServerParam(info);
    }

    private synchronized void pause(int ms) {
        try {
            this.wait(ms);
        } catch (InterruptedException ex) {
//            log.warn("Interrupted Exception ", ex);
        }
    }
}