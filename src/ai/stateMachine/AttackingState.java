package ai.stateMachine;

import ai.actions.KickAtGoalAction;
import ai.actions.PositionToShootAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import info.SeeBallInfo;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by James on 06/11/2015.
 */
public class AttackingState implements State {

    KickAtGoalAction kickAtGoalAction = new KickAtGoalAction();
    PositionToShootAction positionToShootAction = new PositionToShootAction();

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

//        if(FastMath.abs(angleBetweenBallAndGoal) < FastMath.PI/2){
            kickAtGoalAction.takeAction(context, model);
//        } else {
//            positionToShootAction.takeAction(context, model);
//        }

    }

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
