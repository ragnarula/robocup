package ai;

import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public abstract class AbstractSimpleAIComponent implements IChainable{

    private IChainable next;

    public AbstractSimpleAIComponent(){};

    public AbstractSimpleAIComponent(IChainable next){
        this.next = next;
    }

    @Override
    public void put(EnvironmentModel model) {
        processModel(model);
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

    abstract void processModel(EnvironmentModel model);
}
