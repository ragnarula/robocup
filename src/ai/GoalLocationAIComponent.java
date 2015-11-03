package ai;

import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public class GoalLocationAIComponent extends AbstractSimpleAIComponent{
    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        //todo - calculate best approximation of the relative location of the goal and add to model.
        return model;
    }
}
