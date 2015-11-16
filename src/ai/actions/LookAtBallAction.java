package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 16/11/2015.
 */
public class LookAtBallAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {
        player.turn(model.getBallAngle() - model.getAgentAbsAngleRadians());
    }
}
