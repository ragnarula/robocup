package ai;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by raghavnarula on 02/11/2015.
 */
public class AgentAI extends AbstractAsyncAIComponent {

    private CommandPlayer player;
    private AgentLocationAIComponent agentLocation;
    private AgentActionAIComponent agentAction;
    private HomeAreaAIComponent agentHome;
    private AgentAngleAIComponent agentAngle;
    private AgentVelocityAIComponent agentVelocity;

    public AgentAI(CommandPlayer player) {
        this.player = player;
        //initialize components
        agentVelocity = new AgentVelocityAIComponent();
        agentAngle = new AgentAngleAIComponent();
        agentLocation = new AgentLocationAIComponent();
        agentHome = new HomeAreaAIComponent();
        agentAction = new AgentActionAIComponent(this.player);

        //attach components together in correct order
        this.setNext(agentAngle);
        agentAngle.setNext(agentLocation);
        agentLocation.setNext(agentVelocity);
        agentVelocity.setNext(agentHome);
        agentHome.setNext(agentAction);
    }

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        //feed model into first component
        return model;
    }
}
