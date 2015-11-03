package ai;

import ai.model.EnvironmentModel;

/**
 * Created by raghavnarula on 03/11/2015.
 */
public interface IChainable {
    void put (EnvironmentModel model);
    void setNext(IChainable next);
    IChainable getNext();
    boolean hasNext();
}
