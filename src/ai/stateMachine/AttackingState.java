package ai.stateMachine;

import ai.actions.KickAtGoalAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import info.SeeBallInfo;
import org.apache.commons.math3.util.FastMath;

/**
 * In this state the agent is near enough to the ball to kick it.
 *
 * It has one possible actions:
 *      Kick at goal
 *
 * It can lead to:
 *      Passive State
 *      Support State
 *      Defending State
 *
 * Created by James on 06/11/2015.
 */
public class AttackingState implements State {

    KickAtGoalAction kickAtGoalAction = new KickAtGoalAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        SeeBallInfo ball = model.getLastPercept().getLastSeenBall();

        double agentAbsAngle = model.getAgentAbsAngleRadians();

        double ballAngle = FastMath.toRadians(ball.getDirection());
        double totalBallAngle = ballAngle + agentAbsAngle;
        double goalAngle = model.getGoalAngle();

        double angleBetweenBallAndGoal = totalBallAngle - goalAngle;


        kickAtGoalAction.takeAction(context, model);

    }

    /**
     * Go to passive state if the ball is outside of movement range
     * Go to Defending state if the team doesnt have the ball and the agent doesnt have the ball
     * Go to Support state if the agent doesn't have the ball but the team does have the ball
     *
     * @param stateMachine State Machine to update.
     * @param model Model containing the current game state.
     */
    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {

        if(!model.ballInMovementRange() && !model.agentHasBall()){
            stateMachine.changeState(StateMachine.PASSIVE_STATE, model);
            return;
        }

        if(!model.teamHasBall() && !model.agentHasBall()){
            stateMachine.changeState(StateMachine.DEFENDING_STATE, model);
            return;
        }

        if( !model.agentHasBall() && model.teamHasBall() && !model.isPlayerGoalKeeper()) {
            stateMachine.changeState(StateMachine.SUPPORT_STATE, model);
        }
    }
}
