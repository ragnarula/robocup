package ai.stateMachine;

import ai.actions.MoveBallAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by James on 06/11/2015.
 */
public class AttackingState implements State {

    MoveBallAction moveBallAction = new MoveBallAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        moveBallAction.takeAction(context, model);
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
//        if(model.teamHasBall()){
//            stateMachine.changeState(StateMachine.SUPPORTING_STATE);
//        }
        if( !model.agentHasBall() ) {
            stateMachine.changeState(StateMachine.PASSIVE_STATE, model);
        }
    }
}
