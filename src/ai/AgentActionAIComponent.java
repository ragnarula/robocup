package ai;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public class AgentActionAIComponent extends AbstractSimpleAIComponent{

    private ActionsPlayer player;

    public AgentActionAIComponent(ActionsPlayer player){
        this.player = player;
    }
    @Override
    void processModel(EnvironmentModel model) {
        //todo generate an action from the model that arrives. This should be the last component in the chain so no
        //need to send to the next one.
        if(hasPlayer()){
            player.dash(100);
        }
    }

    private boolean hasPlayer() {
        return player != null;
    }
}
