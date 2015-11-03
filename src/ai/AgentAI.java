package ai;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by raghavnarula on 02/11/2015.
 */
public class AgentAI extends AbstractAsyncAIComponent {

    private ActionsPlayer player;
    private AgentLocationAIComponent agentLocation;
    private GoalLocationAIComponent goalLocation;
    private AgentActionAIComponent agentAction;

    public AgentAI(ActionsPlayer player) {
        this.player = player;
        //initialize components
        agentLocation = new AgentLocationAIComponent();
        goalLocation = new GoalLocationAIComponent();
        agentAction = new AgentActionAIComponent(this.player);

        //attach components together in correct order
        this.setNext(agentLocation);
        agentLocation.setNext(goalLocation);
        goalLocation.setNext(agentAction);
    }

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        //feed model into first component
        return model;
    }
}
