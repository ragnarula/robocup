package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.enums.PlayMode;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Created by James on 06/11/2015.
 */
public class KickAtGoalAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {

        Vector2D goalLocation = model.getGoalLocation();
        double agentAbsAngle = model.getAgentAbsAngleRadians();

        Vector2D ballLocation = model.getBallLocation();
        Vector2D ballToGoal = goalLocation.subtract(ballLocation);

        double angleBallToGoal = Vector2D.angle(ballToGoal, goalLocation);

        if(ballLocation.getX() > goalLocation.getX())
            angleBallToGoal*= -1;

        if(agentAbsAngle > Math.PI)
            agentAbsAngle = ((2*Math.PI) - agentAbsAngle)*-1;

        double kickAngle = angleBallToGoal - agentAbsAngle;

        Vector2D ownGoalLocation = model.getOwnGoalLocation();

        int kickPower;
        PlayMode playMode = model.getPlayMode();
        if(ballLocation.distance(ownGoalLocation) < 23.5 || (playMode != PlayMode.PLAY_ON && playMode != PlayMode.KICK_OFF_OWN ) )
            kickPower = 100;
        else
            kickPower = 50;

        player.kick(kickPower, kickAngle);
    }
}
