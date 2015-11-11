package ai.stateMachine;

import ai.actions.TackleAction;
import ai.model.BehaviourConfiguration;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by James on 06/11/2015.
 */
public class TackleState implements State {

    TackleAction tackleAction = new TackleAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        tackleAction.takeAction(context, model);
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if( !ballInTackleRange(model) && !playerAheadOfBall(model) ) {
            stateMachine.changeState(new InterceptState(), model);
        }
    }

    private boolean playerAheadOfBall(EnvironmentModel model) {
//        TODO: Write logic
        return false;
    }

    private boolean ballInTackleRange(EnvironmentModel model) {
        return BehaviourConfiguration.TACKLE_RANGE > model.getLastPercept().getLastSeenBalls().getDistance();
    }
}
