package ai.stateMachine;

import ai.actions.FindBallAction;
import ai.actions.ReturnHomeAction;
import ai.model.BehaviourConfiguration;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.HashMap;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public class PassiveState implements State {

    private ReturnHomeAction returnHomeAction = new ReturnHomeAction();
    private FindBallAction findBallAction = new FindBallAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
//        if( cantSeeBall(model) )
//            findBallAction.takeAction(context, model);

        if(!model.getHomeArea().isNearCenter(model.getAgentLocation(), 1.0))
            returnHomeAction.takeAction(context, model);
    }

    private boolean cantSeeBall(EnvironmentModel model) {
        return model.getBallLocation() == null;
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if( ballInMovementRange(model) ) {
            if ( !teamHasBall(model) && !agentHasBall(model) )
                stateMachine.changeState(new DefendingState(), model);

            if ( agentHasBall(model) )
                stateMachine.changeState(new AttackingState(), model);
        }
    }

    private boolean agentHasBall(EnvironmentModel model) {
//        Vector2D ballPosition = model.getBallLocation();
//        Vector2D agentPosition = model.getAgentLocation();
//        return ballPosition.distance(agentPosition) < BehaviourConfiguration.BALL_POSSESSION_RANGE;
          return model.getLastPercept().getLastSeenBalls().getDistance() < BehaviourConfiguration.BALL_POSSESSION_RANGE;
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

    private boolean ballInMovementRange(EnvironmentModel model) {
        if(model.getBallLocation() != null) {
            return model.getMovementArea().contains(model.getBallLocation());
        }
        return false;
    }
}
