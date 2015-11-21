package ai;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.enums.PlayMode;
import info.Percept;
import org.apache.log4j.Logger;

/**
 * This component adds the current play mode to the model.
 * If the last percept does not contain a play mode message
 * the previous play mode is assumed.
 *
 * Created by raghavnarula on 18/11/2015.
 */
public class PlayModeAIComponent extends AbstractSimpleAIComponent {

    private PlayMode playMode;
    private Logger log = Logger.getLogger(PlayModeAIComponent.class);


    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        Percept p = model.getLastPercept();
        if(!p.getPlayModeMessages().isEmpty()){
            playMode = p.getPlayModeMessages().get(p.getPlayModeMessages().size() - 1);
            log.info("Playmode " + playMode);
        }

        model.setPlayMode(playMode);
        return model;
    }
}
