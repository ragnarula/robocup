package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Turns the agent towards the ball.
 * Created by raghavnarula on 16/11/2015.
 */
public class LookAtBallAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {
        //turn towards relative angle of player and ball
        player.turn(model.getBallAngle() - model.getAgentAbsAngleRadians());
    }
}
