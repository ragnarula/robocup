package ai.stateMachine;

import ai.actions.MoveBallAction;
import ai.actions.PassBallAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by James on 06/11/2015.
 */
public class DribblingState extends AttackStateGroup implements State {

    MoveBallAction moveBallAction = new MoveBallAction();
    PassBallAction passBallAction = new PassBallAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        // TODO: Write decision tree
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if(!isGroupStateValid(model))
            stateMachine.changeState(new PassiveState(), model);

        if( !hasBall(model) ) {
            stateMachine.changeState(new SupportingState(), model);
        }
    }

    private boolean hasBall(EnvironmentModel model) {
//        TODO: Write logic
        return false;
    }
}
