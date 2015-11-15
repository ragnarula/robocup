package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by James on 12/11/2015.
 */
public class DefendAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {

        Vector2D ballLocation = model.getBallLocation();
        Vector2D agentLocation = model.getAgentLocation();
        Vector2D agentToBall = ballLocation.subtract(agentLocation);

        double unsignedAngleToBallRadians = Vector2D.angle(agentToBall, new Vector2D(0, 1));
        double angleToBallRadians = unsignedAngleToBallRadians;

        if (ballLocation.getX() < agentLocation.getX()) {
            angleToBallRadians = ((2 * FastMath.PI) - unsignedAngleToBallRadians);
        }
        double agentAngleRadians = model.getAgentAbsAngleRadians();
        if(!Action.almostFacing(angleToBallRadians, agentAngleRadians)){
            player.turn(angleToBallRadians - agentAngleRadians);
        }
        player.dash(50);
    }

}
