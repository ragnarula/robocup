package ai.stateMachine;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/**
 * This state is used when the agent doesnt have the ball but a team member does.
 * It's only action causes the agent to move towards the goal.
 *
 * It can lead to:
 *      Passive State
 *      Attacking State
 *      Defending State
 *
 * Created by raghavnarula on 16/11/2015.
 */
public class SupportState implements State {
    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    /**
     * Dash towards go goal, unless the agent is more than 5m ahead of the ball
     *
     * @param context
     * @param model Model containing the current game state.
     */
    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        Vector2D agentLocation = model.getAgentLocation();
        Vector2D ballLocation = model.getBallLocation();

        if(ballLocation.getY() + 5 < agentLocation.getY()){
            double agentAngle = model.getAgentAbsAngleRadians();

            if(agentAngle > FastMath.PI){
                context.turn((FastMath.PI*2) - agentAngle);
            } else {
                context.turn(-agentAngle);
            }

            if(model.agentInMovementArea()){
                context.dash(50);
            }
        }

    }

    /**
     * Go to Passive State if the ball is outside of the agent's movement range
     * Go to Attacking state if the agent gets the ball
     * Go to Defending state if the team doesnt have the ball.
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
        if(model.agentHasBall()){
            stateMachine.changeState(StateMachine.ATTACKING_STATE, model);
            return;
        }
        if(!model.teamHasBall()){
            stateMachine.changeState(StateMachine.DEFENDING_STATE,model);
            return;
        }

    }
}
