package ai.stateMachine;

import ai.actions.FindBallAction;
import ai.actions.ReturnHomeAction;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.util.Pair;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public class PassiveState implements State {

    private ReturnHomeAction returnHomeAction = new ReturnHomeAction();
    private FindBallAction findBallAction = new FindBallAction();

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
        if( !isInHomeArea(model) )
            returnHomeAction.takeAction(context, model);

//        if( cantSeeBall(model) )
//            findBallAction.takeAction(context, model);
    }

    private boolean isInHomeArea(EnvironmentModel model) {
         Pair<Vector2D, Vector2D> homeArea =  model.getHomeArea();

         Vector2D playerLoaction = model.getAgentLocation();

        return playerLoaction.getX() <= homeArea.getSecond().getX() &&
                playerLoaction.getX() >= homeArea.getFirst().getX() &&
                playerLoaction.getY() >= homeArea.getSecond().getY() &&
                playerLoaction.getY() <= homeArea.getFirst().getY();
    }
}
