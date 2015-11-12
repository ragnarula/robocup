package ai.model;

import info.Percept;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.HashMap;
import java.util.List;

/**
 * Created by raghavnarula on 02/11/2015.
 */
public class EnvironmentModel {

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
}
