package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by James on 06/11/2015.
 */
public class MoveBallAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {

        Vector2D agentLocation = model.getAgentLocation();
        double agentAbsAngle = model.getAgentAbsAngleRadians();
        double ballAngle = FastMath.toRadians(model.getLastPercept().getLastSeenBalls().getDirection());

        Vector2D goalLocation = new Vector2D(0, 52.5);

        Vector2D toGoal = goalLocation.subtract(model.getAgentLocation());
        double angleToGoal = Vector2D.angle(toGoal, new Vector2D(0,1));

        double kickAngle;

        if(agentLocation.getX() > 0)
            kickAngle = FastMath.toDegrees(agentAbsAngle + angleToGoal);
        else
            kickAngle = FastMath.toDegrees(agentAbsAngle - angleToGoal);

        player.kick(50, kickAngle);
    }
}
