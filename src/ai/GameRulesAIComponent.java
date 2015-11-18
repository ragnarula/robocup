package ai;

import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 16/11/2015.
 */
public class GameRulesAIComponent extends AbstractSimpleAIComponent {

    private CommandPlayer player;

    public GameRulesAIComponent(CommandPlayer player) {
        this.player = player;
    }

    @Override
    EnvironmentModel processModel(EnvironmentModel model) {

//        PlayMode currentPlayMode = model.getLastPercept().getLastPlayMode();
        return model;

//        Game inactive - no action needed
//        if( currentPlayMode == PlayMode.GOAL_L || currentPlayMode == PlayMode.GOAL_R )
//            return null;

    }
}
