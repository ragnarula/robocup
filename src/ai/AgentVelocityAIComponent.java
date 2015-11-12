package ai;

import ai.model.EnvironmentModel;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Created by raghavnarula on 11/11/2015.
 */
public class AgentVelocityAIComponent extends AbstractSimpleAIComponent {

    private EnvironmentModel prevModel;
    @Override
    EnvironmentModel processModel(EnvironmentModel model) {
        if(prevModel == null){
            model.setAgentVelocityVector(new Vector2D(0,0));
            prevModel = model;
        }
        model.setAgentVelocityVector(model.getAgentLocation().subtract(prevModel.getAgentLocation()));
        prevModel = model;
        return model;
    }
}
