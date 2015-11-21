package ai.stateMachine;

import ai.actions.LookAtBallAction;
import ai.actions.ReturnHomeAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
/**
 * This is the agent's starting state. This is the state that agents
 * should be in before the game has started, or when the ball is ourside
 * of the agent's movement area.
 *
 * The possible actions in this state are:
 *      look at ball
 *      return to home area
 *
 * This state could lead to:
 *      Attacking State
 *      Supporting State
 *      Defending State
 *
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

    /**
     * If the ball is not within the movement range, got to home area and face
     * the ball's location
     *
     * @param context
     * @param model Model containing the current game state.
     */
    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {

        if(!model.getHomeArea().isNearCenter(model.getAgentLocation(), 1.0))
            returnHomeAction.takeAction(context, model);
        else
            lookAtBallAction.takeAction(context, model);

    }

    /**
     * If the model is within the movement range, update the state before
     * processing the model.
     *
     * @param stateMachine State Machine to update.
     * @param model Model containing the current game state.
     */
    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if (model.agentHasBall())
            stateMachine.changeState(StateMachine.ATTACKING_STATE, model);

        if( model.ballInMovementRange() ) {
            if (model.teamHasBall() && model.agentInMovementArea() && !model.isPlayerGoalKeeper())
                stateMachine.changeState(StateMachine.SUPPORT_STATE, model);
            else
                stateMachine.changeState(StateMachine.DEFENDING_STATE, model);
        }
    }
}
