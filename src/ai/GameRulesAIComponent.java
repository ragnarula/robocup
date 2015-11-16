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
        //if rules are ok
        return model;
        //if rules are not ok do some damage limitation and...
        //return null;
    }
}
