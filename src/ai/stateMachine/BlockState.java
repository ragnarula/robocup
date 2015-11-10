package ai.stateMachine;

import ai.actions.BlockPlayersAction;
import ai.model.BehaviourConfiguration;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by James on 06/11/2015.
 */
public class BlockState extends DefendStateGroup implements State {

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
