package ai.stateMachine;

import ai.actions.KickAtGoalAction;
import ai.actions.MoveBallAction;
import ai.actions.PassBallAction;
import ai.model.BehaviourConfiguration;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.HashMap;

/**
 * Created by James on 06/11/2015.
 */
public class AttackingState implements State {

    MoveBallAction moveBallAction = new MoveBallAction();
    PassBallAction passBallAction = new PassBallAction();
    KickAtGoalAction kickAtGoalAction = new KickAtGoalAction();

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
        if( !teamHasBall(model) || !agentHasBall(model) ) {
            stateMachine.changeState(new SupportingState(), model);
        }
    }

    private boolean agentHasBall(EnvironmentModel model) {
        Vector2D ballPosition = model.getBallLocation();
        Vector2D agentPosition = model.getAgentLocation();
        return ballPosition.distance(agentPosition) < BehaviourConfiguration.BALL_POSSESSION_RANGE;
    }

    private boolean teamHasBall(EnvironmentModel model) {
        HashMap<Integer, Vector2D> friendlyPlayerLocations = model.getFriendlyPlayerLocations();
        Vector2D ballPosition = model.getBallLocation();

//        Hashmaps are literally Hitler
        for (Integer key : friendlyPlayerLocations.keySet() ) {
            if( ballPosition.distance(friendlyPlayerLocations.get(key)) < BehaviourConfiguration.BALL_POSSESSION_RANGE )
                return true;
        }

        return false;
    }
}
