package ai;

import ai.actions.LookAtBallAction;
import ai.model.CommandPlayer;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.enums.PlayMode;
import org.apache.log4j.Logger;

/**
 * This Component tracks the state of play of the game.
 * If the game is stopped (before kick off, or if the other team
 * has to kick the ball first), the agent is made to look at the ball,
 * and null is returned by processModel, breaking the component chain
 * until the next simulation step. This prevents the agent from wasting
 * stamina when they are not able to move.
 *
 * Created by raghavnarula on 16/11/2015.
 */
public class GameState extends AbstractSimpleAIComponent {

    private enum State {
        RUNNING,
        STOPPED
    }

    private CommandPlayer player;
    private LookAtBallAction lookAtBallAction = new LookAtBallAction();
    private Logger log = Logger.getLogger(GameState.class);

    private State state = State.STOPPED;

    public GameState(CommandPlayer player) {
        this.player = player;
    }

    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        switch (state){
            case RUNNING:
                if(model.getPlayMode() == PlayMode.GOAL_OWN){
                    lookAtBallAction.takeAction(player,model);
                    state = State.STOPPED;
                    return null;
                }
                if(model.getPlayMode().toString().endsWith("OTHER")){
                    lookAtBallAction.takeAction(player,model);
                    state = State.STOPPED;
                    return null;
                }
                if(model.getPlayMode() == PlayMode.BEFORE_KICK_OFF){
                    lookAtBallAction.takeAction(player,model);
                    state = State.STOPPED;
                    return null;
                }
            case STOPPED:
                if(model.getPlayMode() == PlayMode.BEFORE_KICK_OFF){
                    lookAtBallAction.takeAction(player,model);
                    return null;
                }

                if(model.getPlayMode() == PlayMode.KICK_OFF_OWN) {
                    state = State.RUNNING;
                    return model;
                }

                if(model.getPlayMode().toString().endsWith("OWN")){
                    lookAtBallAction.takeAction(player, model);
                    state = State.RUNNING;
                    return model;
                }
                if(model.getPlayMode().toString().endsWith("OTHER")){
                    lookAtBallAction.takeAction(player,model);
                    return null;
                }
                if(model.getPlayMode() == PlayMode.PLAY_ON){
                    state = State.RUNNING;
                    return model;
                }
        }
        return model;
    }
}
