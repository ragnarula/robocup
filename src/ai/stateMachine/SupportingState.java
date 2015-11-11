package ai.stateMachine;

import ai.actions.SupportAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by James on 06/11/2015.
 */
public class SupportingState implements State {

    SupportAction supportAction = new SupportAction();

    @Override
    public void enterState(CommandPlayer context) {

    }

    @Override
    public void exitState(CommandPlayer context) {

    }

    @Override
    public void processModel(CommandPlayer context, EnvironmentModel model) {
        supportAction.takeAction(context, model);
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
        if( hasBall(model) ) {
            if( rangeOfMovementExtendsToGoal(model) )
                stateMachine.changeState(new AttackingState(), model);
            else
                stateMachine.changeState(new DribblingState(), model);
        }
        else if( !ballInMovementRange(model) ) {
            stateMachine.changeState(new PassiveState(), model);
        }
    }

    private boolean ballInMovementRange(EnvironmentModel model) {
//        TODO: Write logic
        return false;
    }

    private boolean rangeOfMovementExtendsToGoal(EnvironmentModel model) {
//        TODO: Write logic
        return false;
    }

    private boolean hasBall(EnvironmentModel model) {
//        TODO: Write logic
        return false;
    }
}
