package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by James on 12/11/2015.
 */
public class MoveToBallAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {

        player.dash(100);
        player.turn(model.getBallAngle() - model.getAgentAbsAngleRadians());
    }
}
