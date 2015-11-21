package ai.stateMachine;


import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;


/**
 * <p>
 * This is the agent's main behavioural state machine and implements
 * the state design pattern.
 *
 * <p>
 * It contains the states the agent may be in.
 *
 * <p>
 * One state is assigned as the current state. Only the current state's
 * implementation of processModel() is ever called by clients.
 *
 * <p>
 * The state may be changed to a new state by calling changeState with a
 * next state to change to.
 *
 */

public class StateMachine {


    public static final PassiveState PASSIVE_STATE = new PassiveState();
    public static final DefendingState DEFENDING_STATE = new DefendingState();
    public static final AttackingState ATTACKING_STATE = new AttackingState();
    public static final SupportState SUPPORT_STATE = new SupportState();
    private CommandPlayer context;
    private State currentState;

    /**
     * Create a state machine for a particular agent.
     * @param context The agent to which this state machine belongs.
     */
    public StateMachine(CommandPlayer context) {
        this.context = context;
        this.currentState = PASSIVE_STATE;
    }

    /**
     * Change to a new state. Changing state will call exit on the current state,
     * and enter on the target state. Update state will then be called on the new
     * state.
     * @param nextState The state which should become the new currentState.
     * @param model The current model which should be used to validate the new state.
     */
    public void changeState(State nextState, EnvironmentModel model) {
        currentState.exitState(context);
        currentState = nextState;
        currentState.enterState(context);
        currentState.updateState(this, model);
    }

    /**
     * Process the model in the current state.
     * Prior to processing, the current state is validated by updateState.
     * @param model The model to be processed in the current state.
     */
    public void processModel(EnvironmentModel model) {
//        changeState will never be called before processModel -
//        changeState is only ever called by updateState
        this.currentState.updateState(this, model);
        this.currentState.processModel(context, model);
    }

    /**
     * Return the context agent of this state machine.
     * @return The CommpandPlayer attached to the agent.
     */
    public CommandPlayer getContext() {
        return context;
    }
}
