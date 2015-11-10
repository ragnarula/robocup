package ai.stateMachine;

import ai.model.EnvironmentModel;

/**
 * Created by James on 10/11/2015.
 */
public abstract class StateGroup {

    protected abstract boolean isGroupStateValid(EnvironmentModel model);

    protected boolean ballInMovementRange(EnvironmentModel model) {
        if(model.getBallLocation() != null) {
            return model.getMovementArea().contains(model.getBallLocation());
        }
        return false;
    }

}
