package ai.stateMachine;

import ai.actions.LookAtBallAction;
import ai.actions.ReturnHomeAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
/**
 * Created by raghavnarula on 05/11/2015.
 */
public class PassiveState implements State {

    private ReturnHomeAction returnHomeAction = new ReturnHomeAction();
    private LookAtBallAction lookAtBallAction = new LookAtBallAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {

        if(!model.getHomeArea().isNearCenter(model.getAgentLocation(), 1.0))
            returnHomeAction.takeAction(context, model);
        else
            lookAtBallAction.takeAction(context, model);

    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if( model.ballInMovementRange() ) {
            if (model.agentHasBall())
                stateMachine.changeState(StateMachine.ATTACKING_STATE, model);
            else if (model.teamHasBall() && model.agentInMovementArea())
                stateMachine.changeState(StateMachine.SUPPORT_STATE, model);
            else
                stateMachine.changeState(StateMachine.DEFENDING_STATE, model);
        }
    }
}
