package ai.stateMachine;

import ai.actions.InterceptAction;
import ai.model.BehaviourConfiguration;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by James on 06/11/2015.
 */
public class InterceptState implements State {

    InterceptAction interceptAction = new InterceptAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        interceptAction.takeAction(context, model);
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if( !ballInInterceptRange(model) ) {
            stateMachine.changeState(new BlockState(), model);
        }
        else if( ballInTackleRange(model) ) {
            stateMachine.changeState(new TackleState(), model);
        }
    }

    private boolean ballInTackleRange(EnvironmentModel model) {
        return BehaviourConfiguration.TACKLE_RANGE > model.getLastPercept().getLastSeenBalls().getDistance();
    }

    private boolean ballInInterceptRange(EnvironmentModel model) {
        return BehaviourConfiguration.INTERCEPT_RANGE > model.getLastPercept().getLastSeenBalls().getDistance();
    }
}
