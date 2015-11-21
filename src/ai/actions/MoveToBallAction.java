package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Causes the agent to dash towards the ball
 * Created by James on 12/11/2015.
 */
public class MoveToBallAction implements Action {
    @Override
        public void takeAction(CommandPlayer player, EnvironmentModel model) {

            Vector2D ballLocation = model.getBallLocation();
            Vector2D goalLocation = model.getGoalLocation();
            Vector2D ownGoalLocation = model.getOwnGoalLocation();
            //adjust dash power based on ball's distance to either goal
            if(ballLocation.distance(ownGoalLocation) < 23.5 || ballLocation.distance(goalLocation) < 23.5)
                player.dash(120);
            else
                player.dash(80);

            player.turn(model.getBallAngle() - model.getAgentAbsAngleRadians());
        }
}
