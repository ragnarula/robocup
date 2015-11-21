package ai;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import ai.stateMachine.StateMachine;

/**
 * <p>
 * This is the mode important component and should be the final component in the chain.
 * </p>
 * <p>
 * This component contains the agent's State Machine which maps model =&gt; action depending
 * on the current state of the model.
 * </p>
 * <p>
 * The model should contain all the information required by the individual states to map
 * model =&gt; action. This is done by passing the model through all the other components
 * prior to this one.
 * </p>
 * Created by raghavnarula on 03/11/2015.
 */
public class AgentActionAIComponent extends AbstractSimpleAIComponent{

    private CommandPlayer player;
    private StateMachine stateMachine;

    public AgentActionAIComponent(CommandPlayer player){
        this.player = player;
        stateMachine = new StateMachine(this.player);
    }

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        stateMachine.processModel(model);
        return null;
    }
}
