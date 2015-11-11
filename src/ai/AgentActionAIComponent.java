package ai;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import ai.stateMachine.StateMachine;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
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
    EnvironmentModel processModel(EnvironmentModel model) {
        stateMachine.processModel(model);
        return null;
    }

    private boolean hasPlayer() {
        return player != null;
    }
}
