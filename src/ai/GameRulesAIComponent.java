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

    private enum GameState {
        RUNNING,
        STOPPED
    }

    private CommandPlayer player;
    private LookAtBallAction lookAtBallAction = new LookAtBallAction();
    private Logger log = Logger.getLogger(GameRulesAIComponent.class);

    private GameState gameState = GameState.STOPPED;

    public GameRulesAIComponent(CommandPlayer player) {
        this.player = player;
    }

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        switch (gameState){
            case RUNNING:
                if(model.getPlayMode() == PlayMode.GOAL_OWN){
                    lookAtBallAction.takeAction(player,model);
                    gameState = GameState.STOPPED;
                    return null;
                }
                if(model.getPlayMode().toString().endsWith("OTHER")){
                    lookAtBallAction.takeAction(player,model);
                    gameState = GameState.STOPPED;
                    return null;
                }
                if(model.getPlayMode() == PlayMode.BEFORE_KICK_OFF){
                    lookAtBallAction.takeAction(player,model);
                    gameState = GameState.STOPPED;
                    return null;
                }
            case STOPPED:
                if(model.getPlayMode() == PlayMode.BEFORE_KICK_OFF){
                    lookAtBallAction.takeAction(player,model);
                    return null;
                }

                if(model.getPlayMode() == PlayMode.KICK_OFF_OWN) {
                    gameState = GameState.RUNNING;
                    return model;
                }

                if(model.getPlayMode().toString().endsWith("OWN")){
//                    lookAtBallAction.takeAction(player, model);
                    gameState = GameState.RUNNING;
                    return model;
                }
                if(model.getPlayMode().toString().endsWith("OTHER")){
                    lookAtBallAction.takeAction(player,model);
                    return null;
                }
                if(model.getPlayMode() == PlayMode.PLAY_ON){
                    gameState = GameState.RUNNING;
                    return model;
                }
        }
        return model;
    }
}
