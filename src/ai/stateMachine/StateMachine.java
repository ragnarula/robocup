package ai.stateMachine;


import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by raghavnarula on 05/11/2015.
 */

public class StateMachine {

    private final PassiveState passiveState = new PassiveState();
    private ActionsPlayer context;
    private State currentState;

    public StateMachine(ActionsPlayer context) {
        this.context = context;
        this.currentState = passiveState;
    }

    public void changeState(State nextState) {
        currentState.exitState(context);
        currentState = nextState;
        currentState.enterState(context);
    }

    public void processModel(EnvironmentModel model) {
        this.currentState.processModel(context, model);
    }

    public ActionsPlayer getContext() {
        return context;
    }
}
