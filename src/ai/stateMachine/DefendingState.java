package ai.stateMachine;

import ai.actions.DefendAction;
import ai.model.BehaviourConfiguration;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.HashMap;

/**
 * Created by James on 12/11/2015.
 */
public class DefendingState implements State {

    DefendAction defendAction = new DefendAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        defendAction.takeAction(context, model);
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if(!model.ballInMovementRange()){
            stateMachine.changeState(StateMachine.PASSIVE_STATE, model);
            return;
        }


        if(model.teamHasBall()){
            stateMachine.changeState(StateMachine.PASSIVE_STATE, model);
            return;
        }


        if(model.agentHasBall() && model.agentBehindBall()){
            stateMachine.changeState(StateMachine.ATTACKING_STATE, model);
            return;
        }

    }
}
