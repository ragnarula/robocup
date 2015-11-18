package ai.actions;

import ai.AbstractSimpleAIComponent;
import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.enums.PlayMode;
import info.Percept;
import org.apache.log4j.Logger;

/**
 * Created by raghavnarula on 18/11/2015.
 */
public class PlayModeAIComponent extends AbstractSimpleAIComponent {

    private PlayMode playMode;


    @Override
    protected EnvironmentModel processModel(EnvironmentModel model) {
        Percept p = model.getLastPercept();
        if(!p.getPlayModeMessages().isEmpty()){
            playMode = p.getPlayModeMessages().get(p.getPlayModeMessages().size() - 1);
        }

        model.setPlayMode(playMode);
        return model;
    }
}
