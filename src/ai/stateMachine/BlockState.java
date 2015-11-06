package ai.stateMachine;

import ai.actions.BlockPlayersAction;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by James on 06/11/2015.
 */
public class BlockState implements State {

    BlockPlayersAction blockPlayersAction = new BlockPlayersAction();

    @Override
    public void enterState(ActionsPlayer context) {

    }

    @Override
    public void exitState(ActionsPlayer context) {

    }

    @Override
    public void processModel(ActionsPlayer context, EnvironmentModel model) {
        blockPlayersAction.takeAction(context, model);
    }
}
