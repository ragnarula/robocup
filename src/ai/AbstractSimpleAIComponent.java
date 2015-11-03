package ai;

import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public abstract class AbstractSimpleAIComponent implements IChainable{

    private IChainable next;

    public AbstractSimpleAIComponent(){}

    public AbstractSimpleAIComponent(IChainable next){
        this.next = next;
    }

    @Override
    public void put(EnvironmentModel model) {
        EnvironmentModel nextModel = processModel(model);
        if(shouldContinue(nextModel)){
            getNext().put(nextModel);
        }
    }

    private boolean shouldContinue(EnvironmentModel m){
        return hasNext() && m != null;
    }

    @Override
    public void setNext(IChainable next) {
        this.next = next;
    }

    @Override
    public IChainable getNext() {
        return next;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    abstract EnvironmentModel processModel(EnvironmentModel model);
}
