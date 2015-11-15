package ai.stateMachine;


import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 05/11/2015.
 */

public class StateMachine {

    public static final PassiveState PASSIVE_STATE = new PassiveState();
    public static final DefendingState DEFENDING_STATE = new DefendingState();
    public static final AttackingState ATTACKING_STATE = new AttackingState();
    private CommandPlayer context;
    private State currentState;

    public StateMachine(CommandPlayer context) {
        this.context = context;
        this.currentState = PASSIVE_STATE;
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
