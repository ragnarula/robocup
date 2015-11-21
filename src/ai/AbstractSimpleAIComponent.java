package ai;

import ai.model.EnvironmentModel;

/**
 * This abstract class is used to build AI Components which process EnvironmentModels synchronously.
 * It provides one abstract method which accepts an EnvironmentModel needs to return an EnvironmentModel.
 * Created by raghavnarula on 03/11/2015.
 */
public abstract class AbstractSimpleAIComponent implements IChainable{

    private IChainable next;

    public AbstractSimpleAIComponent(){}

    public AbstractSimpleAIComponent(IChainable next){
        this.next = next;
    }

    /**
     * This method takes the model it is given and passes it to processModel, which in turn returns a model.
     * If this instance of IChainable has a next set, then the model is passed on the the next component in the
     * chain.
     * Note, this method is synchronous and will not return until all synchronous components in the chain have
     * processed the model.
     * @param model The model to be processed.
     */
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

    protected abstract EnvironmentModel processModel(EnvironmentModel model);
}
