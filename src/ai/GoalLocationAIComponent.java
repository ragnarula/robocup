package ai;

import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public class GoalLocationAIComponent extends AbstractSimpleAIComponent{
    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        Vector2D agentLocation = model.getAgentLocation();
        Vector2D goalLocation = new Vector2D(0,52.5);
        Vector2D ownGoalLocation = new Vector2D(0, -52.5);
        Vector2D agentToGoal = goalLocation.subtract(agentLocation);

        double goalAngle = Vector2D.angle(agentToGoal, goalLocation);

        if(agentLocation.getX() > 0){
            goalAngle = (FastMath.PI * 2) - goalAngle;
        }

        model.setGoalAngle(goalAngle);
        model.setGoalLocation(goalLocation);
        model.setOwnGoalLocation(ownGoalLocation);
        model.setAgentToGoal(agentToGoal);

        return model;
    }
}
