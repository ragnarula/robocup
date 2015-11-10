package ai.stateMachine;

import ai.actions.BlockPlayersAction;
import ai.model.BehaviourConfiguration;
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

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if( !ballInMovementRange(model) ) {
            stateMachine.changeState(new PassiveState(), model);
        }
        else if( ballInInterceptRange(model) ) {
            stateMachine.changeState(new InterceptState(), model);
        }
    }

    private boolean ballInInterceptRange(EnvironmentModel model) {
        return BehaviourConfiguration.INTERCEPT_RANGE > model.getLastPercept().getLastSeenBalls().getDistance();
    }

    private boolean ballInMovementRange(EnvironmentModel model) {
//        TODO: Write logic
        return false;
    }
}
