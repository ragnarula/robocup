package ai.stateMachine;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.FastMath;

/**
 * Created by raghavnarula on 16/11/2015.
 */
public class SupportState implements State {
    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        double agentAngle = model.getAgentAbsAngleRadians();

        Vector2D agentLocation = model.getAgentLocation();
        Vector2D ballLocation = model.getBallLocation();

        if(agentAngle > FastMath.PI){
            context.turn((FastMath.PI*2) - agentAngle);
        } else {
            context.turn(-agentAngle);
        }

        if(model.agentInMovementArea() && agentLocation.getY() < ballLocation.getY() ){
            context.dash(50);
        }


    }

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
