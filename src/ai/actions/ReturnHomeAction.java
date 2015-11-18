package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import ai.model.HomeArea;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import org.apache.log4j.Logger;

/**
 * Moves an agent to its home area.
 *
 * Created by raghavnarula on 05/11/2015.
 */
public class ReturnHomeAction implements Action {

    private static Logger log = Logger.getLogger(ReturnHomeAction.class);

    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {
        HomeArea homeArea = model.getHomeArea();

        Vector2D homeCenter = homeArea.getMidpoint();
        Vector2D agentLocation = model.getAgentLocation();
        Vector2D agentToHome = homeCenter.subtract(agentLocation);

        double unsignedAngleToHomeRadians = Vector2D.angle(agentToHome, new Vector2D(0,1));
        double angleToHomeRadians = unsignedAngleToHomeRadians;

        if(homeCenter.getX() < agentLocation.getX()){
            angleToHomeRadians = ((2 * FastMath.PI) - unsignedAngleToHomeRadians);
        }
        double agentAngleRadians = model.getAgentAbsAngleRadians();
        player.dash(30);
        player.turn(angleToHomeRadians - agentAngleRadians);

    }
}
