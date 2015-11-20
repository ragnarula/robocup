package ai.stateMachine;

import ai.actions.MoveToBallAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by James on 12/11/2015.
 */
public class DefendingState implements State {

    MoveToBallAction moveToBallAction = new MoveToBallAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        moveToBallAction.takeAction(context, model);
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if(!model.ballInMovementRange()){
            stateMachine.changeState(StateMachine.PASSIVE_STATE, model);
            return;
        }

        if(model.teamHasBall() && !model.isPlayerGoalKeeper()){
            stateMachine.changeState(StateMachine.SUPPORT_STATE, model);
            return;
        }

        if(model.agentHasBall()){
            stateMachine.changeState(StateMachine.ATTACKING_STATE, model);
            return;
        }

    }
}
