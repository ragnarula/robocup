package ai.actions;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Interface for all agent actions.
 *
 * An action holds the necessary logic to achieve a task.
 *
 * Created by raghavnarula on 05/11/2015.
 */
public interface Action {

    /**
     * Make the agent take an action.
     *
     * This decision is based on the current game state.
     *
     * @param player Agent to make take an action.
     * @param model Model containing the current game state.
     */
    void takeAction(CommandPlayer player, EnvironmentModel model);
}
