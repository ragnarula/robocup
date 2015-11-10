package ai.stateMachine;

import ai.actions.InterceptAction;
import ai.model.BehaviourConfiguration;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by James on 06/11/2015.
 */
public class InterceptState extends DefendStateGroup implements State {

    InterceptAction interceptAction = new InterceptAction();

    @Override
    public void enterState(ActionsPlayer context) {

    }

    @Override
    public void exitState(ActionsPlayer context) {

    }

    @Override
    public void processModel(ActionsPlayer context, EnvironmentModel model) {
        interceptAction.takeAction(context, model);
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if(!isGroupStateValid(model))
            stateMachine.changeState(new PassiveState(), model);

        if( !ballInInterceptRange(model) ) {
            stateMachine.changeState(new BlockState(), model);
        }
        else if( ballInTackleRange(model) ) {
            stateMachine.changeState(new TackleState(), model);
        }
    }

    private boolean ballInTackleRange(EnvironmentModel model) {
        double ballDistFromHomeArea = model.getBallLocation().distance(model.getHomeArea().getMidpoint());
        return ballDistFromHomeArea < BehaviourConfiguration.TACKLE_RANGE;
    }

    private boolean ballInInterceptRange(EnvironmentModel model) {
        double ballDistFromHomeArea = model.getBallLocation().distance(model.getHomeArea().getMidpoint());
        return ballDistFromHomeArea < BehaviourConfiguration.INTERCEPT_RANGE;
    }
}
