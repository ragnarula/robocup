package ai;

import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public class AgentLocationAIComponent extends AbstractSimpleAIComponent{

    @Override
    void processModel(EnvironmentModel model) {
        //todo - calculate agent location and add to model, then give model to next component in chain
        if(hasNext()){
            getNext().put(model);
        }
    }
}
