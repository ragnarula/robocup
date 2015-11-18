package info;

import com.github.robocup_atan.atan.model.enums.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by raghavnarula on 20/10/15.
 */
public class Percept {

    private int timestep;
    private int playerId;
    private List<SeeFlagInfo>                   seenFlags        = new ArrayList<>();
    private List<SeeLineInfo>                   seenLines        = new ArrayList<>();
    private List<SeePlayerInfo>                 seenPlayers      = new ArrayList<>();
    private List<SeeBallInfo>                   seenBalls        = new ArrayList<>();
    private List<RefereeMessage>                refereeMessages  = new ArrayList<>();
    private List<PlayMode>                      playModeMessages = new ArrayList<>();
    private List<HearPlayerInfo>                heardPlayers     = new ArrayList<>();
    private List<Errors>                        errors           = new ArrayList<>();
    private List<Ok>                            oks              = new ArrayList<>();
    private List<Warning>                       warnings         = new ArrayList<>();
    private List<SenseBodyInfo>                 sensedBodies     = new ArrayList<>();
    private List<CPTInfo>                       cptInfo          = new ArrayList<>();
    private List<PlayerTypeInfo>                playerTypes      = new ArrayList<>();
    private List<PlayerParamInfo>               playerParams     = new ArrayList<>();
    private List<HashMap<ServerParams, Object>> serverParams     = new ArrayList<>();

    public Percept(int timestep, int playerId) {
        this.timestep = timestep;
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getTimestep() {
        return timestep;
    }

    public void addSeenFlagInfo(final SeeFlagInfo flag) {
        seenFlags.add(flag);
    }

    public void addSeenLineInfo(final SeeLineInfo line) {
        seenLines.add(line);
    }

    public void addSeenPlayerInfo(SeePlayerInfo p) {
        seenPlayers.add(p);
    }

    public void addSeenBallInfo(SeeBallInfo b) {
        seenBalls.add(b);
    }

    public void addRefereeMessage(RefereeMessage refereeMessage) {
        refereeMessages.add(refereeMessage);
    }

    public void addPlayModeMessage(PlayMode playMode) {
        playModeMessages.add(playMode);
    }

    public void addHearPlayerInfo(HearPlayerInfo i) {
        heardPlayers.add(i);
    }

    public void addError(Errors error) {
        errors.add(error);
    }

    public void addOk(Ok ok) {
        oks.add(ok);
    }

    public void addWarning(Warning warning) {
        warnings.add(warning);
    }

    public void addSenseBodyInfo(SenseBodyInfo i) {
        sensedBodies.add(i);
    }

    public void addCPTInfo(CPTInfo i) {
        cptInfo.add(i);
    }

    public void addPlayerTypeInfo(PlayerTypeInfo i) {
        playerTypes.add(i);
    }

    public void addPlayerParam(PlayerParamInfo i) {
        playerParams.add(i);
    }

    public void addServerParam(HashMap<ServerParams, Object> info) {
        serverParams.add(info);
    }

    public List<SeeFlagInfo> getSeenFlags() {
        return seenFlags;
    }

    public List<SeeLineInfo> getSeenLines() {
        return seenLines;
    }

    public List<SeePlayerInfo> getSeenPlayers() {
        return seenPlayers;
    }

    public List<SeeBallInfo> getSeenBalls() {
        return seenBalls;
    }

    public SeeBallInfo getLastSeenBall() {
        return seenBalls.get(seenBalls.size() - 1);
    }

    public List<RefereeMessage> getRefereeMessages() {
        return refereeMessages;
    }

    public List<PlayMode> getPlayModeMessages() {
        return playModeMessages;
    }

    public List<HearPlayerInfo> getHeardPlayers() {
        return heardPlayers;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public List<Ok> getOks() {
        return oks;
    }

    public List<Warning> getWarnings() {
        return warnings;
    }

    public List<SenseBodyInfo> getSensedBodies() {
        return sensedBodies;
    }

    public List<CPTInfo> getCptInfo() {
        return cptInfo;
    }

    public List<PlayerTypeInfo> getPlayerTypes() {
        return playerTypes;
    }

    public List<PlayerParamInfo> getPlayerParams() {
        return playerParams;
    }

    public List<HashMap<ServerParams, Object>> getServerParams() {
        return serverParams;
    }

    public SenseBodyInfo getLastSensedBody() {
        return sensedBodies.get(sensedBodies.size() - 1);
    }
}
