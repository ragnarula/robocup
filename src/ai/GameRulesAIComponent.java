package ai;

import ai.actions.LookAtBallAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.enums.PlayMode;
import org.apache.log4j.Logger;

/**
 * Created by raghavnarula on 16/11/2015.
 */
public class GameRulesAIComponent extends AbstractSimpleAIComponent {

    private CommandPlayer player;
    private LookAtBallAction lookAtBallAction = new LookAtBallAction();
    private Logger log = Logger.getLogger(GameRulesAIComponent.class);

    public GameRulesAIComponent(CommandPlayer player) {
        this.player = player;
    }

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        if(model.getPlayMode() == PlayMode.BEFORE_KICK_OFF){
            lookAtBallAction.takeAction(player,model);
            log.debug("Staying put, looking at ball");

            return null;
        }
        return model;
    }
}
