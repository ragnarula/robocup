package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by James on 06/11/2015.
 */
public class MoveBallAction implements Action {
    @Override
    public void takeAction(CommandPlayer player, EnvironmentModel model) {
        player.kick(50, 0);
    }
}
