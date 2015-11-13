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
public class DefendingState extends DefendStateGroup implements State {

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
        if(!ballInMovementRange(model))
            stateMachine.changeState(new PassiveState(), model);

        if(teamHasBall(model))
            stateMachine.changeState(new PassiveState(), model);

        if(agentHasBall(model) && agentBehindBall(model))
            stateMachine.changeState(new PassiveState(), model);
    }

    private boolean isValidDefendState(EnvironmentModel model) {
        return ballInMovementRange(model) && !teamHasBall(model) && ( !agentHasBall(model) && !agentBehindBall(model) ) ;
    }

    private boolean agentBehindBall(EnvironmentModel model) {
        if(model.getBallLocation() == null)
            return false;

        Vector2D ballLocation = model.getBallLocation();
        Vector2D agentLocation = model.getAgentLocation();

        return ballLocation.getY() > agentLocation.getY();
    }

    private boolean agentHasBall(EnvironmentModel model) {
        if(model.getBallLocation() == null)
            return false;

        return model.getLastPercept().getLastSeenBalls().getDistance() < BehaviourConfiguration.BALL_POSSESSION_RANGE;
    }

    private boolean teamHasBall(EnvironmentModel model) {
        if(model.getBallLocation() == null)
            return false;

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
