package ai.stateMachine;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public interface State {

    void enterState(CommandPlayer context);
    void exitState(CommandPlayer context);
    void processModel(CommandPlayer context, EnvironmentModel model);
    void updateState(StateMachine stateMachine, EnvironmentModel model);

}
