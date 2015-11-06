package ai.stateMachine;

import ai.actions.ReturnHomeAction;
import ai.model.EnvironmentModel;
import ai.model.HomeArea;
import com.github.robocup_atan.atan.model.ActionsPlayer;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public class PassiveState implements State {

    private ReturnHomeAction returnHomeAction = new ReturnHomeAction();

    @Override
    public void enterState(ActionsPlayer context) {

    }

    @Override
    public void exitState(ActionsPlayer context) {

    }

    @Override
    public void processModel(ActionsPlayer context, EnvironmentModel model) {
        if (!model.hasAgentLocation()){
            return;
        }

        if(!model.getHomeArea().contains(model.getAgentLocation()))
            returnHomeAction.takeAction(context, model);

//        if( cantSeeBall(model) )
//            findBallAction.takeAction(context, model);
    }
}
