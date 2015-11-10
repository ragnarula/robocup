package ai.stateMachine;

import ai.actions.SupportAction;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by James on 06/11/2015.
 */
public class SupportingState extends AttackStateGroup implements State {

    SupportAction supportAction = new SupportAction();

    @Override
    public void enterState(ActionsPlayer context) {

    }

    @Override
    public void exitState(ActionsPlayer context) {

    }

    @Override
    public void processModel(ActionsPlayer context, EnvironmentModel model) {
        supportAction.takeAction(context, model);
    }

    @Override
    public void updateState(StateMachine stateMachine, EnvironmentModel model) {
//        if(!isGroupStateValid(model))
//            stateMachine.changeState(new PassiveState(), model);

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

    private boolean rangeOfMovementExtendsToGoal(EnvironmentModel model) {
//        TODO: Write logic
        return false;
    }

    private boolean hasBall(EnvironmentModel model) {
//        TODO: Write logic
        return false;
    }
}
