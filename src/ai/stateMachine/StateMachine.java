package ai.stateMachine;


import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 05/11/2015.
 */

public class StateMachine {

    private final PassiveState passiveState = new PassiveState();
    private CommandPlayer context;
    private State currentState;

    public StateMachine(CommandPlayer context) {
        this.context = context;
        this.currentState = passiveState;
    }

    public void changeState(State nextState, EnvironmentModel model) {
        currentState.exitState(context);
        currentState = nextState;
        currentState.enterState(context);
        currentState.updateState(this, model);
    }

    public void processModel(EnvironmentModel model) {
//        changeState will never be called before processModel -
//        changeState is only ever called by updateState
        this.currentState.updateState(this, model);
        this.currentState.processModel(context, model);
    }

    public CommandPlayer getContext() {
        return context;
    }
}
