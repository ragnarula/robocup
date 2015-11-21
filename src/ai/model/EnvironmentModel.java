package ai.model;

import com.github.robocup_atan.atan.model.enums.PlayMode;
import info.Percept;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import java.util.HashMap;
import java.util.List;

/**
 * This is the main model object. It must be initialised with list of percepts as well as a list of commands executed.
 * The lists can be empty, but must be provided.
 *
 * This model is passed to AIComponents one by one, which use the information in the percepts to add more information
 * back in to the model.
 * Most of the methods are simple setters and getters, and thus are not commented.
 * Some methods contain some simple logic, the purpose of which is given in comments below.
 */
public class EnvironmentModel {

    private double goalAngle;
    private Vector2D goalLocation;
    private Vector2D agentToGoal;
    private double ballAngle;
    private Vector2D ownGoalLocation;
    private PlayMode playMode;

    /**
     * Static method used to build a 2D location vector from direction and angle relative to some specified point
     * @param relativeOrigin The point which the distance and angle are relative to
     * @param absAngle The direction in radians to the other object
     * @param distance The distance to the other object
     * @return Vector2D representing the location of the other object relative to the same origin as the vector given.
     */
    public static Vector2D getLocationFromRelativeInfo(Vector2D relativeOrigin, double absAngle, double distance){
        double x = FastMath.sin(absAngle) * distance;
        double y = FastMath.cos(absAngle) * distance;

        Vector2D agentToInfo = new Vector2D(x,y);
        return relativeOrigin.add(agentToInfo);
    }

    /**
     * Figure out whether this agent's team is currently in possession of the ball.
     * Currently based on the ball's distance to friendly players, would ideally be based on
     * last touch.
     * @return True of False
     */
    public boolean teamHasBall() {
        // return false if the ball's location is unknown.
        if (getBallLocation() == null)
            return false;

        HashMap<Integer, Vector2D> friendlyPlayerLocations = getFriendlyPlayerLocations();
        Vector2D ballPosition = getBallLocation();

        //if ball is within range of any friendly player return true
        for (Integer key : friendlyPlayerLocations.keySet()) {
            if (ballPosition.distance(friendlyPlayerLocations.get(key)) < BehaviourConfiguration.BALL_POSSESSION_RANGE)
                return true;
        }
        return false;
    }

    /**
     * Figure out if this agent currently has possession of the ball
     * Currently based on distance to the ball, ideally should change to last touch.
     * @return True or False
     */
    public boolean agentHasBall() {
        // if a percept containing ball info is available, test its distance.
        if(!getLastPercept().getSeenBalls().isEmpty()){
            return getLastPercept().getLastSeenBall().getDistance() < BehaviourConfiguration.BALL_POSSESSION_RANGE;
        }
        // otherwise use ball location vector set by BallLocationAIComponent.
        // Using this second as it may contain rounding error.
        Vector2D loc = getBallLocation();
        if(loc != null){
            return FastMath.abs(getAgentLocation().subtract(loc).getNorm()) < BehaviourConfiguration.BALL_POSSESSION_RANGE;
        }

        return false;
    }

    /**
     * Test whether the ball is within the agent's movement range.
     * @return True or False
     */
    public boolean ballInMovementRange() {
        if(getBallLocation() != null) {
            return getMovementArea().contains(getBallLocation());
        }
        return false;
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

    public void setOwnGoalLocation(Vector2D ownGoalLocation) {
        this.ownGoalLocation = ownGoalLocation;
    }

    public Vector2D getOwnGoalLocation() {
        return ownGoalLocation;
    }

    public void setPlayMode(PlayMode playMode) {
        this.playMode = playMode;
    }

    public PlayMode getPlayMode() {
        return playMode;
    }
}
