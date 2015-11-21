package ai;

import ai.model.EnvironmentModel;

/**
 * This interface represents a contract for objects that can be connected in a chain.
 * Each chainable object should be able to be connected to another via the setNext method.
 * Each object should also be able to accept an object of type EnvironmentModel via the setNext() method.
 * Created by raghavnarula on 03/11/2015.
 */
public interface IChainable {
    void put (EnvironmentModel model);
    void setNext(IChainable next);
    IChainable getNext();
    boolean hasNext();
}
