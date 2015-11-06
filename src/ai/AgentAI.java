package ai;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by raghavnarula on 02/11/2015.
 */
public class AgentAI extends AbstractAsyncAIComponent {

    private ActionsPlayer player;
    private AgentLocationAIComponent agentLocation;
    private AgentActionAIComponent agentAction;
    private HomeAreaAIComponent homeAreaAgent;
    private AgentAngleAIComponent agentAngle;

    public AgentAI(ActionsPlayer player) {
        this.player = player;
        //initialize components
        agentAngle = new AgentAngleAIComponent();
        agentLocation = new AgentLocationAIComponent();
        homeAreaAgent = new HomeAreaAIComponent();
        agentAction = new AgentActionAIComponent(this.player);

        //attach components together in correct order
        this.setNext(agentAngle);
        agentAngle.setNext(agentLocation);
        agentLocation.setNext(homeAreaAgent);
        homeAreaAgent.setNext(agentAction);
    }

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        //feed model into first component
        return model;
    }
}
