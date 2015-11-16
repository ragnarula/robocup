package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

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


        double kickAngle;

        if(agentLocation.getX() > goalLocation.getX())
            kickAngle = (FastMath.PI*2) - angleToGoal - agentAbsAngle;
        else
            kickAngle = angleToGoal - agentAbsAngle;

        player.kick(50, kickAngle);
    }
}
