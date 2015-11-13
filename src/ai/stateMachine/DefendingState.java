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
        if( !ballInMovementRange(model) || teamHasBall(model) )
            stateMachine.changeState(new PassiveState(), model);
    }

    private boolean teamHasBall(EnvironmentModel model) {
        HashMap<Integer, Vector2D> opposingPlayerLocations = model.getOpposingPlayerLocations();
        Vector2D ballPosition = model.getBallLocation();

//        Hashmaps are literally Hitler
        for (Integer key : opposingPlayerLocations.keySet() ) {
            if( ballPosition.distance(opposingPlayerLocations.get(key)) < BehaviourConfiguration.BALL_POSSESSION_RANGE )
                return false;
        }

        return true;
    }
}
