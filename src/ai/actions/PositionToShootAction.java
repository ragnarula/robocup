package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import info.SeeBallInfo;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by raghavnarula on 16/11/2015.
 */
public class PositionToShootAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {
        player.dash(30);
        player.turn(FastMath.PI);
    }
}
