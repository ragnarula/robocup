package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Created by raghavnarula on 16/11/2015.
 */
public class LookAtBallAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {
        player.turn(model.getBallAngle() - model.getAgentAbsAngleRadians());
    }
}
