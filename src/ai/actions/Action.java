package ai.actions;

import ai.model.EnvironmentModel;
import com.github.robocup_atan.atan.model.ActionsPlayer;

/**
 * Created by raghavnarula on 05/11/2015.
 */
public interface Action {
    void takeAction(ActionsPlayer player, EnvironmentModel model);
}
