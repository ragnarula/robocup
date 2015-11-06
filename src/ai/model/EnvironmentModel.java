package ai.model;

import info.Percept;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;

/**
 * Created by raghavnarula on 02/11/2015.
 */
public class EnvironmentModel {

    private List<Percept> percepts;
    private Vector2D agentLocation;
    private HomeArea homeArea;
    private double agentAbsAngel;
    private double bodyFacingRadians;
    private double headFacingRadians;

    public EnvironmentModel(List<Percept> percepts) {
        this.percepts = percepts;
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

    public double getBodyFacingRadians() {
        return bodyFacingRadians;
    }

    public void setBodyFacingRadians(double bodyFacingRadians) {
        this.bodyFacingRadians = bodyFacingRadians;
    }

    public double getHeadFacingRadians() {
        return headFacingRadians;
    }

    public void setHeadFacingRadians(double headFacingRadians) {
        this.headFacingRadians = headFacingRadians;
    }

    public Percept getLastPercept(){
        return percepts.get(percepts.size()-1);
    }


}
