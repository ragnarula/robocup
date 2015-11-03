package ai.model;

import com.sun.javafx.geom.Vec2d;
import info.Percept;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.List;

/**
 * Created by raghavnarula on 02/11/2015.
 */
public class EnvironmentModel {

    private List<Percept> percepts;
    private Vector2D agentLocation;

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
}
