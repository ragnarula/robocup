package ai.stateMachine;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Interface for all agent behavioural states.
 *
 * Agent behavioural states dictate the actions available to a
 * agent, and it's decision making process as to what action is taken.
 *
 * Created by raghavnarula on 05/11/2015.
 */
public interface State {

    /**
     * Called when a state is entered.
     *
     * @param context
     */
    void enterState(CommandPlayer context);

    /**
     * Called when a state is exited.
     *
     * @param context
     */
    void exitState(CommandPlayer context);

    /**
     * Using the current game state, decide what action to take.
     *
     * @param context
     * @param model Model containing the current game state.
     */
    void processModel(CommandPlayer context, EnvironmentModel model);

    /**
     * Decide if the players behavioural state should change, and if it
     * should, change it.
     *
     * This decision is based on the current game state.
     *
     * @param stateMachine State Machine to update.
     * @param model Model containing the current game state.
     */
    void updateState(StateMachine stateMachine, EnvironmentModel model);

}
