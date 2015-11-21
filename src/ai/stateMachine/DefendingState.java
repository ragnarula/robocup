package ai.stateMachine;

import ai.actions.MoveToBallAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * This is the state an agent should be in whenever the ball is within
 * the agent's movement range and neither the team nor the agent
 * has possession of the ball.
 *
 * This state has only one possible action:
 *      Move To The ball.
 *
 * This state can lead to:
 *      Passive State
 *      Support State
 *      Attacking State
 *
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

    /**
     * Go to passive state if the ball moves outside of movement area
     * Go to support state if another team mate gets the ball
     * Go to Attack state if this agent wins possession of the ball
     *
     * @param stateMachine State Machine to update.
     * @param model Model containing the current game state.
     */
    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if(!model.ballInMovementRange()){
            stateMachine.changeState(StateMachine.PASSIVE_STATE, model);
            return;
        }

        if(model.teamHasBall()){
            stateMachine.changeState(StateMachine.SUPPORT_STATE, model);
            return;
        }

        if(model.agentHasBall()){
            stateMachine.changeState(StateMachine.ATTACKING_STATE, model);
            return;
        }

    }
}
