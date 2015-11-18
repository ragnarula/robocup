package ai.model;

import com.github.robocup_atan.atan.model.enums.PlayMode;
import info.Percept;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.HashMap;
import java.util.List;

/**
 * Created by raghavnarula on 02/11/2015.
 */
public class EnvironmentModel {

    private double goalAngle;
    private Vector2D goalLocation;
    private Vector2D agentToGoal;
    private double ballAngle;
    private PlayMode playMode;

    public static Vector2D getLocationFromRelativeInfo(Vector2D agentLocation, double absAngle, double distance){
        double x = FastMath.sin(absAngle) * distance;
        double y = FastMath.cos(absAngle) * distance;

        Vector2D agentToInfo = new Vector2D(x,y);
        return agentLocation.add(agentToInfo);
    }

    private List<Percept> percepts;
    private List<Command> commands;
    private Vector2D agentLocation;
    private HomeArea homeArea;
    private MovementArea movementArea;
    private double agentAbsAngel;
    private boolean hasAgentAbsAngle = false;
    private Vector2D ballLocation;
    private Vector2D agentVelocityVector;
    private HashMap<Integer, Vector2D> opposingPlayerLocations;
    private HashMap<Integer, Vector2D> friendlyPlayerLocations;

    public boolean hasAgentAbsAngle() {
        return hasAgentAbsAngle;
    }

    public void setHasAgentAbsAngle() {
        this.hasAgentAbsAngle = true;
    }

    public EnvironmentModel(List<Percept> percepts, List<Command> commands) {
        this.percepts = percepts;
        this.commands = commands;

    }

    public List<Percept> getPercepts() {
        return percepts;
    }

    public Vector2D getAgentLocation() {
        return agentLocation;
    }

    public void setAgentLocation(Vector2D agentLocation) {
        this.agentLocation = agentLocation;
    }

    public HomeArea getHomeArea() {
        return homeArea;
    }

    public void setHomeArea(HomeArea homeArea) {
        this.homeArea = homeArea;
    }

    public boolean hasAgentLocation() {
        return agentLocation != null;
    }

    public double getAgentAbsAngleRadians() {
        return agentAbsAngel;
    }

    public void setAgentAbsAngleRadians(double agentAbsAngel) {
        this.agentAbsAngel = agentAbsAngel;
    }

    public Percept getLastPercept(){
        return percepts.get(percepts.size()-1);
    }

    public void setMovementArea(MovementArea movementArea) {
        this.movementArea = movementArea;
    }

    public MovementArea getMovementArea() {
        return movementArea;
    }

    public void setBallLocation(Vector2D ballLocation) {
        this.ballLocation = ballLocation;
    }

    public Vector2D getBallLocation() {
        return ballLocation;
    }

    public List<Command> getCommands() {
        return commands;
    }

    public void setAgentVelocityVector(Vector2D agentVelocityVector) {
        this.agentVelocityVector = agentVelocityVector;
    }

    public Vector2D getAgentVelocityVector() {
        return agentVelocityVector;
    }

    public void setOpposingPlayerLocations(HashMap<Integer, Vector2D> opposingPlayerLocations) {
        this.opposingPlayerLocations = opposingPlayerLocations;
    }

    public HashMap<Integer, Vector2D> getOpposingPlayerLocations() {
        return opposingPlayerLocations;
    }

    public void setFriendlyPlayerLocations(HashMap<Integer, Vector2D> friendlyPlayerLocations) {
        this.friendlyPlayerLocations = friendlyPlayerLocations;
    }

    public HashMap<Integer, Vector2D> getFriendlyPlayerLocations() {
        return friendlyPlayerLocations;
    }

    public boolean teamHasBall() {
        if (getBallLocation() == null)
            return false;

        HashMap<Integer, Vector2D> friendlyPlayerLocations = getFriendlyPlayerLocations();
        Vector2D ballPosition = getBallLocation();

        for (Integer key : friendlyPlayerLocations.keySet()) {
            if (ballPosition.distance(friendlyPlayerLocations.get(key)) < BehaviourConfiguration.BALL_POSSESSION_RANGE)
                return true;
        }
        return false;
    }

    public boolean agentHasBall() {
        if(!getLastPercept().getSeenBalls().isEmpty()){
            return getLastPercept().getLastSeenBall().getDistance() < BehaviourConfiguration.BALL_POSSESSION_RANGE;
        }
        Vector2D loc = getBallLocation();
        if(loc != null){
            return FastMath.abs(getAgentLocation().subtract(loc).getNorm()) < BehaviourConfiguration.BALL_POSSESSION_RANGE;
        }

        return false;
    }

    public boolean ballInMovementRange() {
        if(getBallLocation() != null) {
            return getMovementArea().contains(getBallLocation());
        }
        return false;
    }

    public void setGoalAngle(double goalAngle) {
        this.goalAngle = goalAngle;
    }

    public double getGoalAngle() {
        return goalAngle;
    }

    public void setGoalLocation(Vector2D goalLocation) {
        this.goalLocation = goalLocation;
    }

    public Vector2D getGoalLocation() {
        return goalLocation;
    }

    public void setAgentToGoal(Vector2D agentToGoal) {
        this.agentToGoal = agentToGoal;
    }

    public Vector2D getAgentToGoal() {
        return agentToGoal;
    }

    public void setBallAngle(double ballAngle) {
        this.ballAngle = ballAngle;
    }

    public double getBallAngle() {
        return ballAngle;
    }

    public boolean agentInMovementArea() {
        return movementArea.contains(getAgentLocation());
    }

    public void setPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }

    public PlayMode getPlayMode() {
        return playMode;
    }
}
