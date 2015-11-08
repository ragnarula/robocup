package ai.actions;

import ai.model.EnvironmentModel;
import ai.model.HomeArea;
import com.github.robocup_atan.atan.model.ActionsPlayer;
//import jdk.nashorn.internal.runtime.Logging;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

import org.apache.log4j.Logger;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public class ReturnHomeAction implements Action {

    private static Logger log = Logger.getLogger(ReturnHomeAction.class);

    @Override
    public void takeAction(ActionsPlayer player, EnvironmentModel model) {
        HomeArea homeArea = model.getHomeArea();
        //absolute angle agent is facing
        double agentBodyFacing = model.getAgentAbsAngleRadians();

        Vector2D homeCenter = homeArea.getMidpoint();
        Vector2D agentLocation = model.getAgentLocation();
        Vector2D agentToHome = homeCenter.subtract(agentLocation);

        double angleToHomeRadians = Vector2D.angle(agentToHome, new Vector2D(0,1));

        if(!almostFacing(agentBodyFacing, angleToHomeRadians)){
            player.turn(5);
        }
        else {
            player.dash(20);
        }

        log.debug(player.getNumber() + " " + homeCenter + " " + agentLocation + " " + agentToHome + " " + agentBodyFacing + " " + angleToHomeRadians);


    }

    private boolean almostFacing(double angle1, double angle2) {
        return FastMath.abs(angle1 - angle2) <= 0.1;
    }


}
