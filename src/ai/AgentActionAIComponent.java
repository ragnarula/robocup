package ai;

import agent.Player;
import ai.model.EnvironmentModel;
import ai.stateMachine.StateMachine;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public class AgentActionAIComponent extends AbstractSimpleAIComponent{

    private ActionsPlayer player;
    private StateMachine stateMachine;

    public AgentActionAIComponent(ActionsPlayer player){
        this.player = player;
        stateMachine = new StateMachine(this.player);
    }

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        stateMachine.processModel(model);
        return null;
    }

    private boolean hasPlayer() {
        return player != null;
    }
}
