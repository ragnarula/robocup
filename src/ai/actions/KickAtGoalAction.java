package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.enums.PlayMode;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * This action, executed when the agent is near the ball, causes the agent to kick the ball towards
 * the goal.
 *
 * Created by James on 06/11/2015.
 */
public class KickAtGoalAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {

        Vector2D goalLocation = model.getGoalLocation();
        double agentAbsAngle = model.getAgentAbsAngleRadians();

        Vector2D ballLocation = model.getBallLocation();
        //create vector of ball to goal location by vector subtraction
        Vector2D ballToGoal = goalLocation.subtract(ballLocation);
        //get relative angle
        double angleBallToGoal = Vector2D.angle(ballToGoal, goalLocation);
        //adjust sign based on x location.
        if(ballLocation.getX() > goalLocation.getX())
            angleBallToGoal*= -1;
        //if the angle is more than 180 degrees, make the angle a left turn
        if(agentAbsAngle > Math.PI)
            agentAbsAngle = ((2*Math.PI) - agentAbsAngle)*-1;

        double kickAngle = angleBallToGoal - agentAbsAngle;

        Vector2D ownGoalLocation = model.getOwnGoalLocation();
        //adjust kick power based on distance to goal
        int kickPower;
        PlayMode playMode = model.getPlayMode();
        if(ballLocation.distance(ownGoalLocation) < 23.5 || (playMode != PlayMode.PLAY_ON && playMode != PlayMode.KICK_OFF_OWN ) )
            kickPower = 100;
        else
            kickPower = 50;

        player.kick(kickPower, kickAngle);
    }
}
