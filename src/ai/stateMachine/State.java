package ai.stateMachine;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public interface State {

    void enterState(ActionsPlayer context);
    void exitState(ActionsPlayer context);
    void processModel(ActionsPlayer context, EnvironmentModel model);
    void updateState(StateMachine stateMachine, EnvironmentModel model);

}
