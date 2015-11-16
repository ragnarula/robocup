package ai.stateMachine;


import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import org.apache.log4j.Logger;


/**
 * Created by raghavnarula on 05/11/2015.
 */

public class StateMachine {


    public static final PassiveState PASSIVE_STATE = new PassiveState();
    public static final DefendingState DEFENDING_STATE = new DefendingState();
    public static final AttackingState ATTACKING_STATE = new AttackingState();
    public static final SupportState SUPPORT_STATE = new SupportState();
    private CommandPlayer context;
    private State currentState;
    private Logger log;

    public StateMachine(CommandPlayer context) {
        this.context = context;
        this.currentState = PASSIVE_STATE;
        log = Logger.getLogger(StateMachine.class.toString());
    }

    public void changeState(State nextState, EnvironmentModel model) {
//        log.debug("Changing State from " + currentState.getClass().toString() + " to " + nextState.getClass().toString());
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
