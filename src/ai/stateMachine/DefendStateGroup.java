package ai.stateMachine;

import ai.model.EnvironmentModel;

/**
 * Created by James on 10/11/2015.
 */
public abstract class DefendStateGroup extends StateGroup {
    @Override
    protected boolean isGroupStateValid(EnvironmentModel model) {
        if(!ballInMovementRange(model))
            return false;

        return false;
    }
}
