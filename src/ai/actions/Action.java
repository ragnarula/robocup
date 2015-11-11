package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public interface Action {
    void takeAction(CommandPlayer player, EnvironmentModel model);
}
