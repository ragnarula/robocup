package ai.stateMachine;

import ai.actions.FindBallAction;
import ai.actions.ReturnHomeAction;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

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

        if(!model.getHomeArea().isNearCenter(model.getAgentLocation(), 1.0)){
            returnHomeAction.takeAction(context, model);
            return;
        }


        if( cantSeeBall(model) )
            findBallAction.takeAction(context, model);

        // ball was in model
        // if ball in movement range
    }

    private boolean cantSeeBall(EnvironmentModel model) {
//        TODO: Implement logic
        // if ball not in model
        return false;
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {

        //  TODO: Account for team behavioural state
        //  TODO: Change to tackle/block state

        if(ballInMovementRange(model))
            stateMachine.changeState(new SupportingState(), model);
    }

    private boolean ballInMovementRange(EnvironmentModel model) {
//        TODO: Write logic
        // get constant for movement range
        // check less than distance to ball in model
        // return true false
        // if cant see ball return false
        return false;
    }
}
