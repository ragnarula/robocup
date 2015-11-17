package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Created by James on 06/11/2015.
 */
public class KickAtGoalAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {

        Vector2D agentLocation = model.getAgentLocation();
        Vector2D goalLocation = model.getGoalLocation();
        double agentAbsAngle = model.getAgentAbsAngleRadians();
        double angleToGoal = model.getGoalAngle();

        Vector2D ballLocation = model.getBallLocation();
        Vector2D ballToGoal = goalLocation.subtract(ballLocation);

        double angleBallToGoal = Vector2D.angle(ballToGoal, goalLocation);

        double kickAngle; 

        if(ballLocation.getX() > goalLocation.getX())
            angleBallToGoal*= -1;

        if(agentAbsAngle > Math.PI)
            agentAbsAngle = ( (2*Math.PI) - agentAbsAngle)*-1;

        kickAngle = angleBallToGoal - agentAbsAngle;

        player.kick(50, kickAngle);
    }
}
