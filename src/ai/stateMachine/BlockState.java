package ai.stateMachine;

import ai.actions.BlockPlayersAction;
import ai.model.BehaviourConfiguration;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by James on 06/11/2015.
 */
public class BlockState extends DefendStateGroup implements State {

    BlockPlayersAction blockPlayersAction = new BlockPlayersAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        blockPlayersAction.takeAction(context, model);
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if(!isGroupStateValid(model))
            stateMachine.changeState(new PassiveState(), model);

        if( !ballInMovementRange(model) ) {
            stateMachine.changeState(new PassiveState(), model);
        }
        else if( ballInInterceptRange(model) ) {
            stateMachine.changeState(new InterceptState(), model);
        }
    }

    private boolean ballInInterceptRange(EnvironmentModel model) {
        double ballDistFromHomeArea = model.getBallLocation().distance(model.getHomeArea().getMidpoint());
        return ballDistFromHomeArea < BehaviourConfiguration.INTERCEPT_RANGE;
    }
}
